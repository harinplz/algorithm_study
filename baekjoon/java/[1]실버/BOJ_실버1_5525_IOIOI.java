import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BOJ_실버1_5525_IOIOI {
	
	/**
	 * 메모리 20644KB 시간 184ms
	 */

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		int M = Integer.parseInt(in.readLine());
		String s = in.readLine();

		int cnt = 0;
		int chkCnt = 0;

		for(int i=0; i<M-2; i++) {
			if(s.charAt(i)== 'I' && s.charAt(i+1)=='O' && s.charAt(i+2)== 'I') {
				chkCnt++;
				if(chkCnt == N) {
					chkCnt--;
					cnt++;
				}
				i++;  
			}else {
				chkCnt = 0;
			}
		}

		System.out.println(cnt);
	}

}

