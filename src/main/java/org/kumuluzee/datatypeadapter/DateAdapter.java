package org.kumuluzee.datatypeadapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {

	private static SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	
	@Override
	public Date unmarshal(String v) throws Exception {
		return fmt.parse(v);
	}

	@Override
	public String marshal(Date v) throws Exception {
		return fmt.format(v);
	}

}
