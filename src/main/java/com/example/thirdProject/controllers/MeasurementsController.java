package com.example.thirdProject.controllers;

import com.example.thirdProject.dtos.MeasurementDto;
import com.example.thirdProject.exceptions.MeasurementNotValidException;
import com.example.thirdProject.mappers.MeasurementMapper;
import com.example.thirdProject.services.MeasurementService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/measurements")
@AllArgsConstructor
public class MeasurementsController {
    private final MeasurementService measurementService;
    private final MeasurementMapper measurementMapper;

    @GetMapping
    public ResponseEntity<List<MeasurementDto>> getAllMeasurements()
    {
        var measurements = measurementService.findAll();
        if (measurements.isEmpty()){
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
        }
        var a = measurementMapper.toListDto(measurements);
        return new ResponseEntity<>(measurementMapper.toListDto(measurements), HttpStatus.OK);
    }

    @GetMapping("/rainyDaysCount")
    public ResponseEntity<Integer> getRainyDaysCount()
    {
        return new ResponseEntity<>(measurementService.rainyDaysCount(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MeasurementDto> addMeasurement(@RequestBody @Valid MeasurementDto measurementDto,
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
            throw new MeasurementNotValidException(errorMessage.toString());
        }
        measurementService.save(measurementMapper.toEntity(measurementDto));
        return new ResponseEntity<>(measurementDto, HttpStatus.OK);
    }
}
