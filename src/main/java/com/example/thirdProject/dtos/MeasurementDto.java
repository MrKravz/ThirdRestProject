package com.example.thirdProject.dtos;

import com.example.thirdProject.models.Sensor;

public record MeasurementDto(float value, boolean raining, Sensor sensor) {
}
