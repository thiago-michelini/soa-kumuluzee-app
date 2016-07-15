package org.kumuluzee.datatypeadapter;

import java.sql.Date;
import java.time.LocalDate;
//import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LocalDateToSQLDate implements AttributeConverter<LocalDate, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDate ld) {
		return (null == ld ? null : Date.valueOf(ld));
	}

	@Override
	public LocalDate convertToEntityAttribute(Date d) {
		return (null == d ? null : d.toLocalDate());
	}

}
