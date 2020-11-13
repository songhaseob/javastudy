package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIOTest {

   // 객체를 파일에 저장하는 예제
   public static void main(String[] args) {
      // Member의 인스턴스 생성
      Member mem1 = new Member("홍길동", 20, "대전");
      Member mem2 = new Member("홍길서", 30, "서울");
      Member mem3 = new Member("홍길남", 40, "인천");
      Member mem4 = new Member("홍길북", 50, "울산");

      try {
         // 객체 저장하기
         FileOutputStream fos = new FileOutputStream("d:/D_Other/memObj.bin");
         BufferedOutputStream bos = new BufferedOutputStream(fos);
         ObjectOutputStream oos = new ObjectOutputStream(bos);

         // 쓰기 작업(출력작업)
         System.out.println("객체 저장하기 시작....");
         oos.writeObject(mem1);
         oos.writeObject(mem2);
         oos.writeObject(mem3);
         oos.writeObject(mem4);
         System.out.println("객체 저장 작업 끝....");

         oos.close();

         // --------------------------------------------------------
         // 저장된 객체를 읽어와 그 내용을 화면에 출력하기
         // 입력용 스트림 객체 생성
         
         //읽어온 객체를 저장할 변수 선언
         ObjectInputStream ois = new ObjectInputStream(
               new BufferedInputStream(
                     new FileInputStream("d:/D_Other/memObj.bin")));
         System.out.println("객체 읽기 작업 시작....");
         Object obj;
         
         try {
            //readObject()메서드 데이터의 끝까지 다 읽어오면 EOFException을 발생한다.
            while((obj = ois.readObject()) != null) {
               //읽어온 데이터를 원래의 객체형으로 형변환 후 사용한다.
               Member mem = (Member)obj;
               
               System.out.println("이름 : " + mem.getName());
               System.out.println("나이 : " + mem.getAge());
               System.out.println("주소 : " + mem.getAddr());
               System.out.println("------------------------------");
            }
         } catch (EOFException e) {
            System.out.println("객체 읽기 작업 끝....");
         } catch(ClassNotFoundException e) {
            e.printStackTrace();
         }finally{
            //exception이 발생하면 위에서 닫을수 없으므로 finally를 만들어서 close를 해준다.
            //스트림 닫기
            ois.close();
         }
      } catch (IOException e) {
    	  e.printStackTrace();
      }
   }
}

// 저장용 class 만들기(직렬화처리를 해야하는 class)
// 생성자, getter/setter만들고
class Member implements Serializable {
	
	// transient ==> 직렬화가 되지 않을 변수에 지정한다
	//           ==> 직렬화가 되지 않을 멤버변수는 기본값으로 저장된다
	//           ==> 기본값 (참조형 변수 : null, 숫자형변수 : 0, 논리형변수 : false)
   private static final long serialVersionUID = -6485635176671241944L;
	
   private String name;
   private transient int age;
   private transient String addr;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getAddr() {
      return addr;
   }

   public void setAddr(String addr) {
      this.addr = addr;
   }

   public Member(String name, int age, String addr) {
      super();
      this.name = name;
      this.age = age;
      this.addr = addr;
   }
}