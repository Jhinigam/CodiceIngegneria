package com.cleaningegneria.Application.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class AggiungiPostAItinerarioDTO {
    private int idItinerario;
    private int idPost;
}
