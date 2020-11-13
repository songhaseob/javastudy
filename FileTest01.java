package kr.or.ddit.basic;

import java.io.File;

public class FileTest01 {

	public static void main(String[] args) {
		// File객체 만들기 연습
		
		// 1. new File(String 파일 또는 경로)
		//      ==> 디렉토리와 디렉토리 사이 또는 디렉토리와 파일명 사이의 구분문자는
		//          역슬래쉬('\')를 사용하거나 슬래쉬('/')를 사용할 수 있다
		
		
		File file1 = new File("D:/D_Other/test.txt"); // ==> 구분문자로 '/'사용한경우
		//File file1 = new File("D:\\D_Other\\test.txt"); // ==> 구분문자로 '\'사용한경우
		
		System.out.println("파일명 : " + file1.getName());
		System.out.println("디렉토리일까? : " + file1.isDirectory() );
		System.out.println("파일일까 ? : " + file1.isFile());
		System.out.println();
		
		File file2 = new File("d:/d_other"); // 대소문자 상관 없음
		
		System.out.println("파일명 : " + file2.getName()); //파일 이름
		System.out.println("디렉토리일까? : " + file2.isDirectory() ); 
		System.out.println("파일일까 ? : " + file2.isFile()); 
		System.out.println();
		
		// 2. new File(File parent, String child) //앞에가 폴더고 뒤에가 파일 이름이다
		//      ==> 'parent' 디렉토리 안에 있는 'child'파일을 나타낸다
		File file3 = new File(file2,"test.txt");
		
		System.out.println("파일명 : " + file3.getName()); //파일 이름
		System.out.println("디렉토리일까? : " + file3.isDirectory() ); 
		System.out.println("파일일까 ? : " + file3.isFile()); 
		System.out.println();
		
		// 3. new File(String parent, String child)
		//      ==> 'parent' 디렉토리 안에 있는 'child'파일을 나타낸다
		
		File file4 = new File("d:/D_Other","test.txt");
		System.out.println("파일명 : " + file4.getName()); //파일 이름
		System.out.println("디렉토리일까? : " + file4.isDirectory() ); 
		System.out.println("파일일까 ? : " + file4.isFile()); 
		System.out.println();
		System.out.println("------------------------------------------");
		
		// 디렉토리(폴더) 만들기
		/*
		     - mkdir() ==> File객체의 경로 중 마지막 위치의 디렉토리를 생성한  //mk = make directory
		               ==> 반환 : 만들기 성공(true), 만들기 실패(flase)
		               ==> 중간 부분의 경로가 모두 만들어져 있어야 마지막 위치의 폴더를 만들수 있다
		     - mkdirs() ==> 중간 부분의 경로가 없으면 중간부분의 경로도 같이 만들어 준다
		 */
		File file5 = new File("D:/D_Other/연습용");
		
		System.out.println("파일명 : " + file5.getName()); //파일 이름
		System.out.println("디렉토리일까? : " + file5.isDirectory() ); 
		System.out.println("파일일까 ? : " + file5.isFile()); 
		System.out.println();
		System.out.println(file5.getName() + "의 존재여부 : " + file5.exists());
		
		if(file5.mkdir()) {
			System.out.println(file5.getName() + "디렉토리 생성");
		}else{
			System.out.println(file5.getName() + "디렉토리만들기실패!!");
		}
		System.out.println();
		
		File file6 = new File("d:/D_Other/test/java/src");
		if(file6.mkdirs()) {
			System.out.println(file6.getName() + "디렉토리 생성");
		}else{
			System.out.println(file6.getName() + "디렉토리만들기실패!!");
		}
		}
}










