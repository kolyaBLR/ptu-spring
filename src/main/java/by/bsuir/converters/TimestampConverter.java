package by.bsuir.converters;

import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;

public class TimestampConverter implements Converter<String, Timestamp> {
    @Override
    public Timestamp convert(String timeStampString) {
        try {
            return Timestamp.valueOf(timeStampString.replace('T', ' ') + ":00");
        } catch (IllegalArgumentException e)
        {
            return null;
        }
    }
}
