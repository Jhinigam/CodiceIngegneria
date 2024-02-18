package com.cleaningegneria.Application.Models.DTO;

import com.cleaningegneria.Application.Models.Entity.Ruolo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ModificaRuoloDTO {
    private int id;
    private Ruolo newRuolo;
}
