package kr.or.ddit.basic;

import java.util.LinkedList;

public class StackQueueTest {
	
	/*
	 *    Stack ==> 후입선출(LIFO)의 자료 구조
	 *    
	 *    Queue ==> 선입선출(FIFO)의 자료 구조
	 *    
	 *    Stack과 Queue는 LinkedList로 구현해서 사용할 수 있다.
	 */
	public static void main(String[] args) {
		//Stack 명령
		//1. 자료 입력 : push(입력데이터);
		//2. 자료 출력 : pop(); ==> 자료를 꺼내온 후 꺼내온 데이터를 Stack에서 지운다
		//			 peek(); ==> 삭제없이 자료를 꺼내온다.
		
		LinkedList<String> stack = new LinkedList<>();
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("이순신");
		stack.push("변학도");
		
		System.out.println("stack 값 : " + stack);
		String data = stack.pop();
		
		System.out.println("꺼내온 값  :" + data);
		System.out.println("꺼내온 값 : " + stack.pop());
		System.out.println("stack 값 :" + stack);
		
		stack.push("성춘향");
		System.out.println("추가후 stack 값 :" + stack);
		System.out.println();
		
		System.out.println("꺼내온 값 : " + stack.pop());
		System.out.println("stack 값 :" + stack);
		System.out.println();
		
		System.out.println("삭제없이 꺼내온 값 :" + stack.peek());
		System.out.println("stack 값 :" + stack);
		System.out.println("----------------------------------");
		
		/*
		 * Queue명령
		 * 1. 자료 입력 : offer(입력 데이터)
		 * 2. 자료 출력 : poll();  ==> 자료를 꺼내온 후 꺼내온 데이터를 Queue에서 삭제한다.
		 *            peek();  ==> 삭제없이 데이터를 꺼내온다
		 */
		
		LinkedList<String> queue = new LinkedList<>();
		
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("이순신");
		queue.offer("변학도");
		
		System.out.println("queue 값 : " + queue);
		
		String temp = queue.poll();
		System.out.println("꺼내온 값 :" + temp);
		System.out.println("꺼내온 값 : " + queue.poll());
		System.out.println("queue 값 :" + queue);
		
		queue.offer("성춘향");
		System.out.println("추가후 queue 값:" + queue);
		
		System.out.println();
		System.out.println("꺼내온 값 : " + queue.poll());
		System.out.println("queue 값 :" + queue);
		System.out.println();
		
		System.out.println("삭제없이 꺼내온 값 :" + queue.peek());
		System.out.println("queue 값 :" + queue);
		
		
		
		
	}

}













