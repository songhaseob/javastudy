package kr.or.ddit.basic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest03 {

	public static void main(String[] args) {
		FileTest03 test = new FileTest03();
		
		File viewFile = new File("d:/D_Other"); // 보고싶은 디렉토리 설정
		test.displayFileList(viewFile);
		
	}
	
	// 디렉토리(폴더)를 매개값으로 받아서 해당 디렉토리(폴더)에 있는 
	// 모든 파일과 디렉토리(폴더) 목록을 출력하는 메서드
		public void displayFileList(File dir) {
		if(!dir.isDirectory()) {
			System.out.println("디렉토리(폴더)만 가능합니다.");
			return;
		}
		
		System.out.println("[" + dir.getAbsolutePath() + "] 디렉토리 내용" );
		System.out.println();
		
		// 해당 디렉토리 안에 있는 모든 파일과 디렉토리 목록을 구해 온다
		File[] files = dir.listFiles();
		//String[] filestrs = dir.list();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		
		// 가져온 파일과 디렉토리 목록 개수만큼 반복처리하기
		for(int i = 0; i < files.length; i++) {
			String fileName = files[i].getName();
			String attr = "";        // 파일의 속성(읽기, 쓰기, 히든, 디렉토리를 구분)
			String size = "";        // 파일의 크기
			
			if(files[i].isDirectory()) {
				attr = "<DIR>";
			}else {
				size = files[i].length() + "";
				attr = files[i].canRead() ? "R" :"";
				attr += files[i].canWrite() ? "W" : "";
				attr += files[i].isHidden() ? "H" : "";
			}
			
			System.out.printf("%s %5s %12s %s\n",                  // 
					df.format(new Date(files[i].lastModified())),
					attr,size,fileName);
		}
	}
}
