package com.emse.spring.automacorp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SP_WINDOW")
public class WindowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "window_status_id", nullable = false)
    private SensorEntity windowStatus;

    @ManyToOne // Define bidirectional many-to-one relationship with RoomEntity
    @JoinColumn(name = "room_id", nullable = false) // Foreign key to RoomEntity
    private RoomEntity room;

    // Default constructor
    public WindowEntity() {
    }

    // Constructor with RoomEntity as parameter
    public WindowEntity(String name, SensorEntity windowStatus, RoomEntity room) {
        this.name = name;
        this.windowStatus = windowStatus;
        this.room = room;
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for windowStatus
    public SensorEntity getWindowStatus() {
        return windowStatus;
    }

    public void setWindowStatus(SensorEntity windowStatus) {
        this.windowStatus = windowStatus;
    }

    // Getter and Setter for room
    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }
}
