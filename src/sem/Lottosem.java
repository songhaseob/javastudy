package sem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Lottosem {
	Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		new Lottosem().lottoStart();
	}
	// 로또 프로그램이 시작되는 메서드
	public void lottoStart() {
		while(true) {
			int choice = displayMenu();
			
			switch (choice) {
			case 1: // 구매
				lottoBuy();
				break;

			case 2: // 프로그램 종료
				System.out.println("감사합니다.");
				//return;  // 방법 1
				System.exit(0); // 방법 2
				
			default : System.out.println("메뉴 번호를 잘못 입력했습니다. 다시 입력해주세요.");
			}
		}
	}
	// 메뉴를 출력하고 작업 번호를 입력받아 반환하는 메서드
	public int displayMenu() {
		System.out.println();
		System.out.println("=======================================");
		System.out.println("      Lotto프로그램");
		System.out.println("      -----------");
		System.out.println("      1. Lotto 구입");
		System.out.println("      2. 프로그램 종료");
		System.out.println("=======================================");
		System.out.print("메뉴 선택 >>");
		
		int num = scan.nextInt();
		return num;
	}
	
	// 로또를 구매하는 메서드
	
	public void lottoBuy() {
		System.out.println("Lotto 구입 시작  \n");
		System.out.println("1000원의 로또번호 하나입니다.");
		System.out.println("금액 입력 : ");
		int money = scan.nextInt();
		
		if(money < 1000) {
			System.out.println("입력 금액이 너무 적습니다. 로또 번호 구입 실패!!");
		}else if(money >= 110000) {
			System.out.println("입력 금액이 너무 많습니다. 로또 번호 구입 실패!!");
		}else {
			// 로또번호를 생성해서 출력하는 메서드 호출
			lottoNum(money);
		}
		
		
	}
	
	// 로또번호를 생성해서 출력하고 거스름 돈을 출력하는 메서드
	public void lottoNum(int money) {
		System.out.println("행운의 로또번호는 아래와 같습니다.");
		
		for(int i = 1; i <= money/1000; i++) {
			HashSet<Integer> lotto = new HashSet<>();
			while(lotto.size()<6) {
				lotto.add((int)(Math.random()* 45 +1 )); // 1부터 45 사이의 난수 만들기
				
			}
			//만들어진 로또 번호를 List에 넣는다.
			ArrayList<Integer> lottoList = new ArrayList<>(lotto);
			Collections.sort(lottoList);
			System.out.println("로또번호 : " + i + lottoList); // List의 데이터를 정렬 한다.
			
		}
		System.out.println();
		System.out.println("받은금액" + money + "원이고 거스름돈은 :" + (money%1000) + " 원입니다." );
	}
}















