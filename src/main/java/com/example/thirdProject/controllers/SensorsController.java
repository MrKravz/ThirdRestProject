package com.example.thirdProject.controllers;

import com.example.thirdProject.dtos.SensorDto;
import com.example.thirdProject.exceptions.SensorNotValidException;
import com.example.thirdProject.mappers.SensorMapper;
import com.example.thirdProject.services.SensorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensors")
@AllArgsConstructor
public class SensorsController {

    private final SensorService sensorService;
    private final SensorMapper sensorMapper;

    @PostMapping("/registration")
    public ResponseEntity<SensorDto> createSensor(@RequestBody @Valid SensorDto sensorDto,
                                               BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (var error : errors) {
                errorMessage.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }
            throw new SensorNotValidException(errorMessage.toString());
        }
        sensorService.save(sensorMapper.toEntity(sensorDto));
        return new ResponseEntity<>(sensorDto, HttpStatus.OK);
    }
}
