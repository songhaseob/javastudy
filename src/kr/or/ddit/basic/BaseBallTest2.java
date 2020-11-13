package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class BaseBallTest2 {
	/*
	 * 문제) Set과 List를 이용하여 숫자 야구 게임 프로그램을 작성하시오 컴퓨터의 숫자는 난수를 이용하여 구한다 (스트라이크 S, 볼은
	 * B로 나타낸다.)
	 * 
	 * 예시) 컴퓨터 난수 ==> 9 5 7
	 * 
	 * 실행예시) 숫자를 입력 => 3 5 8 3 5 8 ==> 1S 0B 숫자를 입력 => 7 8 9 7 8 9 ==> 0S 2B 숫자입력 =>
	 * 9 7 5 9 7 5 ==> 1S 2B 숫자입력 => 9 5 7 9 5 7 ==> 3S 0B
	 * 
	 * 축하합니다. 당신은 4번째만에 맞췄습니다.
	 * 
	 * tip)난수 생성시 Set을 사용 -> Set에 있는 List를 Set에 담는다. 우리가 입력하는 데이터를 List에 저장을 한다
	 */
	public static void main(String[] args) {
		BaseBallTest2.start();
	}

	private static void start() {
		Scanner sc = new Scanner(System.in);

		System.out.println("===============================");
		System.out.println("야구게임을 시작합니다.");
		System.out.println("===============================");
		System.out.println("1. 게임시작\t2.게임종료");

		int input = sc.nextInt();

		switch (input) {
		case 1:
			insert();
			break;

		case 2:
			System.out.println("게임이 종료 되었습니다.");
			System.exit(0);
			break;
		}

	}

	private static void insert() {
		Scanner sc = new Scanner(System.in);

		HashSet<Integer> random = new HashSet<>();
		ArrayList<Integer> usernum = new ArrayList<>();

		while (random.size() < 3) {
			random.add((int) (Math.random() * (9-1+1)+1));

		}
		 System.out.println(random);
		while (true) {
			System.out.println("첫번째 숫자를 입력해주세요");
			int num1 = sc.nextInt();
			System.out.println("두번째 숫자를 입력해주세요");
			int num2 = sc.nextInt();
			System.out.println("세번째 숫자를 입력해주세요");
			int num3 = sc.nextInt();

			usernum.add(num1);
			usernum.add(num2);
			usernum.add(num3);

			System.out.println(usernum);

			play(random, usernum);
		}
	}

	private static void play(HashSet<Integer> random, ArrayList<Integer> usernum) {
		
		int s = 0;
		int b = 0;
		int temp = 0;
		int temp2 = 0;

		for (int a : usernum) {
			temp++;
			for (int c : random) {
				temp2++;
				if (a == c) {
					s++;
		        if (temp == temp2) {
					b++;
				} else if (temp != temp2) {
					b++;
				}

			}
		}
			temp2=0;
	}
		System.out.println("strike : " + s + "ball : " + b );
		usernum.clear();
		if(s == 3) {
			System.out.println("정답을 맞추었습니다. 게임이 종료 됩니다");
			System.exit(0);
		}
}
}