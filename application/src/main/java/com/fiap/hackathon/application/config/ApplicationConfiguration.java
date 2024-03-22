package com.fiap.hackathon.application.config;

import com.fiap.hackathon.usecase.adapter.gateway.WorkingHourGateway;
import com.fiap.hackathon.usecase.adapter.usecase.WorkingHourUseCase;
import com.fiap.hackathon.usecase.usecase.DefaultWorkingHourUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public WorkingHourUseCase workingHourUseCase(WorkingHourGateway workingHourGateway) {
        return new DefaultWorkingHourUseCase(workingHourGateway);
    }

}
