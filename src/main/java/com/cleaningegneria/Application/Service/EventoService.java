package com.cleaningegneria.Application.Service;

import com.cleaningegneria.Application.Models.Entity.Evento;
import com.cleaningegneria.Application.Models.Entity.Post;
import com.cleaningegneria.Application.Repository.EventoRepository;

import java.sql.Timestamp;
import java.util.Optional;

public class EventoService {

    public final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository){
        this.eventoRepository = eventoRepository;
    }

    public String CreateEvento(String Desc, int IdUtente, boolean Pending, Timestamp dataInizio, Timestamp dataFine){
        Evento Temp = new Evento(dataInizio,dataFine,IdUtente,Desc);
        eventoRepository.save(Temp);
        return "EventoSalvato";
    }

    public Optional<Evento> findUtente(int id){
        Optional<Evento> u = eventoRepository.findById(id);
        return u;
    }

}
