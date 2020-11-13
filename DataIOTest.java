package kr.or.ddit.basic;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOTest {

	public static void main(String[] args) {
		try {
			FileOutputStream fout =
					new FileOutputStream("d:/D_Other/test.dat");
			
			// 자료형 단위를 출력할 보조스트림 객체(DataOutputStream) 생성
			DataOutputStream dos = new DataOutputStream(fout);
			
			dos.writeInt(200);       // 정수형으로 출력
			dos.writeFloat(123.45f); // 실수형(float)으로 출력
			dos.writeBoolean(true); // 논리형으로 출력
			dos.writeUTF("ABcd123가나"); // 문자열형식으로 출력
			
			System.out.println("출력 완료");
			
			dos.close(); // 스트림 닫기
			
			// ----------------------------------
			// 출력한 자료 읽어오기
			
			FileInputStream fin = new FileInputStream("d:/D_Other/test.dat");
			DataInputStream din = new DataInputStream(fin);
			
			// DataInputStream으로 데이터를 읽을 때는
			// 출력할 때의 순서와 같은 순서로 읽어와야 된다
			System.out.println("정수형 :" + din.readInt());
			System.out.println("실수형 :" + din.readFloat());
			System.out.println("논리형 :" + din.readBoolean());
			System.out.println("문자열 :" + din.readUTF());
			
			System.out.println("읽기 작업 완료..");
			
			din.close(); //스트림 닫기
		} catch (IOException e) {
			
		}
	}

}
