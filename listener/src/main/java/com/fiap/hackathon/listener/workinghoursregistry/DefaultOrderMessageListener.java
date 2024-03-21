package com.fiap.hackathon.listener.workinghoursregistry;

import com.fiap.burger.listener.order.OrderMessageListenerDto;
import com.fiap.burger.usecase.misc.exception.OrderMessageListenerException;
import com.fiap.burger.usecase.misc.profiles.NotTest;
import com.fiap.burger.usecase.misc.profiles.Production;
import com.fiap.hackathon.controller.adapter.api.WorkingHoursRegistryController;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Production
@NotTest
@Component
public class DefaultWorkingHoursRegistryMessageListener {
    @Autowired
    WorkingHoursRegistryController workingHoursRegistryController;

    @KafkaListener(topics = "${kafka.topic.workinghours}", groupId = "${kafka.groupId.workinghours}")
    @Transactional
    public void consumeWorkingHoursData(String message) {
        try {
            var dto = new Gson().fromJson(message, OrderMessageListenerDto.class);
            workingHoursRegistryController.insert(dto.getId());
        } catch (Exception ex) {
            throw new OrderMessageListenerException(ex.getMessage());
        }
    }
}
