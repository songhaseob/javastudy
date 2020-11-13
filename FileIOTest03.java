package kr.or.ddit.basic;

import java.io.FileReader;
import java.io.IOException;

public class FileIOTest03 {

	public static void main(String[] args) {
		// 문자 기반의 스트림을 사용하여 파일 내용 읽어오기
		try {
			// 문자가 파일 입력용 스트림 객체 생성
			FileReader fr = new FileReader("d:/D_Other/test.txt");
			
			int c;
			
			while((c=fr.read())!=-1) {
				System.out.print((char)c);
			}
			
			fr.close(); //스트림 닫기
			
		} catch (IOException e) {
		}
	}

}
