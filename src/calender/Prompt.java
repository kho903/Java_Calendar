package calender;

import java.util.Scanner;

public class Prompt {
	/**
	 * 
	 * @param week 요일명
	 * @return 0 ~ 6 (0 = Sunday, 6 = Saturday_
	 */
	public int parseDay(String week) {
		if (week.equals("su")) return 0;
		else if(week.equals("mo")) return 1;
		else if(week.equals("tu")) return 2;
		else if(week.equals("we")) return 3;
		else if(week.equals("th")) return 4;
		else if(week.equals("fr")) return 5;
		else if(week.equals("sa")) return 6;
		else 
			return 0;
	}

	private final static String PROMPT = "cal> ";

	public void runPrompt() {

		// 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		Scanner scanner = new Scanner(System.in);
		calender cal = new calender();
		int year;
		int month;
		int weekday;

		while (true) {
			System.out.println("연도를 입력하세요(EXIT : -1)");
			System.out.print("YEAR> ");
			year = scanner.nextInt();
			if (year == -1) {
				break;
			}
			System.out.println("달을 입력하세요");
			System.out.print("cal> ");
			month = scanner.nextInt();
			
			if (month > 12 || month<1) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}

			cal.printCalendar(year, month);
		}
		System.out.println("완료.");
		scanner.close();
	}

	public static void main(String[] args) {
		// 쉘 실행
		Prompt p = new Prompt();
		p.runPrompt();
	}
}
