package com.cleaningegneria.Application.Repository;

import com.cleaningegneria.Application.Models.Entity.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends CrudRepository<Utente,Integer> {
}
