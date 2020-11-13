package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedIOTest02 {

	public static void main(String[] args) {
		// 문자기반의 Buffered스트림 객체 사용 예제
		try {
			// 이클립스에서의 자바 프로그램이 실행되는 현재 위치는 
			// 해당 '프로젝트 폴더'가 현재 위치가 된다
			FileReader fr = 
					new FileReader("./src/kr/or/ddit/basic/FileIOTest01.java");
			
			BufferedReader br = new BufferedReader(fr);
			
			String temp = ""; // 읽어온 한 줄의 문자열이 저장될 변수 선언
			
			// 문자기반의 버퍼스트림의 readLine() 메서드 
			//            ==> 한 줄씩 데이터를 읽어온다
			//            ==>읽어올 자료가 없으면 null을 반환한다
			for(int i = 1; (temp = br.readLine())!=null; i++) {
				System.out.printf("%4d : %s\n",i,temp); //%4d -> 정수형   %s\n -> 문자열
			}
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
