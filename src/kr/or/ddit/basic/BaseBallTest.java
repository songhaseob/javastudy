package kr.or.ddit.basic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*
     문제) Set과 List를 이용하여 숫자 야구 게임 프로그램을 작성하시오
               컴퓨터의 숫자는 난수를 이용하여 구한다
       (스트라이크 S, 볼은 B로 나타낸다.)
       
   예시)
              컴퓨터 난수 ==> 9 5 7
              
    실행예시)
              숫자를 입력 => 3 5 8
      3 5 8 ==> 1S 0B
             숫자를 입력 => 7 8 9
      7 8 9 ==> 0S 2B
             숫자입력 => 9 7 5
      9 7 5 ==> 1S 2B
             숫자입력 => 9 5 7
      9 5 7 ==> 3S 0B
      
             축하합니다.
             당신은 4번째만에 맞췄습니다.
      
      tip)난수 생성시 Set을 사용 -> Set에 있는 List를 Set에 담는다. 우리가 입력하는 데이터를 List에 저장을 한다
 */
public class BaseBallTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		HashSet<Integer> random = new HashSet<>();
		ArrayList<Integer> num = new ArrayList<>();
		
		while(random.size() <3) {
			random.add((int)(Math.random()*(9-1+1)+1));
		}
		
		int s = 0;
		int b = 0;
		int ct = 0;
		int ct1 = 0;
		
		while(s != 3) {
		System.out.println("첫번째 숫자를 입력해주세요.");
		int num1 = sc.nextInt();
		System.out.println("두번째 숫자를 입력해주세요.");
		int num2 = sc.nextInt();
		System.out.println("세번째 숫자를 입력해주세요.");
		int num3 = sc.nextInt();
		
		num.add(num1);
		num.add(num2);
		num.add(num3);
		
			for(int a : num) {
			ct++;
			for(int b1 : random) {
				ct1++;
				if(a == b1) {
					if(ct == ct1) {
						s++;
					}else if(ct != ct1) {
						b++;
					}
				}
			}
			ct1=0;
		}
		num.clear();
		System.out.println("Strike :" + s + "Ball : " + b);

	
		
		
		

	}

}





}






