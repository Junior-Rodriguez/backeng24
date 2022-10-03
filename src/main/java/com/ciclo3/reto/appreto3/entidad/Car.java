package com.ciclo3.reto.appreto3.entidad;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String brand;
    private int año;
    private String description;
//Anotacion q indica de muchos a uno en E/R
    @ManyToOne
//Esta es una columna q va ser la foren key, don va ser la relacion.
    @JoinColumn(name = "gama_id_gama")
//Para q ignore al atributo cars cuando llame a Gama.
    @JsonIgnoreProperties("cars")
    private Gama gama;
}
