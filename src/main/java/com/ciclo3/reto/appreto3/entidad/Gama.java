package com.ciclo3.reto.appreto3.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gama")
public class Gama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

//el truco es esta anotacion onetomany q es, uno a muchos.
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "gama")
//Esta anotacion se hace para ignorar atributo y no quede en un ciclo o lucki infinito.
    @JsonIgnoreProperties("gama")
    private List<Car> cars;
}
