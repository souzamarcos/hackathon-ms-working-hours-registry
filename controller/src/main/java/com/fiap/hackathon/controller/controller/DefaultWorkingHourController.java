package com.fiap.hackathon.controller.controller;

import com.fiap.hackathon.controller.adapter.WorkingHourController;
import com.fiap.hackathon.entity.WorkingHour;
import com.fiap.hackathon.usecase.adapter.usecase.WorkingHourUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultWorkingHourController implements WorkingHourController {

    @Autowired
    private WorkingHourUseCase useCase;

    @Override
    public WorkingHour insert(WorkingHour workingHour) {
        return useCase.insert(workingHour);
    }

}
