package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector v1 = new Vector(); //벡터는 object타입의 데이터를 저장한다
		
		System.out.println("크기 :" + v1.size());
		
		//데이터 추가 : add(추가할데이터)
		//변환값 : 추가성공(true), 실패(false)
		
		v1.add("aaaa");
		v1.add(new Integer(111));
		v1.add(123);
		v1.add('a');
		v1.add(true);
		
		boolean r = v1.add(3.14); // 3.14 double
		System.out.println("현재크기 : " + v1.size());
		System.out.println("반환값 :" + r);
		
		// 데이터 추가2 : addElement(추가될데이터) ==> 이전 버전에서 사용하던 메서드
		// 이전 버전의 프로그램도 사용할 수 있도록 하기위해서 남아 있는 메서드
		v1.addElement("ccc");
		System.out.println("v1 :" + v1.toString());
		//System.out.println("v1 :" + v1.toString());
		System.out.println("v1 : " + v1); //toString 으로 꼭 출력 안해도 된다!!
		
		//데이터 추가3 : add(index, 데이터)
		// ==> 'index' 번째에 '데이터를 끼워 넣는다
		// ==> 'index'는 0부터 시작한다
		// ==> 반환값이 없다.
		v1.add(1,"kkk");
		System.out.println("v1 :" +v1);
		
		//데이터 수정 : set(index, 새로운 데이터)
		// ==> 'index'번째의 데이터로 '새로운 데이터'로 덮어쓴다
		// ==> 반환값 : 원래의 데이터
		
		String temp = (String)v1.set(0, "zzz"); //타입이 다르기 때문에 오류가 난다
		System.out.println("v1 :" +v1);
		System.out.println("반환값 :" + temp);
		
		//데이터 삭제 : remove(index)
		// ==> 'index'번째의 데이터를 삭제한다.
		// ==> 반환값 : 삭제된 데이터
		
		v1.remove(0);
		System.out.println("삭제후 :" + v1);
		
		temp = (String)v1.remove(0);
		System.out.println("삭제된 자료 :" + temp);
		System.out.println("삭제된 후  v1:" + v1);
		
		//데이터 삭제 : remove(삭제할데이터)
		// ==> '삭제할데이터'를 찾아서 삭제한다.
		// ==> '삭제할데이터'가 여러개이면 앞에서부터 한번에 하나씩 삭제된다.
		// ==> 반환값 : 삭제 성공(true), 삭제실패(false)
		// ==> 삭제할 데이터가 '정수형' 이거나 ' char형'일 경우에는 반드시 객체형으로 변환해서 사용해야 한다.
		v1.remove("ccc");
		System.out.println("삭제된 후  v1:" + v1);
		
		//v1.remove(123); 123번째를 지워라(오류남) - 인덱스
		v1.remove(new Integer(123)); 
		System.out.println("삭제된 후  v1:" + v1);
		
		v1.remove(new Character('a'));
		System.out.println("삭제된 후  v1:" + v1);
		
		v1.remove(3.14); //삭제가능
		v1.remove(true); //삭제가능
		System.out.println("삭제된 후  v1:" + v1);
		
		// 데이터 꺼내오기 get(index)
		// ==> 'index'번재 데이터를 반환한다.
		int data = (int)v1.get(0);
		System.out.println("0번째 자료 :" + data);
		
		//----------------------------------------------------------------------------------
		/*
		  제네릭타입(Generic Type) ==> 객체를 선언할 때 < >괄호 안에 그 Collection이
		  	사용할 데이터의 타입을 정해주는 것을 말한다
		  	이런식으로 객체를 선언하게 되면 그 데이터 타입 이외의 다른 종류의 데이터를 저장 할 수 없다
		  	단, 제네릭으로 선언될 수 있는 데이터 타입은 클래스형 이어야 한다
		  	그래서, int는 Integer, Boolean, char은 Character등으로 대체해서
		  	사용해야 한다.
		  	제네릭 타입으로 선언하게 되면 데이터를 꺼내올 때 형변환이 필요 없다.
		  
		 
		 */
		Vector<String> v2 = new Vector<String>(); //String만 저장 할 수 있는 Vector객체 선언 / 앞에 선언 할때만 한번 사용해도된다
 		Vector<Integer> v3 = new Vector<>();//int로 쓰면 안된다 int형 데이터만 저장할 Vector객체 선언
 		
 		v2.add("안녕하세요");
 		//v2.add(123); 제네릭 타입이 String타입이기 때문에 에러가 난다
 		
 		String temp2 = v2.get(0);
 		
 		Vector<Vector> vv = new Vector<>();
 		Vector<Vector<Vector>> vvv = new Vector<>(); // 이런게 있다 3차원 배열 같은것
 		
 		System.out.println("v2의 clear 전 size :" + v2.size());
 		// 데이터 전체 삭제 : clear()
 		v2.clear();
 		System.out.println("v2의 clear 후 size :" + v2.size());
 		System.out.println("----------------------------------------");
 		
 		v2.add("AAA");
 		v2.add("BBB");
 		v2.add("CCC");
 		v2.add("DDD");
 		v2.add("EEE");
		
 		Vector<String> v4 = new Vector<>();
 		v4.add("BBB");
 		v4.add("EEE");
 		
 		System.out.println("v2 : " + v2 );
 		System.out.println("v4 : " + v4 );
 		
 		// 데이터 삭제 : removeAll(Collection객체) //가로 속에 있는 데이터를 다 지워라
 		// ==> 'Collection객체'가 가지고 있는 데이터를 Vector에서 찾아서 모두 삭제한다
 		// ==> 반환값 : 작업성공(true), 작업실패(false)
 		
 		v2.removeAll(v4); //v4가 가지고 있는 v2의 데이터를 삭제해라
 		System.out.println("삭제후 v2 :" + v2);
 		System.out.println("삭제후 v4 :" + v4);
 		System.out.println("-------------------------------------------");
 		
 		v2.clear();
 		
 		v2.add("AAA");
 		v2.add("BBB");
 		v2.add("CCC");
 		v2.add("DDD");
 		v2.add("EEE");
 		
 		// 벡터의 데이터를 순서대로 가져와 모두 사용하고 싶으면 반복문을 사용하면 된다
 		// (주로 for문을 사용한다.)
 		for(int i = 0; i < v2.size(); i++) {
 			System.out.println(i + "번째 자료 :" +v2.get(i));
 		}
		System.out.println("--------------------------------------------");
		
		// 향상된 for문
		for(String str : v2) { //v2값을 str변수에 값을 넣어 차례대로 데이터를 출력한다 무조건 차례대로만 데이터값만 꺼내 올수 있다
			System.out.println(str);
		}
		
	}

}


















