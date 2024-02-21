package com.cleaningegneria.Application.Repository;

import com.cleaningegneria.Application.Models.Entity.Post;
import com.cleaningegneria.Application.Models.Entity.Utente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
@Transactional
public interface UtenteRepository extends CrudRepository<Utente,Integer> {
    @Modifying
    @Query("update Utente u set u.ruolo = ?1 where u.id = ?2")
    void setRuolo(String ruolo, Integer userId);

    //metodo per il db che setta il pending a true
    @Modifying
    @Query(value = "update Post p set p.pending = 0 where p.id = ?1", nativeQuery = true)
    void GestionePending(int idPost);

    @Modifying
    @Query("DELETE FROM Post p WHERE p.utente = ?1")
    void eliminaPostDiUtenteById(Optional<Utente> utente);

    @Query("SELECT p FROM Post p WHERE p.utente = ?1")
    ArrayList<Post> selezionaPostDiUtenteById(Optional<Utente> utente);

    @Query("SELECT p FROM Post p JOIN Utente u ON p.utente.id = u.id WHERE u.Comune = ?1")
    ArrayList<Post> selezionaPostDiComune(String Comune);

}
