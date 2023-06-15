package com.example.thirdProject.services;

import com.example.thirdProject.exceptions.MeasurementNotFoundException;
import com.example.thirdProject.exceptions.SensorNotFoundException;
import com.example.thirdProject.models.Measurement;
import com.example.thirdProject.repositories.MeasurementRepository;
import com.example.thirdProject.repositories.SensorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class MeasurementService implements CrudService<Measurement> {
    private final MeasurementRepository measurementRepository;
    private final SensorRepository sensorRepository;

    @Override
    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    @Override
    public Measurement findById(int id) {
        return measurementRepository.findById(id).orElseThrow(MeasurementNotFoundException::new);
    }

    @Override
    @Transactional
    public Measurement save(Measurement entity) {
        var sensor = sensorRepository.findByName(entity.getSensor().getName()).orElseThrow(SensorNotFoundException::new);
        entity.setSensor(sensor);
        return measurementRepository.save(entity);
    }

    @Override
    @Transactional
    public Measurement update(Measurement entity, int id) {
        var entityToUpdate = measurementRepository.findById(id).orElseThrow(MeasurementNotFoundException::new);
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

    public int rainyDaysCount()
    {
        return findAll()
                .stream()
                .filter(x->x.isRaining())
                .toList()
                .size();
    }
}
