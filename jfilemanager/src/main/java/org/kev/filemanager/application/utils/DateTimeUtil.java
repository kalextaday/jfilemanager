package org.kev.filemanager.application.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class DateTimeUtil {

    public static LocalDateTime getLocalDateTime(long date) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(date),
                TimeZone.getDefault().toZoneId());
    }
}
