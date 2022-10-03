package com.ciclo3.reto.appreto3.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Data /*Para evitar setter y getter*/
@AllArgsConstructor /*Constructor con parametros*/
@NoArgsConstructor /*Constructor sin parametros*/
@Entity
@Table(name = "client")

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private String email;
    private String password;
    private String name;
    private int age;
}
