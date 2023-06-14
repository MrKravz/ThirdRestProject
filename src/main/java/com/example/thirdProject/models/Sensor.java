package com.example.thirdProject.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Data
@Entity
@Table(name = "sensors")
public class Sensor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "sensor")
    @ToString.Exclude
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Measurement> measurements;
}
