package com.cleaningegneria.Application.Repository;

import com.cleaningegneria.Application.Models.Entity.Utente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UtenteRepository extends CrudRepository<Utente,Integer> {
    @Modifying
    @Query("update Utente u set u.ruolo = ?1 where u.id = ?2")
    void setRuolo(String ruolo, Integer userId);
}
