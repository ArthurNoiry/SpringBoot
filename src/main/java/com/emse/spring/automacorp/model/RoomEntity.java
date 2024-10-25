package com.emse.spring.automacorp.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "SP_ROOM") // Custom table name
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the ID
    private Long id;

    @Column(nullable = false) // Non-nullable floor
    private Integer floor;

    @Column(nullable = false) // Non-nullable name
    private String name;

    @ManyToOne // Room has a Many-to-One relationship with SensorEntity for current temperature
    @JoinColumn(name = "current_temperature_id", nullable = false) // Foreign key column for current temperature, non-nullable
    private SensorEntity currentTemperature;

    @Column // Target temperature
    private Double targetTemperature;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true) // Bidirectional relationship with WindowEntity
    private List<WindowEntity> windows;

    // Default constructor
    public RoomEntity() {
    }

    // Constructor with non-nullable fields
    public RoomEntity(Integer floor, String name, SensorEntity currentTemperature) {
        this.floor = floor;
        this.name = name;
        this.currentTemperature = currentTemperature;
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for floor
    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for currentTemperature
    public SensorEntity getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(SensorEntity currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    // Getter and Setter for targetTemperature
    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    // Getter and Setter for windows
    public List<WindowEntity> getWindows() {
        return windows;
    }

    public void setWindows(List<WindowEntity> windows) {
        this.windows = windows;
    }
}
