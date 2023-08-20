import java.io.*;
import java.util.*;

public class BOJ_브론즈1_2204_도비의난독증테스트 {

  /*
    풀이방법
    1. 문자를 비교하기 위한 2개의 Map을 생성한다. 하나는 원본을 저장하는 map, 두 번째는 비교를 하기 위한 TreeMap이다.
    2. TreeMap을 사용하여 비교하기 위해서 모든 입력 문자열을 소문자로 바꿔준다.
    3. 소문자로 바꿔 비교한 결과, 제일 첫번째로 오는 문자열을 찾기 위해 for 문을 돌려서 같은 int 값의 value를 가지는 key를 찾는다.
    4. key, 즉 원본 값을 저장한다.

    회고
    이렇게 복잡하게(?) 푸는 문제는 아닌 것 같은데 이런 방법밖에 생각이 안났다.
    다른 사람의 코드를 한 번 참고해봐야겠다.
  */
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int n = Integer.parseInt(in.readLine());
			if(n==0) break;

			HashMap<String, Integer> map = new HashMap<>();
			TreeMap<String, Integer> changeMap = new TreeMap<>();
			
			for(int i=0; i<n; i++) {
				String str = in.readLine();
				map.put(str, i);
				changeMap.put(str.toLowerCase(), i);
			}
		
			for(String key : map.keySet()) {
				if(map.get(key).equals(changeMap.firstEntry().getValue())) {
					sb.append(key).append('\n');
					break;
				}
			}
		}
		
		System.out.println(sb);
	}


}
