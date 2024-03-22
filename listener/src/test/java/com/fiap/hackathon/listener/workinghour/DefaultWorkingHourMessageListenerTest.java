package com.fiap.hackathon.listener.workinghour;

import com.fiap.hackathon.controller.adapter.WorkingHourController;
import com.fiap.hackathon.entity.WorkingHour;
import com.fiap.hackathon.usecase.misc.exception.WorkingHourMessageListenerException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class DefaultWorkingHourMessageListenerTest {
    @InjectMocks
    DefaultWorkingHourMessageListener listener;

    @Mock
    WorkingHourController controller;

    @Test
    void shouldInsertWorkingHourWhenListening() {
        var workingHour = new WorkingHour("ABC001", Instant.MAX);
        var payloadSQS = "{\"employeeId\":\"ABC001\",\"registryDateTime\":\"+1000000000-12-31T23:59:59.999999999Z\"}";
        when(controller.insert(workingHour)).thenReturn(workingHour);

        listener.workingHourQueueListener(payloadSQS);

        verify(controller, times(1)).insert(workingHour);
    }

    @Test
    void shouldThrownOrderMessageListenerExceptionWhenExceptionInInserting() {
        var workingHour = new WorkingHour("ABC001", Instant.MAX);
        var payloadSQS = "{\"employeeId\":\"ABC001\",\"registryDateTime\":\"+1000000000-12-31T23:59:59.999999999Z\"}";
        var expected = new WorkingHourMessageListenerException("Mock Error");

        when(controller.insert(workingHour)).thenThrow(new RuntimeException("Mock Error"));

        WorkingHourMessageListenerException actual = assertThrows(WorkingHourMessageListenerException.class,
            () -> listener.workingHourQueueListener(payloadSQS));

        assertEquals(expected.getMessage(), actual.getMessage());

        verify(controller, times(1)).insert(workingHour);
    }

}
