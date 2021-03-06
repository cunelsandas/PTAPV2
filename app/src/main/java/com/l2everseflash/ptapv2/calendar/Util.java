package com.l2everseflash.ptapv2.calendar;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


@SuppressLint("DefaultLocale")
public class Util {

	/**
	 * @param date yyyy-MM-dd (ex: 2017-12-26)
	 * @param hour HH:mm:ss (ex: 12:15:00)
	 * */
	public static String makePrettyDate(String date, String hour){
		String strDate = date + " " + hour;

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		Date d = null;
		try {
			d = formatter.parse(strDate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//		Log.d("","makePrettyDate::" +date);
		//		Log.d("","makePrettyDate::" );

		Calendar.getInstance().setTime(d);
		return String.format(new Locale("EN"),"%02d.%02d.%02d %02d:%02d",
				d.getDate(), d.getMonth() + 1, d.getYear(),
				d.getHours(), d.getMinutes());
	}

	/**
	 * @param date yyyy-MM-dd (ex: 2017-12-26)
	 * */
	public static String makePrettyDate(String date){
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM, yyyy");

			Date d = null;

			d = formatter.parse(date);


			//		Log.d("","makePrettyDate::" +date);
			//		Log.d("","makePrettyDate::" );

			Calendar.getInstance().setTime(d);
			return String.format(new Locale("EN"),"%02d.%02d.%02d",
					d.getDate(), d.getMonth() + 1, d.getYear()+1900);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}


	/**
	 * 
	 * @param date like 2017-12-17
	 * */
	public static long dateToLong(String date){

		SimpleDateFormat formatter =
				new SimpleDateFormat("EEEE, dd MMMM, yyyy", new Locale("EN"));

		Date d = null;
		try {
			d = formatter.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		} 

		Calendar c = Calendar.getInstance();
		c.setTime(d); 

		return c.getTimeInMillis();
	}


	/**
	 * @return 
	 * */
	public static String getCurrentDate(){
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("EEEE, dd MMMM, yyyy", new Locale("EN"));
		return df.format(c.getTime());
	}

	/**
	 * @param format "yyyy-MM-dd"
	 * */
	public static String getCurrentDate(String format){
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(format, new Locale("EN"));
		return df.format(c.getTime());
	}

	public static String getTomorrow(){
		long oneDay = 86400000; // 86400000 miliseconds equals 1 day
		long tomorrow = Util.dateToLong(Util.getCurrentDate()) + oneDay;
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(tomorrow));
		SimpleDateFormat df = new SimpleDateFormat("EEEE, dd MMMM, yyyy", getLocale());
		return df.format(c.getTime());
	}
	
	
	public static Locale getLocale(){
		return Locale.getDefault();
	}
}


