package com.amao.test;

import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Integer> q = new LinkedList<Integer>();
		
		q.offer(1);
		q.offer(2);
		q.offerFirst(3);
		q.offer(4);
		
		q.pollFirst();
		
		
		Object[] temp =   q.toArray();
		for(Object o :temp){
			int i = (int) o;
			System.out.print(i+",");
		}
	}

}
