package ssafy.com.BOJ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BOJ_실버4_1244_스위치켜고끄기 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int switchCnt = Integer.parseInt(in.readLine());

		String [] split = in.readLine().split(" ");
		int [] swit = new int[split.length];
		for(int i = 0;i<split.length;i++) {
			swit[i] = Integer.parseInt(split[i]);
		}

		int stuCnt = Integer.parseInt(in.readLine());
		for(int i = 0;i<stuCnt;i++) {
			String[] split2 = in.readLine().split(" ");
			int gen = Integer.parseInt(split2[0]);
			int switNum = Integer.parseInt(split2[1]);

			if(gen == 1) {
				for(int j = 0; j<switchCnt;j++) {
					if((j+1) % switNum == 0) {
						if(swit[j] == 0) swit[j] = 1;
						else swit[j] = 0;
					}
				}
			}

			else if(gen == 2) {
				switNum -= 1;
				int sym = 1;
				if(swit[switNum] == 0) swit[switNum] = 1;
				else swit[switNum] = 0;
				while(true) {
					int preSwit = switNum - sym;
					int nextSwit = switNum + sym;
					if(0 <= preSwit && nextSwit < switchCnt) {
						if(swit[preSwit] == swit[nextSwit]) {
							if(swit[preSwit] == 0) swit[preSwit] = 1;
							else swit[preSwit] = 0;

							if(swit[nextSwit] == 0) swit[nextSwit] = 1;
							else swit[nextSwit] = 0;

							sym++;
						}
						else break;
					}
					else break;
				}
			}
		}
		for(int i = 0;i<swit.length;i++) {
			sb.append(swit[i]).append(" ");
			if((i+1)%20==0) sb.append("\n");
		}
		System.out.println(sb);
	}

}
