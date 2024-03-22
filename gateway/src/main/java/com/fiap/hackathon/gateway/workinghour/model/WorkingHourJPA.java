package com.fiap.hackathon.gateway.workinghour.model;

import com.fiap.hackathon.entity.WorkingHour;
import com.fiap.hackathon.gateway.misc.common.BaseDomainJPA;
import com.fiap.hackathon.usecase.misc.utils.DateTimeUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "working_hour")
@Entity
public class WorkingHourJPA extends BaseDomainJPA {
    @Column(name = "employee_id")
    String employeeId;

    @Column(name = "registry_date_time")
    LocalDateTime registryDateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkingHourJPA that = (WorkingHourJPA) o;
        return Objects.equals(id, that.id) && Objects.equals(employeeId, that.employeeId) && Objects.equals(registryDateTime, that.registryDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, registryDateTime);
    }

    @Override
    public String toString() {
        return "WorkingHourJPA{" +
            "id = " + id +
            ", employeeId='" + employeeId + '\'' +
            ", registryDateTime=" + registryDateTime +
            '}';
    }

    public WorkingHourJPA(String employeeId, LocalDateTime registryDateTime) {
        this.employeeId = employeeId;
        this.registryDateTime = registryDateTime;
    }

    public static WorkingHourJPA toJPA(WorkingHour workingHour) {
        return new WorkingHourJPA(
            workingHour.getEmployeeId(),
            DateTimeUtils.toLocalDateTime(workingHour.getRegistryDateTime())
        );
    }

    public WorkingHour toEntity() {
        return new WorkingHour(id, employeeId, DateTimeUtils.toInstant(registryDateTime));
    }
}