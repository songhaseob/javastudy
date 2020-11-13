package sem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Baseballsem {
	ArrayList<Integer> numList; // 난수가 저장될 List
	ArrayList<Integer> userList; // 사용자가 입력한 값이 저장 될 List
	
	
	int strike; // 스트라이크 개수가 저장될 변수 
	int ball;   // 볼의 개수가 저장될 변수
	
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		Baseballsem baseBall = new Baseballsem();
		baseBall.gameStart();
		
	}
	// 게임이 시작되는 메서드
	public void gameStart() {
		
		// 난수를 만드는 메서드 호출
		getNum();
		
		// 확인용 출력
		System.out.println("컴퓨터 난수 : " + numList);
		
		int cnt = 0; // 몇번만에 맞췄는지를 저장하는 변수 선언 및 초기화
		
		do {
			cnt++;
			// 사용자로부터 입력받는 메서드호출
			inputNum();
			
			//볼카운트 구하는 메서드 호출
			ballCount();
			
			
		}while(strike!=3); // 3 strike가 될때 까지 반복한다
		
		System.out.println();
		System.out.println("축하합니다.");
		System.out.println("당신은  " + cnt + "번째만에 맞췄습니다.");
		
		
	}
	
	// 1~9사이의 서로 다른 난수 3개를 만들어서 리스트에 저장하는 메서드(Set 이용)
	public void getNum() {
		Set<Integer> numSet = new HashSet<>();
		
		// 1~9사이의 난수 3개 만들기
		while(numSet.size() <3) {
			numSet.add((int)(Math.random()*9 + 1));
			
		}
		// 만들어진 난수를 List에 저장하기
		numList = new ArrayList<>(numSet);
		
		// List의 데이터를 섞어준다.
		Collections.shuffle(numList);
		
	}
	
	// 사용자로부터 3개의 정수를 입력 받아서 리스트에 저장하는 메서드
	// 입력한 값들은 중복되지 않아야 한다
	public void inputNum() {
		int n1, n2, n3;  // 입력한 정수가 저장될 변수 선언
		
		do {
			System.out.print("숫자입력==>");
			n1 = scan.nextInt();
			n2 = scan.nextInt();
			n3 = scan.nextInt();
			
			if(n1==n2 || n1==n3 || n2 == n3) { //중복 여부 검사
				System.out.println("중복되는 숫자는 입력할 수 없습니다. 다시입력하세요.");
			}
		}while(n1==n2 || n1==n3 || n2 == n3);
		
		
		// 입력받은 순서대로 리스트에 추가한다
		userList = new ArrayList<>();
		userList.clear();
		userList.add(n1);
		userList.add(n2);
		userList.add(n3);
		
	}
	
	// 스트라이크와 볼을 판정하고 출력하는 메서드
	public void ballCount() {
		strike = 0;
		ball = 0; // 스트라이크와 볼의 개수 초기화
		
		for(int i = 0; i < numList.size(); i++) {
			for(int j = 0; j < userList.size(); j++) {
				if(numList.get(i) == userList.get(j)) { // 값이 같은지 검사
					if(i==j) { // 위치가 같은지 검사
						strike ++;
					}else {
						ball ++;
						
					}
				}
			}// for-j
		}// for-i
		
		//볼카운트 결과 출력하기
		System.out.println(userList.get(0) + "," + userList.get(1) +"," + userList.get(2) + "==>" + strike + "S" + ball +"B");
	}
	
}














