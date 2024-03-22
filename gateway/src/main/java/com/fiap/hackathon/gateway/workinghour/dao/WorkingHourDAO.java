package com.fiap.hackathon.gateway.workinghour.dao;


import com.fiap.hackathon.gateway.workinghour.model.WorkingHourJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingHourDAO extends JpaRepository<WorkingHourJPA, Long> {
}
