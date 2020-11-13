package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest3 {

	/*
	 * 문제) 학번(int), 이름(String), 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는
	 *      Student클래스를 만든다
	 *      이 Student클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로
	 *      받아서 초기화 처리를 한다
	 *      
	 *      - 이 Student객체는 List에 저장하여 관리한다
	 *      
	 *      - List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고, 
	 *        총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부 정렬 기준
	 *        클래스를 작성하여 정렬된 결과를 출력하시오
	 *        
	 *        (단, 등수는 List에 전체 데이터가 추가된 후에 저장되도록 한다)
	 *      
	 */
	public static void main(String[] args) {
		
		ArrayList<Students> stList = new ArrayList<>();
		
		stList.add(new Students(2,"김선중",90,90,90));
		stList.add(new Students(3,"송하섭",80,90,20));
		stList.add(new Students(4,"이예슬",80,80,25));
		stList.add(new Students(1,"이건호",70,80,50));
		stList.add(new Students(5,"이건영",70,80,50));
		
		System.out.println("총점데이터");
		for(Students sts : stList) {
			System.out.println(sts);
		}
		System.out.println("번호순으로");
		
		Collections.sort(stList);
		for(Students sts : stList){
			System.out.println(sts);
		}
		System.out.println("총점순으로");
		
		Collections.sort(stList, new SortSumDesc());
		for(Students sts : stList){
			System.out.println(sts);
		}
		
		System.out.println("등수구하기");
		Collections.sort(stList, new SortSumDesc());
		int count = 0;
		for(int i = 0; i < stList.size(); i++) {
			count = 1;
			for(int j = 0; j < stList.size(); j++) {
				if(stList.get(i).getSum() < stList.get(j).getSum()) {
					 count++;
					
						
				}
				stList.get(i).setRank(count);
				
			}
			
			
		}
		for(Students sts : stList){
			System.out.println(sts);
		}
			
	}
}
				

class Students implements Comparable<Students>{
	private int sid;
	private String name;
	private int ks;
	private int es;
	private int ms;
	private int sum;
	private int rank;
	
	public Students(int sid, String name, int ks, int es, int ms) {
		super();
		this.sid = sid;
		this.name = name;
		this.ks = ks;
		this.es = es;
		this.ms = ms;
		this.sum = ks + es + ms;
		this.rank = rank;
		
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKs() {
		return ks;
	}
	public void setKs(int ks) {
		this.ks = ks;
	}
	public int getEs() {
		return es;
	}
	public void setEs(int es) {
		this.es = es;
	}
	public int getMs() {
		return ms;
	}
	public void setMs(int ms) {
		this.ms = ms;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "Students [sid=" + sid + ", name=" + name + ", ks=" + ks + ", es=" + es + ", ms=" + ms + ", sum=" + sum
				+ ", rank=" + rank + "]";
	}
	@Override
	public int compareTo(Students sts) {
		return Integer.compare(this.getSid(), sts.getSid());
		
	}
	
	
	
	

}
		
class SortSumDesc implements Comparator <Students>{
	public int compare(Students sts, Students sts2) {
		if (sts.getSum()> sts2.getSum()) {
			return -1;
		} else if (sts.getSum() == sts2.getSum()) {
			return sts.getName().compareTo(sts2.getName());
		} else {
			
			return 1;
		}
	}
}


	
	
	
