import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class BOJ_실버4_1920_수찾기 {
	
	static int a[];
	static int N;
	static int M;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		a = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(in.readLine());
		
		
		st = new StringTokenizer(in.readLine());
		Arrays.sort(a);
		//binarySearch 시작
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(!binarySearch(num, 0, N-1)) sb.append('0').append('\n');
			else sb.append('1').append('\n');
		}
		
		System.out.println(sb);
		
		
	}

	private static boolean binarySearch(int target, int start, int end) {
		if(start > end) return false;
		
		int mid = (start + end) / 2;
		
		if(a[mid] == target) return true;
		else if(a[mid] > target) {
			return binarySearch(target, start, mid-1);
		}
		else {
			return binarySearch(target, mid+1, end);
		}
	}
	
}