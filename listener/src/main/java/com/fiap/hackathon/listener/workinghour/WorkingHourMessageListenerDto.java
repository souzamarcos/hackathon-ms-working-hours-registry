package com.fiap.hackathon.listener.workinghour;

import com.fiap.hackathon.entity.WorkingHour;

import java.time.Instant;

public class  WorkingHourMessageListenerDto {
    private String employeeId;
    private Instant registryDateTime;

    public WorkingHour toEntity() {
        return new WorkingHour(employeeId, registryDateTime);
    }
}
