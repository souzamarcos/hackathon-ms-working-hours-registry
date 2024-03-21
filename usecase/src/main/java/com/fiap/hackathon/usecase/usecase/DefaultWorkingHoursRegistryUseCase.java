package com.fiap.hackathon.usecase.usecase;

import com.fiap.hackathon.entity.WorkingHoursRegistry;
import com.fiap.hackathon.usecase.adapter.gateway.WorkingHoursRegistryGateway;
import com.fiap.hackathon.usecase.adapter.usecase.WorkingHoursRegistryUseCase;
import org.springframework.beans.factory.annotation.Autowired;



public class DefaultWorkingHoursRegistryUseCase implements WorkingHoursRegistryUseCase {

    @Autowired
    private WorkingHoursRegistryGateway workingHoursRegistryGateway;


    public WorkingHoursRegistry insert(WorkingHoursRegistry workingHoursRegistry) {
        return workingHoursRegistryGateway.save(workingHoursRegistry);
    }

}
