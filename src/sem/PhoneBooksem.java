package sem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class PhoneBooksem {
	private Map<String, phone> phoneBookMap;
	private Scanner scan;
	
	//생성자
	public PhoneBooksem() {
		phoneBookMap = new HashMap<>();
		scan = new Scanner(System.in);
	}

	public static void main(String[] args) {
		new PhoneBooksem().phonebookstart();
	}

	// 프로그램 시작하는 메서드
	private void phonebookstart() {
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		System.out.println("        전화 번호 관리 프로그램");
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		System.out.println();

		while (true) {
			int choice = dispalyMenu();

			switch (choice) {
			case 1: insert(); //등록
				break;
			case 2: update();
				break;
			case 3: delete();
				break;
			case 4: search();
				break;
			case 5: displayAll();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요.");
			}
		}

	}
	
	// 전화번호 정보를 검색하는 메서드
	private void search() {
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요");
		System.out.print("이름>>");
		
		String name = scan.next();
		// 등록된 전화번호 정보가 있는지 검사
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨의 전화번호 정보가 없습니다.");
			System.out.println("삭제 작업 불가!!");
			return;
	}
		
		// 검색한 데이터가 있으면 해당 key값에 맞는 value값을 구한다.
		phone p = phoneBookMap.get(name);
		
		System.out.println();
		System.out.println(name + "씨의 전화번호 정보");
		System.out.println("================================");
		System.out.println(" 이름 :" + p.getName());
		System.out.println(" 전화번호 :" + p.getTel());
		System.out.println(" 주소:" + p.getAddr());
		System.out.println("================================");
	}
	
	
	// 전화번호 정보를 삭제하는 메서드
	private void delete() {
		System.out.println();
		System.out.println("삭제할 전화번호 정보를 입력하세요");
		System.out.println("삭제할 사람 이름>>");
		String name = scan.next();
		
		// 등록된 전화번호 정보가 있는지 검사
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨의 전화번호 정보가 없습니다.");
			System.out.println("삭제 작업 불가!!");
			return;
		}
		
		phoneBookMap.remove(name);
		
		System.out.println(name + "씨의 전화번호 정보를 삭제했습니다.");
	}

	// 전화번호 정보를 수정하는 메서드
	private void update() {
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력하세요.");
		
		System.out.print("이름>>");
		String name = scan.next();
		
		// 수정할 데이터가 있는지 검사
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨의 전화번호 정보가 없습니다.");
			System.out.println("수정 작업 불가!!");
			return;
		}
		System.out.print("새로운 전화번호 >>");
		String newTel = scan.next();
		
		scan.nextLine(); //입력버퍼비우기
		System.out.print("새로운 주소>>");
		String newAddr = scan.nextLine();
		
		/*
		// 방법1
		// 같은 키값에 새로운 전화번호 정보를 저장   ==> 수정작업
		phoneBookMap.put(name, new Phone(name, newTel, newAddr));
		*/
		
		// 방법2
		phone p = phoneBookMap.get(name); // 키값을 이용해서 value값을 구한다
		p.setTel(newTel);       //구해온  Phone객체의 각각의 데이터를 변경한다
		p.setAddr(newAddr);    
		
		System.out.println(name + "씨의 전화번호 정보를 변경하였습니다");
	}

	//Map에 저장된 전체 전화번호 정보를 출력하는 메서드
	private void displayAll() {
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println(" 번호            이름             전화번호            주소");
		System.out.println("---------------------------------------------");
	
		if(phoneBookMap.size()==0) {
			System.out.println("등록된 데이터가 하나도 없습니다.");
		}else {
			int cnt = 0; // 번호를 나타내는 변수
			Iterator<String> phoneIt = phoneBookMap.keySet().iterator();
			
			while(phoneIt.hasNext()) {
				cnt++;
				String name = phoneIt.next(); //키값(등록된 사람이름) 찾기
				phone p = phoneBookMap.get(name); // value값(Phone객체) 구하기
				System.out.println("  " + cnt+"  " + p.getName() +" "+ p.getTel() + " " + p.getAddr());
			}//while문
		}//else문
		System.out.println("---------------------------------------------");
		System.out.println(" 출력잡업 끝....");
	}
	
	// 새로운 전화번호 정보를 등록하는 메서드
	private void insert() {
		System.out.println();
		System.out.println("새로 등록할  전화번호 정보를 입력하세요.");
		
		System.out.print("이름>>");
		String name = scan.next(); // next ==> 뛰어쓰기 안하는 문자 // nextLine ==> 띄어쓰기 까지 받는 문자
		
		// 이미 등록된 사람인지 검사하기
		if(phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨는 이미 등록된 사람입니다");
			return; // 메서드를 끝낸다
		}
		
		
		System.out.print("전화번호>>");
		String tel = scan.next();
		
		// 입력버퍼비우기
		scan.nextLine();
		
		System.out.print("주소>>");
		String addr = scan.nextLine();
		
		//Phone p = new Phone(name,tel,addr);
		//phoneBookMap.put(name, p);
		phoneBookMap.put(name, new phone(name,tel,addr));
		
		System.out.println(name + "씨 전화번호 등록 완료 !!!");
	}
	
	/*
	    - Scanner의 입력받는 메서드의 특징
	             버퍼 - 임시기억장치
	             입력을 받으면 잠시 저장을 한다(입력 -버퍼-스캐너)
	      1. next(), nextInt(), nextDouble()...............
	        ==> 데이터를 사이띄기, Tap키, Enter키 값을 구분한다
	      
	          가나다
	          마바사
	          
	          가나다 마바사
	          가나다 	마바사
	          
	          변수1 = scan.next();
	          변수2 = scan.next();
	          
	      2. nextLine();  ==> 한 줄 단위로 입력한다
	      			즉, 자료를 입력하고 Enter키를 누르면 Enter키값까지 읽어간다
	 */
	
	// 메뉴를 출력하고 작업 번호를 입력받아 반환하는 메서드
	private int dispalyMenu() {
		System.out.println();
		System.out.println("-------------------------------------");
		System.out.println("   다음 메뉴를 선택하세요");
		System.out.println();
		System.out.println(" 1. 전화번호 등록");
		System.out.println(" 2. 전화번호 수정");
		System.out.println(" 3. 전화번호 삭제");
		System.out.println(" 4. 전화번호 검색");
		System.out.println(" 5. 전화번호 전체출력");
		System.out.println(" 0. 종료");

		System.out.println(" 번호 입력");
		int num = scan.nextInt();
		return num;
	}

}

// 하나의 전화번호 정보 (이름,주소,전화번호)를 멤버로 갖는 Phone클래스
class phone {
	private String name;
	private String tel;
	private String addr;

	public phone(String name, String tel, String addr) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}