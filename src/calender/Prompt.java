package calender;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "cal> ";

	public void runPrompt() {
		String PROMPT = "cal> ";

		// 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		Scanner scanner = new Scanner(System.in);
		calender cal = new calender();
		System.out.println("반복 횟수를 입력하세요.");
		System.out.print("반복횟수 : ");
		int num = scanner.nextInt();
		int year;

		int i = 0;
		while (true) {
			System.out.println("연도를 입력하세요");
			System.out.print("YEAR> ");
			year = scanner.nextInt();
			System.out.println("달을 입력하세요");
			System.out.print(PROMPT);
			int month = scanner.nextInt();
			if (month == -1) {
				break;
			}
			if (month > 12) {
				continue;
			}

			cal.printCalendar(year, month);
			i++;
			if (i == num) {
				break;
			}
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
