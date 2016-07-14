package org.kumuluzee.datatypeadapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

	@Override
	public LocalDate unmarshal(String v) throws Exception {
		return LocalDate.parse(v, DateTimeFormatter.ISO_DATE);
	}

	@Override
	public String marshal(LocalDate v) throws Exception {
		return v.format(DateTimeFormatter.ISO_DATE);
	}

}
