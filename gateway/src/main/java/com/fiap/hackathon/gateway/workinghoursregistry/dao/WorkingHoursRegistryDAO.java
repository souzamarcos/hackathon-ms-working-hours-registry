package com.fiap.hackathon.gateway.workinghoursregistry.dao;


import com.fiap.burger.entity.payment.PaymentStatus;
import com.fiap.burger.gateway.payment.model.PaymentJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface WorkingHoursRegistryDAO extends JpaRepository<WorkingHOursRegistryJPA, Long> {
}
