package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest02 {

	public static void main(String[] args) {
		// 파일에 데이터를 출력하기
		try {
			File file = new File("d:/D_Other/out.txt"); //없는 파일은 만들어주고 존재하면 덮어쓴다
			
			// 출력용 파일 스트림객체 생성
			FileOutputStream fout = new FileOutputStream(file);
			//FileOutputStream fout = new FileOutputStream("d:/D_Other/out.txt");
			
			for(char ch='A'; ch<='Z'; ch++) {
				fout.write(ch);  // 출력스트림을 이용해서 파일에 출력하기
			}
			System.out.println("작업 완료~~~");
			
			fout.close();  //스트림 닫기
			
			// ==================================
			// 저장된 파일 내용을 읽어와 화면에 출력하기
			FileInputStream fin = new FileInputStream(file);
			System.out.println();
			System.out.println("읽어온 파일내용...");
			
			int c;
			while(true) {
				c = fin.read();
				if(c==-1) {
					break;
				}
				System.out.print((char)c);
			}
			
			
			
		} catch (IOException e) {
		}
	}

}
