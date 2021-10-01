package com.martincarrion.videojuegosapp.services;

import com.martincarrion.videojuegosapp.entities.Estudio;
import com.martincarrion.videojuegosapp.repositories.EstudioRepository;
import com.martincarrion.videojuegosapp.services.BaseService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EstudioService implements BaseService<Estudio> {
    private EstudioRepository estudioRepository;

    public EstudioService(EstudioRepository a) {
        this.estudioRepository = a;
    }

    @Override
    @Transactional
    public List<Estudio> findAll() throws Exception {
        try {
            List<Estudio> entities = estudioRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Estudio findById(Long id) throws Exception {
        try {
            Optional<Estudio> entityOptional = estudioRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Estudio save(Estudio entity) throws Exception {
        try {
            entity = estudioRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Estudio update(Long id, Estudio entity) throws Exception {
        try {
            Optional<Estudio> entityOptional = estudioRepository.findById(id);
            Estudio estudio = entityOptional.get();
            estudio = estudioRepository.save(entity);
            return estudio;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            Optional<Estudio> entityOptional = estudioRepository.findById(id);
            if (!entityOptional.isEmpty()) {
                Estudio estudio = entityOptional.get();
                estudio.setActivo(!estudio.getActivo());
                estudioRepository.save(estudio);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
