package calender;

public class calender {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

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

		// get weekday automatically
		int weekday = 365 * (year - 1);
		if (isLeapYear(year)) {
			for (int i = 0; i < month-1; i++) {
				weekday += LEAP_MAX_DAYS[i];
			}
		} else {
			for (int i = 0; i < month-1; i++) {
				weekday += MAX_DAYS[i];
			}
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
//		System.out.println(" 1  2  3  4  5  6  7");
//		System.out.println(" 8  9 10 11 12 13 14");
//		System.out.println("15 16 17 18 19 20 21");
//		System.out.println("22 23 24 25 26 27 28");
	}

}
