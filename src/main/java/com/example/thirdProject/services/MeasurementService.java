package com.example.thirdProject.services;

import com.example.thirdProject.models.Measurement;
import com.example.thirdProject.repositories.MeasurementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class MeasurementService implements CrudService<Measurement> {
    private final MeasurementRepository measurementRepository;

    @Override
    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    @Override
    public Measurement findById(int id) {
        return measurementRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public Measurement save(Measurement entity) {
        return measurementRepository.save(entity);
    }

    @Override
    @Transactional
    public Measurement update(Measurement entity, int id) {
        var entityToUpdate = measurementRepository.findById(id).orElseThrow(RuntimeException::new);
        entityToUpdate.setValue(entity.getValue());
        entityToUpdate.setRaining(entity.isRaining());
        entityToUpdate.setSensor(entityToUpdate.getSensor());
        return measurementRepository.save(entityToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        measurementRepository.deleteById(id);
    }
}
