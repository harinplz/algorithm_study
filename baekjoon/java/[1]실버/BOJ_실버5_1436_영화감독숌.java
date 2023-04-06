import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BOJ_실버5_1436_영화감독숌 {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int cnt = 0;
		int num = 666;
		
		while(cnt != N) {
			String str = String.valueOf(num);
			if(str.contains("666")) cnt++;
			if(cnt != N) 
				num++;
		}
		System.out.println(num);
	}
}