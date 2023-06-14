package com.example.thirdProject.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "measurements")
public class Measurement {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    private float value;

    @Column(name = "raining")
    private boolean raining;

    @ManyToOne
    @JoinColumn(
            name = "sensors_id",
            referencedColumnName = "id"
    )
    @ToString.Exclude
    private Sensor sensor;
}
