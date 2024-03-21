package com.fiap.hackathon.gateway.workinghoursregistry.model;

import com.fiap.burger.entity.payment.Payment;
import com.fiap.burger.entity.payment.PaymentStatus;
import com.fiap.burger.gateway.misc.common.BaseDomainJPA;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "workingHours")
@Entity
public class WorkingHoursRegistryJPA extends BaseDomainJPA {

    @Column(name = "id")
    Long id;

    @Column
    String employeeId;

    @Column
    Instant Instant;

    public WorkingHoursRegistryJPA() {

    }

    public WorkingHoursRegistryJPA(
        Long id,
        Long orderId,
        PaymentStatus status,
        String qrCode,
        String externalId,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt,
        LocalDateTime deletedAt
    ) {
        this.id = id;
        this.orderId = orderId;
        this.status = status;
        this.qrCode = qrCode;
        this.externalId = externalId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.deletedAt = deletedAt;
    }

    public static WorkingHoursRegistryJPA toJPA(Payment payment) {
        return new WorkingHoursRegistryJPA(
            payment.getId(),
            payment.getOrderId(),
            payment.getStatus(),
            payment.getQrCode(),
            payment.getExternalId(),
            payment.getCreatedAt(),
            payment.getModifiedAt(),
            payment.getDeletedAt()
        );
    }

    public Payment toEntity() {
        return new Payment(id, orderId, status, qrCode, externalId, createdAt, modifiedAt, deletedAt);
    }
}