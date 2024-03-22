package com.fiap.hackathon.listener.workinghour;

import com.fiap.hackathon.controller.adapter.WorkingHourController;
import com.fiap.hackathon.usecase.misc.exception.WorkingHourMessageListenerException;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("test")
@Component
public class InMemoryWorkingHourMessageListener {
    @Autowired
    WorkingHourController controller;

    public void workingHourQueueListener(String message) {
        try {
            var dto = new Gson().fromJson(message, WorkingHourMessageListenerDto.class);
            controller.insert(dto.toEntity());
        } catch (Exception ex) {
            throw new WorkingHourMessageListenerException(ex);
        }
    }
}
