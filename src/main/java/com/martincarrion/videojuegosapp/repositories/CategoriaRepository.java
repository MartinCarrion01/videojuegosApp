package com.martincarrion.videojuegosapp.repositories;

import com.martincarrion.videojuegosapp.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
