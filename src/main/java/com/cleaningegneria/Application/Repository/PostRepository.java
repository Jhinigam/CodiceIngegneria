package com.cleaningegneria.Application.Repository;

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
public interface PostRepository extends CrudRepository<Post,Integer>{
    @Query("SELECT p FROM Post p WHERE p.pending = true")
    ArrayList<Post> VisualizzaPostPending();



}
