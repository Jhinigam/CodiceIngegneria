package com.cleaningegneria.Application.Repository;

import com.cleaningegneria.Application.Models.Entity.Utente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface UtenteRepository extends CrudRepository<Utente,Integer> {
    @Modifying
    @Query("update Utente u set u.ruolo = ?1 where u.id = ?2")
    void setRuolo(String ruolo, Integer userId);

    //metodo per il db che setta il pending a true
    @Modifying
    @Query("update Post p set p.pending = 0 where p.id = ?1")
    void GestionePending(int idPost);

    @Modifying
    @Query("DELETE FROM Post p WHERE p.utente = ?1")
    void eliminaPostDiUtenteById(Optional<Utente> utente);
}
