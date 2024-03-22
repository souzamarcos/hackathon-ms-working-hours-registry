package com.fiap.hackathon.usecase.usecase;

import com.fiap.hackathon.entity.WorkingHour;
import com.fiap.hackathon.usecase.adapter.gateway.WorkingHourGateway;
import com.fiap.hackathon.usecase.adapter.usecase.WorkingHourUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DefaultWorkingHourUseCaseTest {

    @Mock
    WorkingHourGateway gateway;

    @InjectMocks
    DefaultWorkingHourUseCase useCase;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Nested
    class insert {
        @Test
        void shouldInsert() {
            var workingHour = new WorkingHour("ABC001", Instant.ofEpochSecond(1710979200));

            when(gateway.save(workingHour)).thenReturn(workingHour);

            var actual = useCase.insert(workingHour);

            assertEquals(workingHour, actual);

            verify(gateway).save(workingHour);
        }
    }

}
