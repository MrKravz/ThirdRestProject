package com.example.thirdProject.services;

import com.example.thirdProject.exceptions.SensorNotFoundException;
import com.example.thirdProject.models.Sensor;
import com.example.thirdProject.repositories.SensorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class SensorService implements CrudService<Sensor> {
    private final SensorRepository sensorRepository;

    @Override
    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    @Override
    public Sensor findById(int id) {
        return sensorRepository.findById(id).orElseThrow(SensorNotFoundException::new);
    }

    public Sensor findByName(String name) {
        return sensorRepository.findByName(name).orElseThrow(SensorNotFoundException::new);
    }

    @Override
    @Transactional
    public Sensor save(Sensor entity) {
        return sensorRepository.save(entity);
    }

    @Override
    @Transactional
    public Sensor update(Sensor entity, int id) {
        var entityToUpdate = sensorRepository.findById(id).orElseThrow(SensorNotFoundException::new);
        entityToUpdate.setName(entity.getName());
        return sensorRepository.save(entityToUpdate);
    }

    @Override
    @Transactional
    public void delete(int id) {
        sensorRepository.deleteById(id);
    }
}
