package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		
		/*
		   Map ==> key괎가 value값을 한쌍으로 관리하는 객체
		    - key값은 중복을 허용하지 않고 순서(index)가 없다(Set의 특징을 갖는다)
		    - value값은 중복을 허용한다
		 */
		
			HashMap<String, String> map = new HashMap<>(); // 키값과 밸류 값이 스트링이다
			
			// 자료 추가하기 ==> put(key값, value값)
			map.put("name", "홍길동");
			map.put("addr", "대전");
			map.put("tel", "010-1234-5678");
			
			System.out.println("map의 데이터 : " + map);
			
			// 자료 수정 ==> Map의 데이터를 수정하려면 put()메서드의 key값이 같게해서 추가한다
			//      ==> Map은 추가 할 때 Key값이 같으면 나중에 추가한 데이터가 남는다
			map.put("addr", "서울");
			System.out.println("map의 데이터 : " + map);
			System.out.println();
			// 자료 삭제 ==> remove(Key값) : key값이 같은 자료를 찾아서 삭제한다
			//           반환값이 : 삭제된 데이터의 value값이 반환된다
			
//			String removeTel = map.remove("tel");
//			System.out.println("삭제 후 Map : " + map);
//			System.out.println("삭제 된 value 값 : " + removeTel);
			
			//자료 읽기 ==> get(key값) : key값이 같은 자료의 value값을 반환한다
			//	    ==> key값이 없을때에는 null을 반환한다
			System.out.println("이름 : " + map.get("name"));
			System.out.println("전화 : " + map.get("tel"));
			System.out.println("주소 : " + map.get("addr"));
			System.out.println("");
			
			// key값의 존재여부를 확인하는 메서드 : contaisKey(key값)
			// 	==> 해당 key값이 있으면 true, 없으면 false를 반환한다
			System.out.println("name 키값의 존재 여부 : " + map.containsKey("name"));
			System.out.println("age 키값의 존재 여부 : " + map.containsKey("age"));
			System.out.println();
			
			// Map에 저장된 데이터를 차례대로 읽어와 데이터를 처리하는 방법
			
			// 방법1) keySet()메서드 이용하기
			// 	keySet() ==> Map의 key값들을 읽어와 Set형으로 반환한다
			Set<String> keySet = map.keySet();
			
			Iterator<String> it = keySet.iterator();
			while(it.hasNext()) {
				String key = it.next(); // key값 가져오기
				String value = map.get(key);
				System.out.println(key + " : " + value);
			}
			System.out.println("---------------------------------------");
			
			// 방법2) keySet을 향상된 for문으로 처리하기
			for(String key : map.keySet()) {
				String value = map.get(key);
				System.out.println(key + " : " + value);
				
			}
			System.out.println("---------------------------------------");
	
	        // 방법 3) Value값만 읽어와서 처리하기 ==> values()메서드 이용
			for(String value : map.values()) {
				System.out.println("value");
			}
			System.out.println("---------------------------------------");
	
			/*
			          방법4) ==> Map에는 Entry라는 내부class가 만들어져 있다
			          이 Entry클래스는 key와 value라는 멤버변수로 구성되어 있다
			          Map에서는 이 Entry클래스들을 Set형식으로 저장해서 관리한다
			          
			     -Entry객체 전체를 가져와서 처리하기 (==> 가져온 Entry들은 Set형식으로 되어 있다)
			      ==> entrySet()메서드 이용
			 */
			
			// Entry라는 내부객체 전제 가져오기
			Set<Map.Entry<String, String>> mapSet = map.entrySet();
			
			Iterator<Map.Entry<String, String>> entryIt = mapSet.iterator();
			
			while(entryIt.hasNext()) {
				Map.Entry<String, String> entry = entryIt.next(); //Entry객체 가져오기
				
				// Entry객체에서 key값과 value값 구하기
				System.out.println("key값 : " + entry.getKey());
				System.out.println("value값 : " + entry.getValue());
				System.out.println();
			}
			System.out.println("---------------------------------------");
			
			
	}
	

}















