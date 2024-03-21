package com.fiap.hackathon.controller.controller;

import com.fiap.hackathon.controller.adapter.api.WorkingHoursRegistryController;
import com.fiap.hackathon.entity.WorkingHoursRegistry;
import com.fiap.hackathon.messenger.adapter.WorkingHoursRegistryMessenger;
import com.fiap.hackathon.usecase.adapter.usecase.WorkingHoursRegistryUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultWorkingHoursRegistryController implements WorkingHoursRegistryController {

    @Autowired
    private WorkingHoursRegistryUseCase useCase;
    @Autowired
    private WorkingHoursRegistryMessenger messenger;

    @Override
    public WorkingHoursRegistry insert(WorkingHoursRegistry workingHoursRegistry) {
        var persistedWorkingHourRegistry = useCase.insert(workingHoursRegistry);
        messenger.sendMessage(persistedWorkingHourRegistry);
        return persistedWorkingHourRegistry;
    }

}
