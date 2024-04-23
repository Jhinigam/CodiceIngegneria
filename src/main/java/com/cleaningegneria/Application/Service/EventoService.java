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

    /**
     * crea l'evento
     * @param Desc,IdUtente,DataEvento
     * @return la stringa "EventoSalvato" se l'evento è stato creato correttamente
     */
    public String CreaEvento(String Desc, int IdUtente, Timestamp DataEvento){
        Evento Temp = new Evento(DataEvento,IdUtente,Desc);
        eventoRepository.save(Temp);
        return "EventoSalvato";
    }

    /**
     * trova un evento tramite il suo id
     * @param iD
     * @return l'evento che ha quel id
     */
    public Optional<Evento> TrovaEventoDalID(int iD){
        Optional<Evento> u = eventoRepository.findById(iD);
        return u;
    }

}
