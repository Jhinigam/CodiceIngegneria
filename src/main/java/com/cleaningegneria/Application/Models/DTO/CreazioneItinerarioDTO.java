package com.cleaningegneria.Application.Models.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreazioneItinerarioDTO {
    private int idUtente;

    private int idPost;

    @NotNull(message = "Il nome non può essere nullo")
    private String descrizione;
}
