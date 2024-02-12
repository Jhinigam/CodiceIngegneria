package com.cleaningegneria.Application.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="Comune")
public class Comune {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    private String nome;
    private String descrizione;
    public Comune(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;

    }
}
