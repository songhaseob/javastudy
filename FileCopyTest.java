package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    'd:/D_Other/' 폴더 안에 있는 '극한직업.jpg'파일을
    'd:/D_Other/ 연습용' 폴더에 '극한직업_복사본.jpg' 이름으로 복사하는 프로그램을 작성하시오 
 */
public class FileCopyTest {

	public static void main(String[] args) {
		String onebon = "d:/D_Other/극한직업.jpg";
		String copy = "d:/D_Other/연습용/극한직업_복사본.jpg";
		
		File onebon1 = new File(onebon);
		File copy1 = new File(copy);
		
		try {
			
			FileInputStream onebon2 = new FileInputStream(onebon1);
			FileOutputStream copy2 = new FileOutputStream(copy1);
			
			System.out.println("복사시작...");
			
			int data = 0;
			
			while((data=onebon2.read())!= -1) {
				copy2.write(data);
			}
			
			
			onebon2.close();
			copy2.close();
			
		} catch (IOException e) {
		}

	}

}
