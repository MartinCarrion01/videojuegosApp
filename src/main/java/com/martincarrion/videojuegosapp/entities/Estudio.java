package com.martincarrion.videojuegosapp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "estudio")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "activo")
    private Boolean activo = true;

    @OneToMany(mappedBy = "estudio")
    private List<Videojuego> videojuegos;

}