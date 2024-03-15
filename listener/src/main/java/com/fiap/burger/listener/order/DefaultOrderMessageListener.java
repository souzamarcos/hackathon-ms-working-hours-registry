package com.fiap.burger.listener.order;

import com.fiap.burger.controller.adapter.api.PaymentController;
import com.fiap.burger.usecase.misc.exception.OrderMessageListenerException;
import com.fiap.burger.usecase.misc.profiles.NotTest;
import com.fiap.burger.usecase.misc.profiles.Production;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Production
@NotTest
@Component
public class DefaultOrderMessageListener {
    @Autowired
    PaymentController paymentController;

    @SqsListener(value = "${cloud.aws.sqs.order-queue}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    @Transactional
    public void orderQueueListener(String message) {
        try {
            var dto = new Gson().fromJson(message, OrderMessageListenerDto.class);
            paymentController.insert(dto.getId());
        } catch (Exception ex) {
            throw new OrderMessageListenerException(ex.getMessage());
        }
    }
}
