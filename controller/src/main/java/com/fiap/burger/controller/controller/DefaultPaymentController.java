package com.fiap.burger.controller.controller;

import com.fiap.burger.controller.adapter.api.PaymentController;
import com.fiap.burger.entity.payment.Payment;
import com.fiap.burger.entity.payment.PaymentStatus;
import com.fiap.burger.messenger.adapter.PaymentMessenger;
import com.fiap.burger.usecase.adapter.gateway.PaymentGateway;
import com.fiap.burger.usecase.adapter.usecase.PaymentUseCase;
import com.fiap.burger.usecase.misc.exception.PaymentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DefaultPaymentController implements PaymentController {

    @Autowired
    private PaymentUseCase useCase;
    @Autowired
    private PaymentGateway gateway;
    @Autowired
    private PaymentMessenger messenger;
    @Override
    public Payment findById(Long id) {
        var persistedPayment = useCase.findById(id);
        if (persistedPayment == null) throw new PaymentNotFoundException(id);
        return persistedPayment;
    }

    @Override
    public List<Payment> findByOrderId(Long orderId) {
        var persistedPayment = useCase.findByOrderId(orderId);
        if (persistedPayment == null) throw new PaymentNotFoundException();
        return persistedPayment;
    }

    @Override
    public Payment insert(Long orderId) {
        var persistedPayment = useCase.insert(orderId);
        messenger.sendMessage(persistedPayment);
        return persistedPayment;
    }

    @Override
    @Transactional
    public void updateStatus(Long id, PaymentStatus status) {
        var persistedPayment = useCase.updateStatus(id, status);
        messenger.sendMessage(persistedPayment);
    }
}
