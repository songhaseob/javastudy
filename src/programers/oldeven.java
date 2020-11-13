package programers;

import java.util.Scanner;

public class oldeven {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력해주세요.");
		int num = sc.nextInt();
		
		
		if(num%2==1) {
			System.out.println("Odd");
		}else{
			System.out.println("Even");
		}
		
	}
}
