package com.martincarrion.videojuegosapp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Table(name = "videojuego")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Videojuego {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "precio")
    private float precio;

    @Column(name = "stock")
    private short stock;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_lanzamiento")
    private Date fechaLanzamiento;

    @Column(name = "activo")
    private Boolean activo = true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estudio_ID", nullable = false)
    private Estudio estudio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_ID", nullable = false)
    private Categoria categoria;

}