package com.martincarrion.videojuegosapp.repositories;

import com.martincarrion.videojuegosapp.entities.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
    @Query(value = "SELECT * FROM videojuego WHERE videojuego.activo = true", nativeQuery = true)
    List<Videojuego> findAllByActivo();

    @Query(value = "SELECT * FROM videojuego WHERE videojuego.id = :id AND videojuego.activo = true", nativeQuery = true)
    Optional<Videojuego> findByIdAndActivo(@Param("id") long id);

    @Query(value = "SELECT * FROM videojuego WHERE videojuego.titulo LIKE %:q% AND videojuego.activo = true", nativeQuery = true)
    List<Videojuego> findByTitle(@Param("q") String q);
}
