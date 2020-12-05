package calender;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		// 입력 : 키모드로 두 수의 입력을 받는다.
		// 출력 : 화면에 두 수의 합을 출력한다.
		// 이클립스 자동 줄정렬 : ctrl + shift + f
		int a, b;
		// ctrl + shift + n : 자동으로 import

		Scanner scanner = new Scanner(System.in);
		String s1, s2;
		System.out.println("두 수를 입력해주세요.");
		s1 = scanner.next();
		s2 = scanner.next();
		a = Integer.parseInt(s1);
		b = Integer.parseInt(s2);
		System.out.printf("%d와 %d의 합은 %d입니다.", a, b, a + b);

		// 내가 쓴 코드
//		String inputValue = scanner.next();
//		String[] splitValue = inputValue.split("");
//		a = Integer.parseInt(splitValue[0]);
//		b = Integer.parseInt(splitValue[1]);
//		int sumValue = a + b;
//		System.out.println(sumValue);

		scanner.close();
	}
}
