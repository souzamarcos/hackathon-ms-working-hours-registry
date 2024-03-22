package com.fiap.hackathon.usecase.usecase;

import com.fiap.hackathon.entity.WorkingHour;
import com.fiap.hackathon.usecase.adapter.gateway.WorkingHourGateway;
import com.fiap.hackathon.usecase.adapter.usecase.WorkingHourUseCase;


public class DefaultWorkingHourUseCase implements WorkingHourUseCase {

    private final WorkingHourGateway gateway;

    public DefaultWorkingHourUseCase(WorkingHourGateway gateway) {
        this.gateway = gateway;
    }

    public WorkingHour insert(WorkingHour workingHour) {
        return gateway.save(workingHour);
    }

}
