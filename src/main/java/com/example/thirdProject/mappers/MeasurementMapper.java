package com.example.thirdProject.mappers;

import com.example.thirdProject.dtos.MeasurementDto;
import com.example.thirdProject.models.Measurement;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {SensorMapper.class})
public interface MeasurementMapper extends CommonMapper<MeasurementDto, Measurement>{
    @Override
    @Mapping(source = "sensor", target = "sensorDto")
    MeasurementDto toDto(Measurement entity);

    @Override
    @Mapping(source = "sensorDto", target = "sensor")
    Measurement toEntity(MeasurementDto entity);
}
