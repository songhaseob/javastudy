package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class hoteltest {
	private Map<Integer,Room> hotelMap;
	private Scanner scan;
	
	//생성자
	public hoteltest() {
		hotelMap = new HashMap<>();
		scan = new Scanner(System.in);
		
		hotelMap.put(201, new Room(201,"싱글름","-"));
		hotelMap.put(202, new Room(202,"싱글름","-"));
		hotelMap.put(203, new Room(203,"싱글름","-"));
		hotelMap.put(204, new Room(204,"싱글름","-"));
		hotelMap.put(205, new Room(205,"싱글름","-"));
		hotelMap.put(206, new Room(206,"싱글름","-"));
		hotelMap.put(207, new Room(207,"싱글름","-"));
		hotelMap.put(208, new Room(208,"싱글름","-"));
		hotelMap.put(209, new Room(209,"싱글름","-"));
		hotelMap.put(301, new Room(301,"더블름","-"));
		hotelMap.put(302, new Room(302,"더블름","-"));
		hotelMap.put(303, new Room(303,"더블름","-"));
		hotelMap.put(304, new Room(304,"더블름","-"));
		hotelMap.put(305, new Room(305,"더블름","-"));
		hotelMap.put(306, new Room(306,"더블름","-"));
		hotelMap.put(307, new Room(307,"더블름","-"));
		hotelMap.put(308, new Room(308,"더블름","-"));
		hotelMap.put(309, new Room(309,"더블름","-"));
		hotelMap.put(401, new Room(401,"스위트룸","-"));
		hotelMap.put(402, new Room(402,"스위트룸","-"));
		hotelMap.put(403, new Room(403,"스위트룸","-"));
		hotelMap.put(404, new Room(404,"스위트룸","-"));
		hotelMap.put(405, new Room(405,"스위트룸","-"));
		hotelMap.put(406, new Room(406,"스위트룸","-"));
		hotelMap.put(407, new Room(407,"스위트룸","-"));
		hotelMap.put(408, new Room(408,"스위트룸","-"));
		hotelMap.put(409, new Room(409,"스위트룸","-"));
		
	}
	public static void main(String[] args) {
		
		
		new hoteltest().hotelstart();
		
	}
	private void hotelstart() {
		System.out.println("***************************");
		System.out.println("호텔문을 열었습니다. 어서오십시오.");
		System.out.println("***************************");
		
		while(true) {
			int choice = displayMenu();
			
			switch (choice) {
			case 1: in();
				break;
			case 2:	out();
				break;
			case 3: info();
				break;
			case 4:
				System.out.println("업무가 종료 되었습니다.");
				System.exit(0);
				break;
			default : 
				System.out.println("잘못 눌렀습니다 다시 입력해주세요");
			}
		}
	}
	private void out() {
		
		
			System.out.println("------------------------");
			System.out.println("        체크아웃 작업");
			System.out.println("------------------------");
			System.out.print("방번호>>");
			
			int roomno = Integer.parseInt(scan.nextLine());
			
			
			if(201 <= roomno && 209 >= roomno || 301 <= roomno && 309 >= roomno || 401 <= roomno && 409 >= roomno) {
				if(hotelMap.get(roomno).getName().equals("-")) {
					System.out.println(roomno + "호 객실에는 체크인한 사람이 없습니다." );
				}else {
					hotelMap.get(roomno).setName("-");
					System.out.println(roomno +"객실의 체크아웃이 완료되었습니다.");
				}
				}else{
					System.out.println(roomno + "호 객실이 존재하지 않습니다.");
				return;
		
 	}
	}
	private void info() {
		System.out.println("         현재 객실상태");
		System.out.println("---------------------");
		System.out.println(" 방번호      방종류       투숙객이름");
		System.out.println("---------------------");
		List<Integer> keyList = new ArrayList<>(hotelMap.keySet());
		Collections.sort(keyList);
		for(Integer key : keyList) {
			Room value = hotelMap.get(key);
			System.out.println(""+key+"    "+value.getRoomtype()+"               " +value.getName());
		}
//		keyList.clear();
	}
	private void in() {
		System.out.println("------------------------");
		System.out.println("        체크인 작업");
		System.out.println("------------------------");
		System.out.println(" * 201 ~ 209 : 싱글룸");
		System.out.println(" * 301 ~ 309 : 더블룸");
		System.out.println(" * 401 ~ 409 : 스위트룸");
		System.out.println("------------------------");
		System.out.print("방번호>>");
		
		int roomno = Integer.parseInt(scan.nextLine());
		
		
		if(201 <= roomno && 209 >= roomno || 301 <= roomno && 309 >= roomno || 401 <= roomno && 409 >= roomno) {
			System.out.print("이름 입력>>");
			String name = scan.nextLine();
			
			hotelMap.get(roomno).setName(name);
			
			System.out.println("체크인이 완료되었습니다.");
			}else{
				System.out.println(roomno + "호 객실이 존재하지 않습니다.");
			return;
			
		}
			
	}
	
	private int displayMenu() {
		System.out.println("-----------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("-----------------------------");
		System.out.println("1. 체크인     2. 체크아웃    3. 객실상태   4. 업무종료");
		System.out.print("선택>>");
		int num = Integer.parseInt(scan.nextLine());
		return num;
	}

}
class Room {
	private int roomno;
	private String roomtype;
	private String name;
	
	public int getRoomno() {
		return roomno;
	}
//	public static Integer get(Integer key) {
//		return null;
//	}
	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Room(int roomno, String roomtype, String name) {
		super();
		this.roomno = roomno;
		this.roomtype = roomtype;
		this.name = name;
	}

	}
	
