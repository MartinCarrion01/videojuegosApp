package com.martincarrion.videojuegosapp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @NotEmpty(message = "Titulo no puede ser vacío")
    @Column(name = "titulo")
    private String titulo;

    @Size(min = 5, max = 100, message = "La descripcion debe ser de entre 5 y 100 caracteres")
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "imagen")
    private String imagen;

    @Min(value = 5, message = "El precio debe tener un minimo de 5")
    @Max(value = 10000, message = "El precio debe ser menor a 1000")
    @Column(name = "precio")
    private float precio;

    @Min(value = 1, message = "El stock debe tener un minimo de 5")
    @Max(value = 10000, message = "El stock debe ser menor a 1000")
    @Column(name = "stock")
    private short stock;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "La fecha no puede ser nula")
    @PastOrPresent(message = "Debe ser igual o menor a la fecha de hoy")
    @Column(name = "fecha_lanzamiento")
    private Date fechaLanzamiento;

    @Column(name = "activo")
    private Boolean activo = true;

    @NotNull(message = "El estudio no debe ser nulo")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estudio_ID", nullable = false)
    private Estudio estudio;

    @NotNull(message = "La categoria no debe ser nula")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_ID", nullable = false)
    private Categoria categoria;

}