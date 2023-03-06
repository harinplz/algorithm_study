package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_실버4_20436_ZOAC3 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char [][] keyboard =  {
				{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
				{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', '*'},
				{'z', 'x', 'c', 'v', 'b', 'n', 'm', '*', '*', '*'}
		};
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		char Sl = st.nextToken().charAt(0);
		char Sr = st.nextToken().charAt(0);
		
		int SlR = 0;
		int SlC = 0;
		int SrR = 0;
		int SrC = 0;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<10;j++) {
				if(keyboard[i][j] == Sl) {
					SlR = i; SlC = j;
				}
				else if(keyboard[i][j] == Sr) {
					SrR = i; SrC = j;
				}
			}
		}
		
		String str = in.readLine();
		int time = 0;
		
		for(int i=0; i<str.length(); i++) {
			time++;
			char findCh = str.charAt(i);
			int findChR = 0;
			int findChC = 0;
			
			for(int j=0;j<3;j++) {
				for(int k=0;k<10;k++) {
					if(keyboard[j][k] == findCh) {
						findChR = j;
						findChC = k;
						break;
					}
				}
			}
			
			if(isVowel(findChC, findChR)) {
				int distance = Math.abs(findChR - SrR) + Math.abs(findChC - SrC);
				time += distance;
				SrR = findChR; SrC = findChC;
			}
			else {
				int distance = Math.abs(findChR - SlR) + Math.abs(findChC - SlC);
				time += distance;
				SlR = findChR; SlC = findChC;
			}
			
		}
		
		System.out.println(time);
		
	}

	private static boolean isVowel(int findChC, int findChR) {
		if(findChC>=5) {
			return true;
		}
		else if(findChC == 4 && findChR == 2) return true;
		return false;
	}
	
}

