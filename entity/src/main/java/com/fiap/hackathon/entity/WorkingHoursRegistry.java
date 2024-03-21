package com.fiap.hackathon.entity;


import java.time.Instant;

public record WorkingHoursRegistry(

        Long id,
        String employeeId,
        Instant registryDateTime
) {}