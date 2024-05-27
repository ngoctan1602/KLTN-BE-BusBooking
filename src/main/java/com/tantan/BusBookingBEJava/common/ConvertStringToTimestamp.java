package com.tantan.BusBookingBEJava.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;


public class ConvertStringToTimestamp {

    public Timestamp convert(String dateTimeRequest) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeRequest);
        ZoneId zoneId = ZoneId.of("Asia/Ho_Chi_Minh");

        // Convert to ZonedDateTime
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);

        // Convert to Timestamp
        return Timestamp.valueOf(zonedDateTime.toLocalDateTime());
    }
}
