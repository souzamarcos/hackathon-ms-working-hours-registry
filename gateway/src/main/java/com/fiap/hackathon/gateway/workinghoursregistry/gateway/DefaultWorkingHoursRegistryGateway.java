package com.fiap.hackathon.gateway.workinghoursregistry.gateway;

import com.fiap.burger.entity.payment.Payment;
import com.fiap.burger.entity.payment.PaymentStatus;
import com.fiap.burger.gateway.payment.dao.PaymentDAO;
import com.fiap.burger.gateway.payment.model.PaymentJPA;
import com.fiap.burger.usecase.adapter.gateway.PaymentGateway;
import com.fiap.hackathon.entity.WorkingHoursRegistry;
import com.fiap.hackathon.usecase.adapter.gateway.WorkingHoursRegistryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;


@Repository
public class DefaultWorkingHoursRegistryGateway implements WorkingHoursRegistryGateway {
    @Autowired
    PaymentDAO paymentDAO;

    @Override
    public WorkingHoursRegistry save(WorkingHoursRegistry workingHoursRegistry) {
        return paymentDAO.save(PaymentJPA.toJPA(payment)).toEntity();
    }

}

