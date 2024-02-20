package com.cleaningegneria.Application.Service;

import com.cleaningegneria.Application.Models.Entity.Evento;
import com.cleaningegneria.Application.Repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class EventoService {

    public final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository){
        this.eventoRepository = eventoRepository;
    }

    public String CreateEvento(String Desc, int IdUtente, Timestamp DataEvento){
        Evento Temp = new Evento(DataEvento,IdUtente,Desc);
        eventoRepository.save(Temp);
        return "EventoSalvato";
    }

    public Optional<Evento> findEventoById(int id){
        Optional<Evento> u = eventoRepository.findById(id);
        return u;
    }

}
