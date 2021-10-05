package com.martincarrion.videojuegosapp.services;

import com.martincarrion.videojuegosapp.entities.Categoria;
import com.martincarrion.videojuegosapp.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements BaseService<Categoria> {
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository a) {
        this.categoriaRepository = a;
    }

    @Override
    @Transactional
    public List<Categoria> findAll() throws Exception {
        try {
            List<Categoria> entities = categoriaRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Categoria findById(long id) throws Exception {
        try {
            Optional<Categoria> entityOptional = categoriaRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Categoria save(Categoria entity) throws Exception {
        try {
            Categoria categoria = categoriaRepository.save(entity);
            return categoria;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Categoria update(long id, Categoria entity) throws Exception {
        try {
            Optional<Categoria> entityOptional = categoriaRepository.findById(id);
            Categoria categoria = entityOptional.get();
            categoria = categoriaRepository.save(entity);
            return categoria;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(long id) throws Exception {
        try {
            Optional<Categoria> entityOptional = categoriaRepository.findById(id);
            if (!entityOptional.isEmpty()) {
                Categoria categoria = entityOptional.get();
                categoria.setActivo(!categoria.getActivo());
                categoriaRepository.save(categoria);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
