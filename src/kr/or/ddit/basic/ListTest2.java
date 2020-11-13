package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.NameList;

//문제) 5명의 사람 이름을 입력받아서 ArrayList에 저장한 후에 이들 중에서
//     '김'씨 성을 가진 사람의 이름을 모드 출력하시오.
//     (입력은 Scanner 객체를 이용한다.)
//// contains(비교객체) ==> 리스트에 '비교객체'가 있으면 true, 없으면 false 반환
//System.out.println("DDDD값 : " + list2.contains("DDDD")); //리스트2의 값이 DDDD가 있는지 비교
//System.out.println("DDDD값 : " + list2.contains("ZZZZ")); 

//문제2) 5명의 별명을 입력받아서 ArrayList에 저장한 후에 이들 중에서
//      별명의 길이가 제일 긴 별명을 출력하시오

//문제3) 문제 2에서 별명의 길이가 같은 것이 여러개 있을 경우를 처리하시오.
//        (즉, 제일 긴 별명 모두 출력한다.)
         
public class ListTest2 {

	public static void main(String[] args) {

		
//      문제1
//		5명의 사람 이름을 입력받아서 ArrayList에 저장한 후에 이들 중에서
//	     '김'씨 성을 가진 사람의 이름을 모드 출력하시오.
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> name = new ArrayList<>();
		
		for(int i = 0; i < 5; i++) {
		System.out.println("이름을 입력해주세요.");
		String input = sc.nextLine();
		
		name.add(input);
		
		}
		
		System.out.println("입력받은 이름 목록 : " + name);
		for(int i = 0; i < name.size(); i++) {
			String temp = name.get(i);
			temp = temp.substring(0,1);
			
		if(temp.contains("김")) {
			System.out.println("김씨성인사람은 : " + name.get(i));
		}
//		if(nameList.get(i).charAt(0)=='김')
//      if(nameList.get(i).indexof("김")==0)	
//		if(NameList.get(i).startswith("김")==true)
		}
	
//      문제2
//		5명의 별명을 입력받아서 ArrayList에 저장한 후에 이들 중에서
//      별명의 길이가 제일 긴 별명을 출력하시오

		ArrayList<String> name1 = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			System.out.println("별명을 입력해주세요.");
			String input = sc.nextLine();

			name1.add(input);

		}
		String a = name1.get(0);
		int max = 0;

		System.out.println("입력받은 별명 목록 : " + name);
		for (int i = 0; i < name1.size(); i++) {
			String temp = name1.get(i);
			max = name1.get(i).length();
			if (a.length() < max) {
				max = name1.get(i).length();
				a = name1.get(i);
			}

		}
		System.out.println("별명이 제일긴 별명은 :" + a);
		
		
//		문제3) 문제 2에서 별명의 길이가 같은 것이 여러개 있을 경우를 처리하시오.
//      (즉, 제일 긴 별명 모두 출력한다.)
		
		
		ArrayList<String> nm = new ArrayList<>();
		ArrayList<String> nm2 = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			System.out.println("별명을 입력해주세요.");
			String input = sc.nextLine();

			nm.add(input);

		}
		String a1 = nm.get(0);
		int max1 = 0;

		System.out.println("입력받은 별명 목록 : " + nm);
		for (int i = 0; i < nm.size(); i++) {
			String temp = nm.get(i);
			max1 = nm.get(i).length();
			if (a1.length() > max1) {
				max1 = nm.get(i).length();
				a1 = nm.get(i);
			}

		}
		for(int j= 0; j < nm.size(); j++) {
			if(max1 == nm.get(j).length()) {
				
				nm2.add(nm.get(j));
				
				
			}
			
		}
		System.out.println("제일 긴 별명은" + nm2);
		
	}

}
