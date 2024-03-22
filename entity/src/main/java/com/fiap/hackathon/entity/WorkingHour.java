package com.fiap.hackathon.entity;


import java.time.Instant;
import java.util.Objects;

public class WorkingHour {
    private Long id;
    private String employeeId;
    private Instant registryDateTime;

    public WorkingHour(Long id, String employeeId, Instant registryDateTime) {
        this.id = id;
        this.employeeId = employeeId;
        this.registryDateTime = registryDateTime;
    }

    public WorkingHour(String employeeId, Instant registryDateTime) {
        this.employeeId = employeeId;
        this.registryDateTime = registryDateTime;
    }

    public Long getId() {
        return id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Instant getRegistryDateTime() {
        return registryDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkingHour that = (WorkingHour) o;
        return Objects.equals(id, that.id) && Objects.equals(employeeId, that.employeeId) && Objects.equals(registryDateTime, that.registryDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, registryDateTime);
    }

    @Override
    public String toString() {
        return "WorkingHour{" +
            "id=" + id +
            ", employeeId='" + employeeId + '\'' +
            ", registryDateTime=" + registryDateTime +
            '}';
    }
}