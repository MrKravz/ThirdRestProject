package com.example.thirdProject.mappers;

import com.example.thirdProject.dtos.MeasurementDto;
import com.example.thirdProject.dtos.SensorDto;
import com.example.thirdProject.models.Measurement;
import com.example.thirdProject.models.Sensor;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SensorMapper extends CommonMapper<SensorDto, Sensor>{
}
