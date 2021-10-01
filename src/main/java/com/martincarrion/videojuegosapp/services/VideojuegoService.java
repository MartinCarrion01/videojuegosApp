package com.martincarrion.videojuegosapp.services;

import com.martincarrion.videojuegosapp.entities.Videojuego;
import com.martincarrion.videojuegosapp.repositories.VideojuegoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VideojuegoService implements BaseService<Videojuego> {

    private VideojuegoRepository videojuegoRepository;

    public VideojuegoService(VideojuegoRepository a) {
        this.videojuegoRepository = a;
    }

    @Override
    @Transactional
    public List<Videojuego> findAll() throws Exception {
        try {
            List<Videojuego> entities = videojuegoRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Videojuego findById(Long id) throws Exception {
        try {
            Optional<Videojuego> entityOptional = videojuegoRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Videojuego save(Videojuego entity) throws Exception {
        try {
            entity = videojuegoRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Videojuego update(Long id, Videojuego entity) throws Exception {
        try {
            Optional<Videojuego> entityOptional = videojuegoRepository.findById(id);
            Videojuego videojuego = entityOptional.get();
            videojuego = videojuegoRepository.save(entity);
            return videojuego;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            Optional<Videojuego> entityOptional = videojuegoRepository.findById(id);
            if (!entityOptional.isEmpty()) {
                Videojuego videojuego = entityOptional.get();
                videojuego.setActivo(!videojuego.getActivo());
                videojuegoRepository.save(videojuego);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Videojuego> findAllByActivo() throws Exception {
        try {
            List<Videojuego> entities = videojuegoRepository.findAllByActivo();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Videojuego findByIdAndActivo(Long id) throws Exception {
        try {
            Optional<Videojuego> optional = videojuegoRepository.findByIdAndActivo(id);
            return optional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
