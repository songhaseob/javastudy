package sem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ListSortTest3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		
		//1번
		ArrayList<String> nameList = new ArrayList<>();
		
		System.out.println("5명의 이름을 입력하세요");
		for(int i= 1; i <=5; i++) {
			System.out.print(i + "번재 사람 이름 :");
			String name = sc.next();
			nameList.add(name);
			
		}
		System.out.println();
		
		// 
		System.out.println("김씨 성을 가진 사람들 ... ");
		for(int i = 0; i < nameList.size(); i++) {
			if(nameList.get(i).substring(0, 1).equals("김")) {
				System.out.println(nameList.get(0));
				
			}

			}
		
		//2번
		
		ArrayList<String> aliasList = new ArrayList<>();
		
		System.out.println("서로 다른 길이의 별명을 5번 입력하세요");
		for(int i= 1; i <=5; i++) {
			System.out.print(i + "번재 사람 이름 :");
			String alias = sc.next();
			aliasList.add(alias);
		}
		System.out.println();
		
		// 제일 긴 별명이 저장될 변수 선언 ==> List의 첫번째 데이터로 초기화 한다.
		String maxAlias = aliasList.get(0);
		
		for(int i = 1; i < aliasList.size(); i++) {
			if(maxAlias.length() < aliasList.get(i).length()) {
				maxAlias = aliasList.get(i);
			}
		}
		System.out.println("제일 긴별명 :" + maxAlias);
		
		//3번
		
		ArrayList<String> aliasList1 = new ArrayList<>();
		
		System.out.println("서로 다른 길이의 별명을 5번 입력하세요");
		for(int i= 1; i <=5; i++) {
			System.out.print(i + "번재 사람 이름 :");
			String alias1 = sc.next();
			aliasList1.add(alias1);
		}
		System.out.println();
		
		// 제일 긴 별명의 글자 수가 저장될 변수를 선언하고
		// List의 첫번재 데이터의 글자 수로 초기화 한다.
		
		int maxLength = aliasList1.get(0).length();
		for(int i = 1; i < aliasList1.size(); i++) {
			if(maxLength < aliasList1.get(i).length()) {
				maxLength = aliasList1.get(0).length();
			}
		}
		System.out.println("제일 긴 별명들...");
		for(int i = 0; i < aliasList1.size(); i++) {
			if(aliasList1.get(i).length() == maxLength) {
				System.out.println(aliasList1.get(i));
			}
		}
}	
}



















