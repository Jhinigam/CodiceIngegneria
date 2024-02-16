package com.cleaningegneria.Application.Models.DTO;

import jakarta.validation.constraints.Email;
import lombok.*;
import jakarta.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreazionePostBaseDTO {
    private int idUtente;

    @NotNull(message = "Il nome non può essere nullo")
    private String descrizione;
}
