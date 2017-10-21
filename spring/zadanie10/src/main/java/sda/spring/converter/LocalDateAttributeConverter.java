package sda.spring.converter;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.stereotype.Component;

@Component
public class LocalDateAttributeConverter {
	
    public Date convert(LocalDate localDate) {
    	return (localDate == null ? null : Date.from(localDate.atStartOfDay().toInstant(ZoneOffset.UTC)));
    }

    public LocalDate convert(Date date) {
    	return (date == null ? null : LocalDate.from(date.toInstant()));
    }
}