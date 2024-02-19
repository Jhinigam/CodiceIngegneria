package com.cleaningegneria.Application.Models.DTO;

import jakarta.validation.constraints.Email;
import lombok.*;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreazioneEventoDTO {
    private int idUtente;

    @NotNull(message = "Il nome non può essere nullo")
    private String descrizione;

    private Timestamp dataInizio;
    private Timestamp dataFine;
}
