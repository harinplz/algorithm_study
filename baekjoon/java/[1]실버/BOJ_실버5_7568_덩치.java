import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_실버5_7568_덩치 {

	static class Person {
		int height;
		int weight;
		
		public Person(int height, int weight) {
			super();
			this.height = height;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Person [height=" + height + ", weight=" + weight + "]";
		}
	}
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		int height, weight;
		Person[] people = new Person[T];
		
		StringTokenizer st = null;
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(in.readLine());
			height = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			
			people[i] = new Person(height, weight);
		}
		
		for(int i=0; i<T; i++) {
			int cnt = 1;
			for(int j=0; j<T; j++) {
				if(i==j) continue;
				if(people[i].height < people[j].height && people[i].weight < people[j].weight) {
					cnt++;
				}
			}
			sb.append(cnt).append(" ");
		}
		
		System.out.println(sb);
	}

}