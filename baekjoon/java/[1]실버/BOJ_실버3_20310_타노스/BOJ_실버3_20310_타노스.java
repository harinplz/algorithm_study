import java.io.*;
import java.util.*;

public class BOJ_실버3_20310_타노스 {

	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		int nums[] = new int[str.length()];
		
		int zeroCnt = 0;
		int oneCnt = 0;
		for(int i=0; i<str.length(); i++) {
			nums[i] = str.charAt(i) - '0';
			if(nums[i] == 0) zeroCnt++;
			else if(nums[i] == 1) oneCnt++;
		}
		
		oneCnt /= 2;
		zeroCnt /= 2;
		// oneCnt / 2 만큼 앞에서 1 삭제하기 
		for(int i=0; i<str.length(); i++) {
			if(nums[i]== 1) {
				nums[i] = 2;
				oneCnt--;
			}
			if(oneCnt == 0) break;
		}
		
		for(int i=str.length()-1; i>=0; i--) {
			if(nums[i]== 0) {
				nums[i] = 2;
				zeroCnt--;
			}
			if(zeroCnt == 0) break;
		}
		
		String ans = "";
		for(int i=0; i<str.length(); i++) {
			if(nums[i] != 2) {
				ans += nums[i];
			}
		}
		
		System.out.println(ans);
		
	}
	
}
