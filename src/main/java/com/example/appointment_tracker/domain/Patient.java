package com.example.appointment_tracker.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private Date lastAppointmentDate;

    private String location;

    private String status;


    public Patient() {
    }

    public Patient(Long id, String name, String email, Date lastAppointmentDate, String location, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lastAppointmentDate = lastAppointmentDate;
        this.location = location;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastAppointmentDate() {
        return lastAppointmentDate;
    }

    public void setLastAppointmentDate(Date lastAppointmentDate) {
        this.lastAppointmentDate = lastAppointmentDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", lastAppointmentDate=" + lastAppointmentDate +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
