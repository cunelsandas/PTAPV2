package com.l2everseflash.ptapv2.calendar;


public interface onMFCalendarViewListener {

	void onDateChanged(String date);

	/**
	 * @param month first month is: 1 (January) and last month is: 12 (Dec)
	 * @param year
	 * @param monthStr provides local month name like January (English)
	 * */
	void onDisplayedMonthChanged(int month, int year, String monthStr);
	
}
