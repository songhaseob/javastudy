package kr.or.ddit.basic;

import java.util.HashSet;

public class EqualsHashCodeTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("홍길동");
		
	
		Person p2 = new Person();
//		p2.setId(1);
//		p2.setName("일지매");
		
		p2.setId(1);
		p2.setName("홍길동");
		 
		Person p3 = p1;
		
		System.out.println(p1 == p2);
		System.out.println(p1 == p3);
		
		System.out.println(p1.equals(p2)); //상속을 안하면 object를 상속한다 objcet안에 여러가지 만들어져 있다
		System.out.println("----------------------------------------");
		
		HashSet<Person> testSet = new HashSet<>();
		
		testSet.add(p1);
		testSet.add(p2);
		
		System.out.println("set의 크기 : " + testSet.size());
		
		System.out.println("p1 :" + p1.hashCode());
		System.out.println("p2 :" + p2.hashCode());
		System.out.println("p3 :" + p3.hashCode());
		
		/*
		   - equals()메서드 ==>두 객체의 내용이 같은지 검사
		   - hashCode()메서드 ==> 두 객체의 동일성을 검사
		   
		   - HashSet, Hashtable, HashMap과 같이 Hash로 시작하는 컬렉션 객체들은 
		           객체의 의미상의 동일성을 비교하기 위해서 hashCode()메서드를 호출하여 비교한다
		           그러므로, 객체가 같은지 여부를 결정하려면 hashCode()메서드를 재정의 해야 한다
		           
		   - hashCode()메서드에서 사용하는 '해싱 알고리즘'은 서로 다른 객체들에 대해서
		           같은 hashCode를 나타낼 수 있다.
		 */
	}

}

class Person{
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
//	@Override
//	public boolean equals(Object obj) { //파라미터에 변수가 있으면 현재값과 파라미터에 들어있는 변수랑 비교한다
//		if(obj==null) return false;
//		
//		//이게 퍼슨클래스냐 다른클래스냐
//		if(this.getClass() != obj.getClass()) // 같은 유형의 클래인지 검사
//			return false;
//		if(this==obj)  // 참조값(주소값)이 같은지 검사
//			return true;
//		 
//		Person myObj = (Person)obj; //매개변수의 객체를 현재 객체 유형으로 형변환한다
//		
//		if(this.name==null && myObj.name!=null) {
//			return false;
//		}
//		
//		if(this.id==myObj.id && this.name == myObj.name) {
//			return true;
//		}
//		if(this.id==myObj.id && this.name.equals(myObj.name)) {
//			return true;
//	}
//		return false;
//	
	
	
//}


}








