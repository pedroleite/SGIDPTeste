package br.com.pw.sgidp.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilData {

	public static boolean isDataValido(String date) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date parse = simpleDateFormat.parse(date);
			if (!simpleDateFormat.format(parse).equals(date)) {
				return false;
			}
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
}
