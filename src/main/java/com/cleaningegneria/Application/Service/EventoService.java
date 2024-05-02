package com.cleaningegneria.Application.Service;

import com.cleaningegneria.Application.Models.Entity.CreatoreEvento;
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


    /**
     * crea l'evento
     * @param Desc,IdUtente,DataEvento
     * @return la stringa "EventoSalvato" se l'evento è stato creato correttamente
     */
    public String CreateEvento(String Desc, int IdUtente, Timestamp DataEvento){
        CreatoreEvento Temp = new CreatoreEvento(DataEvento);
        eventoRepository.save((Evento)Temp.CreaPost(IdUtente,Desc));
        return "EventoSalvato";
    }

    /**
     * trova un evento tramite il suo id
     * @param iD
     * @return l'evento che ha quel id
     */
    public Optional<Evento> findEventoById(int iD){
        Optional<Evento> u = eventoRepository.findById(iD);
        return u;
    }

}
