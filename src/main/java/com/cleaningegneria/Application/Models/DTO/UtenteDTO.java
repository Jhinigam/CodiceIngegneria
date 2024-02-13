package com.cleaningegneria.Application.Models.DTO;

import jakarta.validation.constraints.Email;
import lombok.*;
import jakarta.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
public class UtenteDTO {

        @NotNull(message = "Il nome non può essere nullo")
        private String nome;

        @NotNull(message = "Il cognome non può essere nullo")
        private String cognome;

        @NotNull(message = "L'email non può essere nulla")
        @Email(message = "L'email deve essere valida")
        private String email;

        @NotNull(message = "Il comune non può essere nullo")
        private String comune;

        @NotNull(message = "L'età deve essere un numero valido")
        private int eta;

        //@Min(value = 0, message = "Il ruolo deve essere un numero compreso tra 0 e 5")
        private String ruolo;

}
