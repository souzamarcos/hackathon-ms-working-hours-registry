package com.fiap.hackathon.usecase.misc.utils;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateTimeUtilsTest {

    @Test
    void shouldConvertInstantToLocalDateTime() {
        var instant = Instant.ofEpochSecond(1710979200);
        var expected = LocalDateTime.of(2024, 3, 21, 0, 0, 0, 0);

        var actual = DateTimeUtils.toLocalDateTime(instant);

        assertEquals(expected, actual);
    }

    @Test
    void shouldConvertLocalDateTimeToInstant() {
        var localDateTime = LocalDateTime.of(2024, 3, 21, 0, 0, 0, 0);
        var expected = Instant.ofEpochSecond(1710979200);

        var actual = DateTimeUtils.toInstant(localDateTime);

        assertEquals(expected, actual);
    }
}
