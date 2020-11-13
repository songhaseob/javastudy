package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOTest01 {

	public static void main(String[] args) {
		// 입출력의 성능 향상을 위해서 Buffered스트림을 사용한다.
		
		try {
			FileOutputStream fout = new FileOutputStream("d:/D_Other/bufferTest.txt");
			
			// 버퍼의 크기가 5인 Buffered스트림 객체 생성
			// 버퍼의 크기가 지정하지 않으면 기본크기인 8192byte로 버퍼의 크기가 정해진다
			BufferedOutputStream bout = new BufferedOutputStream(fout,5); //버퍼의 크기가 5개
			
			for(char i ='1'; i<='9'; i++) {
				bout.write(i); //반복문 1 ~ 9까지 돌렸지만, 버퍼의 크기가 5이기때문에 12345만 출력 
			}
			bout.flush(); // flush를 붙이면 버퍼가 다차 있지 않아도 출력을 해버림 
			//작업을 종료하기 전에 버퍼에 남아있는 데이터를 모두 출력 시킨다
			
			//fout.close();
			bout.close(); //  close는 flush기능도 있다 출력후 클로즈
			// 보조스트림을 닫으면 보조스트림에서 사용한 기반이 되는 스트림도 자동으로 닫힌다
			System.out.println("작업 끝...");
			
		} catch (IOException e) {
		}
	}

}
