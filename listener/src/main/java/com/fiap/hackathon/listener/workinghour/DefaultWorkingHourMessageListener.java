package com.fiap.hackathon.listener.workinghour;

import com.fatboyindustrial.gsonjavatime.Converters;
import com.fiap.hackathon.controller.adapter.WorkingHourController;
import com.fiap.hackathon.usecase.misc.exception.WorkingHourMessageListenerException;
import com.fiap.hackathon.usecase.misc.profiles.NotTest;
import com.fiap.hackathon.usecase.misc.profiles.Production;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Production
@NotTest
@Component
public class DefaultWorkingHourMessageListener {

    @Autowired
    WorkingHourController controller;

    @SqsListener(value = "${cloud.aws.sqs.working-hour-queue}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    @Transactional
    public void workingHourQueueListener(String message) {
        try {
            var gson = Converters.registerInstant(new GsonBuilder()).create();
            var dto = gson.fromJson(message, WorkingHourMessageListenerDto.class);
            controller.insert(dto.toEntity());
        } catch (Exception ex) {
            throw new WorkingHourMessageListenerException(ex.getMessage());
        }
    }
}
