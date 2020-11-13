package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		
		Lotto.start();
	}

	private static int start() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		System.out.println("===================================");
		System.out.println("\t"+"Lotto 프로그램");
		System.out.println("-----------------------------------");
		System.out.println("1. Lotto 구입");
		System.out.println("2. 프로그램 종료");
		System.out.println("===================================");
		System.out.println("메뉴선택를 선택하세요");
		int input = sc.nextInt();
		
		switch (input) {
		case 1:
			 buy();
			break;

		case 2: 
			System.out.println("종료되었습니다.");
			System.exit(0);
			break;
		}
	
	}
	}
	private static void buy() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		System.out.println("===================================");
		System.out.println("Lotto 구입 시작");
		System.out.println();
		System.out.println("(1000원)에 로또 번호 하나입니다.");
		System.out.println("===================================");
		System.out.println("금액 입력");
		int input = sc.nextInt();
		
		if(input < 1000) {
			System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패");
		}else if (input >= 11000) {
			System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!");
		}else {
			int change = lookLotoo(input);
			System.out.println("받은금액은 :" + input +"원이고 거스름돈은" + change
					+"원입니다");
		}
		
	}

}

	private static int lookLotoo(int input) {
		
		HashSet<Integer> num = new HashSet<>();
		
		System.out.println("행운의 번호");
		int count = 0;
		
		if(input>=1000) {
			input -= 1000;
			count++;
		}
		while(num.size()<6) {
			num.add((int)(Math.random()*50+1));
		}
		ArrayList<Integer> Num = new ArrayList<>(num);
		System.out.println("로또번호 : " + Num.get(0)+" " + Num.get(1) +" " +
				Num.get(2) +" " + Num.get(3) +" " + Num.get(4) +" " + Num.get(5));
		return start();
		
	}
}













