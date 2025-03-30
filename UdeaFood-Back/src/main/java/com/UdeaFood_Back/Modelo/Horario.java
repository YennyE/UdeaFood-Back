package com.UdeaFood_Back.Modelo;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;

@Entity
@Table(name = "Horario")
@Data
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "horario_1",nullable = false)
    private Time horario1;

    @Column(name = "horario_2",nullable = false)
    private Time horario2;

    @OneToOne(mappedBy = "horario", fetch = FetchType.EAGER)
    @JsonBackReference
    Tienda tienda;
}
