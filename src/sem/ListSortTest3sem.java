package sem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSortTest3sem {
	// 등수를 구하는 메서드
	public void setRanking(List<Student> stdList) {
		for(Student std : stdList) { //기준 데이터를 구하기 위한 반복문
			int rank = 1; //처음에는 1등으로 설정 해 놓고 시작한다
			for(Student std2 : stdList) { //비교 대상을 나타내는 반복문
			   
				//기준보다 비교대상의 값이 크면 rank값을 증가 시킨다
				if(std.getTot() < std2.getTot()) {
					rank++;
				}
			}
			//구해진 등수를 Student객체의 rank변수에 저장한다
			std.setRank(rank);
		}
	}
	
	
	public static void main(String[] args) {
		
			 ListSortTest3sem stdTest = new ListSortTest3sem();
		
		
		List<Student> stdList = new ArrayList<>();
		
		stdList.add(new Student(1, "홍길동", 90, 95, 80));
		stdList.add(new Student(3, "성춘향", 90, 75, 70));
		stdList.add(new Student(7, "강감찬", 95, 95, 80));
		stdList.add(new Student(5, "변학도", 80, 95, 90));
		stdList.add(new Student(2, "일지매", 100, 85, 80));
		stdList.add(new Student(4, "이순신", 60, 65, 70));
		stdList.add(new Student(6, "이몽룡", 90, 100, 90));
		
		//등수 구하기
		stdTest.setRanking(stdList);
		
		System.out.println("정렬전...");
		for(Student std : stdList) {
			System.out.println(std);
		}
		//학번의 오름차순 정렬
		Collections.sort(stdList); //내부 정렬 기준으로 정렬한다
		
		
		System.out.println("학번의 오름차순 정렬후...");
		for(Student std : stdList) {
			System.out.println(std);
		}
		
		//총점의 역순으로 정렬
		Collections.sort(stdList, new SortByTotal());
		
		System.out.println("총점의 내림차순 정렬후...");
		for(Student std : stdList) {
			System.out.println(std);
		}
		
	}
	}


class Student implements Comparable<Student>{
	private int num;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private int rank;
	
	public Student(int num, String name, int kor, int eng, int mat) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor + eng + mat;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
		this.tot = kor + eng + mat;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
		this.tot = kor + eng + mat;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
		this.tot = kor + eng + mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", tot="
				+ tot + ", rank=" + rank + "]";
	}
	// 학번의 오름차순 정렬 기준
	@Override
	public int compareTo(Student std) {
		
		return Integer.compare(this.num, std.getNum());
	}
	
}

class SortByTotal implements Comparator<Student>{

	@Override
	public int compare(Student std1, Student std2) {
		if(std1.getTot() == std2.getTot()) {
			return std1.getName().compareTo(std2.getName());
		}else {
		return Integer.compare(std1.getTot(), std2.getTot());
	}
	
}
}











