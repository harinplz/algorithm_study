package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 메모리 : 14152KB 시간 : 128ms
 * 그리디 문제 .. 처음에 연산자랑 숫자 위치도 다 바꿀 수 있는 줄 알고 이상한 로직 세우다가
 * 문제를 다시 읽으니 그냥 주어진 계산식에서 괄호만 세우는 거구나.. 알게되었음.
 * 문제를 꼼꼼히 안 읽으니 이런 일이 발생..!!! 꼼꼼히 읽기!!! 
 */

public class BOJ_실버2_1541_잃어버린괄호 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String str = in.readLine(); //식 입력받음
		
		List<Integer> numList = new ArrayList<Integer>();
		List<Character> opList = new ArrayList<Character>();
		
		StringBuilder num = new StringBuilder();
		for(int i=0; i<str.length(); i++) { //숫자 .. 연산자 따로 저장...?
			if(str.charAt(i) == '-' || str.charAt(i) == '+') {
				opList.add(str.charAt(i));
				numList.add(Integer.parseInt(num.toString()));
				num = new StringBuilder();
			}
			else {
				num.append(str.charAt(i));
			}
		}
		numList.add(Integer.parseInt(num.toString()));
		
		boolean minus = false;
		
		int result = numList.get(0);
		
		for(int i=0; i<opList.size();i++) {
			char op = opList.get(i);
			switch(op) {
			case '-':
				minus = true;
				result -= numList.get(i+1);
				break;
			case '+':
				if(!minus) result += numList.get(i+1);
				else result -= numList.get(i+1);
				break;
			}
		}
		
		System.out.println(result);
		
	}
}
