package com.fiap.hackathon.gateway.workinghour.gateway;

import com.fiap.hackathon.entity.WorkingHour;
import com.fiap.hackathon.gateway.workinghour.dao.WorkingHourDAO;
import com.fiap.hackathon.gateway.workinghour.model.WorkingHourJPA;
import com.fiap.hackathon.usecase.adapter.gateway.WorkingHourGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultWorkingHourGateway implements WorkingHourGateway {
    @Autowired
    WorkingHourDAO dao;

    @Override
    public WorkingHour save(WorkingHour workingHour) {
        return dao.save(WorkingHourJPA.toJPA(workingHour)).toEntity();
    }
}

