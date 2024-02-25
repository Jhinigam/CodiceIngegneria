package com.cleaningegneria.Application.Models.DTO;

import lombok.*;
import jakarta.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreazionePostEItinerarioDTO {
    private int idUtente;

    @NotNull(message = "Il nome non può essere nullo")
    private String descrizione;
}
