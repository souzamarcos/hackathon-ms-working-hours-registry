package com.fiap.burger.gateway.payment.gateway;

import com.fiap.burger.entity.payment.Payment;
import com.fiap.burger.entity.payment.PaymentStatus;
import com.fiap.burger.gateway.payment.dao.PaymentDAO;
import com.fiap.burger.gateway.payment.model.PaymentJPA;
import com.fiap.burger.usecase.adapter.gateway.PaymentGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;


@Repository
public class DefaultPaymentGateway implements PaymentGateway {
    @Autowired
    PaymentDAO paymentDAO;

    @Override
    public Payment findById(Long id) {
        return paymentDAO.findById(id).map(PaymentJPA::toEntity).orElse(null);
    }


    @Override
    public List<Payment> findByOrderId(Long orderId) {
        if (orderId != null) {
            return paymentDAO.findAllByDeletedAtNullAndOrderId(orderId).stream().map(PaymentJPA::toEntity).toList();
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public Payment save(Payment payment) {
        return paymentDAO.save(PaymentJPA.toJPA(payment)).toEntity();
    }

    @Override
    public void updatePaymentStatus(Long id, PaymentStatus status, LocalDateTime modifiedAt) {
        paymentDAO.updatePaymentStatus(id, status, modifiedAt);
    }

}

