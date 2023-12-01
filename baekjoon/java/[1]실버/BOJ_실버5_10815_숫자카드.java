import java.io.*;
import java.util.*;

public class BOJ_실버5_10815_숫자카드 {

  // 풀이 시간 29분 30초
  // 풀이 방법 정렬 후 이분탐색
  // 메모리 : 140596KB, 시간 : 1044ms 
	
	public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(in.readLine());
        int sangCard[] = new int[N];
        
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i=0; i<N; i++) {
            sangCard[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(sangCard); // 정렬 
        
        int M = Integer.parseInt(in.readLine());
        
        st = new StringTokenizer(in.readLine());
        // 이분탐색하기 ... 
        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean find = binarySearch(sangCard, num, 0, N-1);
            if(find) sb.append(1).append(' ');
            else sb.append(0).append(' ');
        }
        
        System.out.println(sb);
	}
	
	public static boolean binarySearch(int[] arr, int target, int left, int right) {
	    if(left <= right) {
	        int mid = (left + right) / 2;
	    
	        if(arr[mid] < target) {
	            return binarySearch(arr, target, mid+1, right);
              // return 꼭 해주기 ,,, 
              // return을 해야 binarySearch 메서드 내에서 재귀 호출을 할 때 호출 결과를 반환한다!
              // Java에서는 호출 결과를 상위 호출 스택으로 전달하기 위해 return 문이 필요하기 때문이다. 
              // 여기서 return을 안해준다면? 항상 false로 반환되어 잘못된 결과가 도출될 것이다. 
	        }
	        else if(arr[mid] > target) {
	            return binarySearch(arr, target, left, mid-1);
	       }
	        else return true;
	    }

	    return false;
	}
	
}
