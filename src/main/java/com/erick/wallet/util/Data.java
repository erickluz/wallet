package com.erick.wallet.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {
	
	public Data() {
		
	}
	
	public static Date paraData(String data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-aaaa HH:mm");
		Date dataC;		
		try {
			dataC = sdf.parse(data);
		} catch (ParseException e) {
			dataC = new Date();
		}
		
		return dataC;
	}

}
