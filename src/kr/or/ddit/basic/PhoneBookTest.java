package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;

/*
    문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고
       Map을 이용해서 전화번호 정보를 관리하는 프로그램을 작성하시오.
               이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체 출력하는 기능이 있다.
               
       (Map의 구조는 key값으로 '이름'을 사용하고, value값으로는 'phone클래스와 인스턴스'로 한다.)
       - 삭제, 검색기능은 '이름'을 입력받아 처리한다.
       
       ---------------------------------------------------------------------
       
                 실행 예시)
        -----------------------
                      다음 메뉴를 선택하세요.
          1. 전화번호 등록
          2. 전화번호 수정
          3. 전화번호 삭제
          4. 전화번호 검색
          5. 전화번호 전체 출력
          0. 프로그램 종료
        -----------------------
                   번호 입력 >>
                   
                   새롭게 등록할 전화번호 정보를 입력하세요.
                   이름 >>
                   전화번호 >> 010-1234-5678
                   주소 >> 대전시 중구 대흥동
                   
        '홍길동' 전화번호 등록 완료!!
        
         -----------------------
                      다음 메뉴를 선택하세요.
          1. 전화번호 등록
          2. 전화번호 수정
          3. 전화번호 삭제
          4. 전화번호 검색
          5. 전화번호 전체 출력
          0. 프로그램 종료
        -----------------------
                     번호 입력 >>
                     
                     새롭게 등록할 전화번호 정보를 입력하세요.
                     이름 >> 홍길동
         '홍길동은 이미 등록된 사람입니다.'
         
          -----------------------
                      다음 메뉴를 선택하세요.
          1. 전화번호 등록
          2. 전화번호 수정
          3. 전화번호 삭제
          4. 전화번호 검색
          5. 전화번호 전체 출력
          0. 프로그램 종료
        -----------------------
                     번호 입력 >>5
        ----------------------------------
                    번호 이름 전화번호                                 주소
        ----------------------------------
         1. 홍길동 010-3333-3333 대전시 중구 대흥동
                    출력 완료
                    번호 입력 >> 0
                     프로그램 종료합니다..
         
       
 */
public class PhoneBookTest {
	Scanner sc = new Scanner(System.in);
	HashMap<String, Phone> phoneMap = new HashMap<>();

	public static void main(String[] args) {
		new PhoneBookTest().start();
	}

	private void start() {
		while (true) {
			System.out.println("---------------------------------------------");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체 출력");
			System.out.println("6. 프로그램 종료");
			System.out.println("---------------------------------------------");
			System.out.println("입력>");

			int input = sc.nextInt();
			switch (input) {
			case 1:
				insert();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				search();
				break;
			case 5:
				alllook();
				break;
			case 6:
				System.out.println("프로그램이 종료 되었습니다.");
				System.exit(0);
				break;
			default:
				System.out.println("잘못입력하였습니다. 다시 입력하세요");

			}

		}
	}

	private void search() {
		System.out.println("검색할 이름을 입력하세요");
		String name = sc.next();
		if (phoneMap.containsKey(name) == true) {
			Phone p = phoneMap.get(name);
			System.out.println("---------------------");
			System.out.println("이름은 :" + p.getName());
			System.out.println("전화번호 :" + p.getTel());
			System.out.println("주소 :" + p.getAddr());
			System.out.println("----------------------");

		}

	}

	private void delete() {
		System.out.println("삭제할사람의 이름 입력");
		String name = sc.next();
		if (phoneMap.containsKey(name) == true) {
			phoneMap.remove(name);
		} else {
			System.out.println("저장되지 않은 사람입니다.");
		}
	}

	private void alllook() {
		System.out.println("---------------------------------------------");
		System.out.println("이름\t\t번호\t주소");
		for (String key : phoneMap.keySet()) {
			Phone p = phoneMap.get(key);
			System.out.println(p.getName() + "\t" + p.getTel() + "\t" + p.getAddr());
		}
		System.out.println("---------------------------------------");
		System.out.println("----------------------------------------------");
	}

	private void update() {

		System.out.println("수정할 이름을 입력하세요");
		String name = sc.next();

		if (phoneMap.containsKey(name) == true) {

			System.out.println("수정할 전화번호를 입력하세요");
			String tel = sc.next();
			System.out.println("수정할 주소를 입력하세요");
			String addr = sc.next();

			Phone p = new Phone(name, tel, addr);

			phoneMap.put(name, p);

			System.out.println("수정되었습니다.");
			System.out.println();

		} else {
			System.out.println("저장되지않았습니다.");
		}

	}

	private void insert() {
		System.out.println("---------------------------------------------");
		System.out.println("등록할 전화번호 정보를 입력해주세요");
		System.out.println("---------------------------------------------");
		System.out.println("이름을 입력해주세요.");
		String name = sc.next();
		if (phoneMap.containsKey(name) == true) {
			System.out.println(name + "은 이미 등록된 사람입니다.");

		}

		System.out.println("전화번호를 입력해주세요.");
		String tel = sc.next();

		System.out.println("주소를 입력해주세요.");
		String addr = sc.nextLine();

		Phone p = new Phone(name, tel, addr);

		phoneMap.put(name, p);

		System.out.println("전화번호 등록 완료!!");

	}

}

class Phone {

	private String name;
	private String tel;
	private String addr;

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

	public Phone(String name, String tel, String addr) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Phone [name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}

}
