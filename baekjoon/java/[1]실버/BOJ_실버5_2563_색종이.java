import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_실버5_2563_색종이 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int white [][] = new int[100][100];
		
		int T = Integer.parseInt(in.readLine());
		
		for(int i =0;i<T;i++) {
			
			String[] split = in.readLine().split(" ");
			int rIdx = Integer.parseInt(split[0]);
			int cIdx = Integer.parseInt(split[1]);
			
			for(int j = rIdx-1;j< rIdx-1 + 10;j++) {
				for(int k=cIdx-1;k<cIdx-1 + 10;k++) {
					white[j][k] = 1;
				}
			}
			
		}
		
		int ans = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) ans+=white[i][j];
		}
		
		System.out.println(ans);
	}
	
}
