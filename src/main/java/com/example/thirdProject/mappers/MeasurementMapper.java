package com.example.thirdProject.mappers;

import com.example.thirdProject.dtos.MeasurementDto;
import com.example.thirdProject.models.Measurement;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MeasurementMapper extends CommonMapper<MeasurementDto, Measurement>{
}
