package com.fiap.hackathon.gateway.workinghour.gateway;

import com.fiap.hackathon.entity.WorkingHour;
import com.fiap.hackathon.gateway.workinghour.dao.WorkingHourDAO;
import com.fiap.hackathon.gateway.workinghour.model.WorkingHourJPA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DefaultWorkingHourGatewayTest {

    @Mock
    WorkingHourDAO dao;

    @InjectMocks
    DefaultWorkingHourGateway gateway;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldSave() {
        var workingHour = new WorkingHour("ABC001", Instant.ofEpochSecond(1710979200));
        var jpa = WorkingHourJPA.toJPA(workingHour);

        when(dao.save(jpa)).thenReturn(jpa);

        var actual = gateway.save(workingHour);

        assertEquals(workingHour, actual);

        verify(dao, times(1)).save(jpa);
    }



}
