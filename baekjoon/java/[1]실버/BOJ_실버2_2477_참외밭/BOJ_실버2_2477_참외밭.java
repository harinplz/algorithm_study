import java.io.*;
import java.util.*;

public class BOJ_실버2_2477_참외밭 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(in.readLine());
		
		// 육각형 정보 저장 배열 
		int arr[] = new int[6];
		
		int maxWidth = 0, maxWidthIdx = 0;
		int maxHeight = 0, maxHeightIdx = 0;
		
		StringTokenizer st;
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(in.readLine());
			int idx = Integer.parseInt(st.nextToken());
			arr[i] = Integer.parseInt(st.nextToken());
			// 1. 가장 긴 두 변 구하기 
			// 1-1. 세로 길이 
			if((idx == 1 || idx == 2) && (maxHeight < arr[i])) {
				maxHeight = arr[i];
				maxHeightIdx = i;
			}
			
			// 1-2. 가로 길이 
			if((idx == 3 || idx == 4) && (maxWidth < arr[i])) {
				maxWidth = arr[i];
				maxWidthIdx = i;
			}
		}
		
		// 참외밭 넓이 구하기 
		
		// 1. 가장 긴 가로 길이와 연결된 두 변의 길이 차 
		int firstIdx = maxHeightIdx - 1 < 0 ? 5 : maxHeightIdx - 1;
		int secondIdx = maxHeightIdx + 1 > 5 ? 0 : maxHeightIdx + 1;
		
		int minusWidth = Math.abs(arr[firstIdx] - arr[secondIdx]);
		
		// 2. 가장 긴 세로 길이와 연결된 두 변의 길이 차 
		firstIdx = maxWidthIdx - 1 < 0 ? 5 : maxWidthIdx - 1;
		secondIdx = maxWidthIdx + 1 > 5 ? 0 : maxWidthIdx + 1;
		
		int minusHeight = Math.abs(arr[firstIdx] - arr[secondIdx]);
		
		
		System.out.println(cnt * ((maxHeight * maxWidth) - (minusWidth * minusHeight)));
	}
	 
}
