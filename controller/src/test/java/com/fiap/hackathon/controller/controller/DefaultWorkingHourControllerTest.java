package com.fiap.hackathon.controller.controller;

import com.fiap.hackathon.entity.WorkingHour;
import com.fiap.hackathon.usecase.adapter.usecase.WorkingHourUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DefaultWorkingHourControllerTest {
    @Mock
    WorkingHourUseCase useCase;

    @InjectMocks
    DefaultWorkingHourController controller;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Nested
    class insert {
        @Test
        void shouldInsertEmployee() {
            var workingHour = new WorkingHour("ABC001", Instant.MAX);

            when(useCase.insert(workingHour)).thenReturn(workingHour);

            WorkingHour actual = controller.insert(workingHour);

            assertEquals(workingHour, actual);

            verify(useCase, times(1)).insert(workingHour);
        }
    }
}
