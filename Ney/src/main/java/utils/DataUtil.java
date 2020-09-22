package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
	
	public static String getDia(Date data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		return sdf.format(data).substring(0, 2);
		
	}
	
	public static String getMes(Date data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		return sdf.format(data).substring(3, 5);
		
	}
	
	public static String getAno(Date data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		return sdf.format(data).substring(6);
		
	}

}
