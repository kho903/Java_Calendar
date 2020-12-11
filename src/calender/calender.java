package calender;

import java.util.Date;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class calender {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private HashMap <Date, String> planMap;
	
	public calender() {
		planMap = new HashMap<Date, String>();
	}
	

	/**
	 * 
	 * @param date ex: "2017-06-20"
	 * @param plan
	 * @throws ParseException
	 */

	public void registerPlan(String strDate, String plan) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
//		System.out.println(date);
		planMap.put(date, plan);

	}
	
	public String searchPlan(String strDate) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		String plan = planMap.get(date);
		return plan;
	}

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month - 1];
		} else {
			return MAX_DAYS[month - 1];
		}
	}

	public void printCalendar(int year, int month) {
		System.out.printf("  << %4d년%3d월 >>\n", year, month);
		System.out.println("   일     월     화     수     목     금     토");
		System.out.println("--------------------");

		int weekday = 1;
		// get weekday automatically
		for (int i = 1; i < year; i++) {
			if (isLeapYear(i)) {
				weekday += 366;
			} else {
				weekday += 365;
			}
		}
		for (int j = 0; j < month - 1; j++) {
			if (isLeapYear(year)) {
				weekday += LEAP_MAX_DAYS[j];
			} else
				weekday += MAX_DAYS[j];
		}
		weekday %= 7;

		// print blank space
		for (int i = 0; i < weekday; i++) {
			System.out.printf("    ");
		}
		int maxDay = getMaxDaysOfMonth(year, month);
		int count = 7 - weekday;
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d ", i);
		}
		System.out.println();

		// print from second line to last
		for (int i = count + 1; i <= maxDay; i++) {
			System.out.printf("%3d ", i);
			if ((i - count) % 7 == 0)
				System.out.println();
		}
		System.out.println();
		System.out.println();
	}

	// 강의
	// 1970년을 기준으로
	private int getWeekDay(int year, int month, int day) {
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4; // 1970/Jan/1st = Thursday

		int count = 0;

		for (int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}

		for (int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}

		count += day;

		int weekDay = (count + STANDARD_WEEKDAY) % 7;

		System.out.println(weekDay);
		return weekDay;
	}

	// simple test code here
	public static void main(String[] arge) throws ParseException {
		calender c = new calender();
		c.getWeekDay(1970, 1, 1);
		c.getWeekDay(1971, 1, 1);
		c.getWeekDay(1972, 1, 1);
		c.getWeekDay(1973, 1, 1);
		c.getWeekDay(1974, 1, 1);
		c.registerPlan("2017-06-23", "Let's eat beef!");
		System.out.println(c.searchPlan("2017-06-23").equals("Let's eat beef!"));
	}

}
