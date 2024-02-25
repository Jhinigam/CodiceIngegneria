package com.cleaningegneria.Application.Repository;


import com.cleaningegneria.Application.Models.Entity.Itinerario;
import com.cleaningegneria.Application.Models.Entity.Post;
import com.cleaningegneria.Application.Models.Entity.Utente;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Transactional
public interface ItinerarioRepository extends CrudRepository<Itinerario,Integer>{

    /*
    @Query("SELECT p FROM Itinerario p")
    ArrayList<Itinerario> VisualizzaItinerari();


    @Query("SELECT i FROM Itinerario i WHERE i.id = ?1")
    Itinerario VisualizzaItinerario(int itinerarioID);


    @Modifying
    @Query("UPDATE Itinerario i SET i.contenuti = CONCAT(i.contenuti, ?2) WHERE i.id = ?1")
    void aggiungiPostAItinerario(Integer idItinerario, int idPost);

     */
}


