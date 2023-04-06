package com.ssafy.daily28;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BOJ_브론즈2_12813_이진수연산 {
	
	//메모리 20180KB 시간 240ms

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String A = in.readLine();
		String B = in.readLine();
		
		//A & B
		for(int i=0; i<A.length(); i++) {
			int a = A.charAt(i) - '0';
			int b = B.charAt(i) - '0';
			
			sb.append(a&b);
		}
		sb.append('\n');
		
		// A | B
		for(int i=0; i<A.length(); i++) {
			int a = A.charAt(i) - '0';
			int b = B.charAt(i) - '0';
			
			sb.append(a|b);
		}
		sb.append('\n');
		
		// A ^ B
		for(int i=0; i<A.length(); i++) {
			int a = A.charAt(i) - '0';
			int b = B.charAt(i) - '0';
			
			sb.append(a ^ b);
		}
		sb.append('\n');
		
		//~A
		for(int i=0; i<A.length(); i++) {
			int a = A.charAt(i) - '0';
			
			if(a == 1) sb.append(0);
			else sb.append(1);
		}
		sb.append('\n');
		
		//~B
		for(int i=0; i<A.length(); i++) {
			int b = B.charAt(i) -'0';
			
			if(b == 1) sb.append(0);
			else sb.append(1);
		}
		sb.append('\n');
		
		System.out.println(sb);
	}

}
