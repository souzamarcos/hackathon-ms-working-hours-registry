package com.fiap.burger.messenger.payment;

import com.fiap.burger.entity.payment.Payment;
import com.fiap.burger.messenger.adapter.PaymentMessenger;
import com.fiap.burger.usecase.misc.profiles.NotTest;
import com.fiap.burger.usecase.misc.profiles.Production;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Production
@NotTest
@Service
public class DefaultPaymentMessenger implements PaymentMessenger {
    @Value("${cloud.aws.sqs.payment-queue}")
    private String queueName;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    public void sendMessage(Payment payment) {
        var dto = PaymentMessageDto.toDto(payment);
        this.queueMessagingTemplate.send(queueName, MessageBuilder.withPayload(new Gson().toJson(dto)).build());
    }
}
