package com.martincarrion.videojuegosapp.services;

import com.martincarrion.videojuegosapp.entities.Videojuego;
import com.martincarrion.videojuegosapp.repositories.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VideojuegoService implements BaseService<Videojuego> {

    @Autowired
    private VideojuegoRepository videojuegoRepository;


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
    public Videojuego findById(long id) throws Exception {
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
            Videojuego videojuego = videojuegoRepository.save(entity);
            return videojuego;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Videojuego update(long id, Videojuego entity) throws Exception {
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
    public boolean delete(long id) throws Exception {
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
    public Videojuego findByIdAndActivo(long id) throws Exception {
        try {
            Optional<Videojuego> optional = videojuegoRepository.findByIdAndActivo(id);
            return optional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Videojuego> findByTitle(String q) throws Exception {
        try {
            List<Videojuego> entities = this.videojuegoRepository.findByTitle(q);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
