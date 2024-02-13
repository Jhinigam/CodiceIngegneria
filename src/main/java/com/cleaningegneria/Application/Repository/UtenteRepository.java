package com.cleaningegneria.Application.Repository;

import com.cleaningegneria.Application.Models.Entity.Utente;
import org.springframework.data.repository.CrudRepository;

public interface UtenteRepository extends CrudRepository<Utente,Long> {
}
