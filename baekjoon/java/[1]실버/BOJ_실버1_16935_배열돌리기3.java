package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_실버1_16935_배열돌리기3 {
	
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int N;
	private static int M;
	private static int R;
	private static int [][] arr;

	public static void main(String[] args) throws Exception {

		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		//N,M,R 입력
		st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(in.readLine());

		for(int i = 0;i<R;i++) {
			int rotationType = Integer.parseInt(st.nextToken());

			switch(rotationType) {
			case 1:
				Rotation1();
				break;
			case 2:
				Rotation2();
				break;
			case 3:
				Rotation3();
				break;
			case 4:
				Rotation4();
				break;
			case 5:
				Rotation5();
				break;
			case 6:
				Rotation6();
				break;
			}
		}

		for(int i = 0;i<N;i++) {
			for(int j =0;j<M;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}



	//상하 반전
	private static void Rotation1() {
		int[][] temp = new int[N][M];

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++){
				temp[N-i-1][j] = arr[i][j];
			}
		}
		
		arr=temp;
	}

	//좌우 반전
	private static void Rotation2() {
		int[][] temp = new int[N][M];

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++){
				temp[i][j] = arr[i][M-j-1];
			}
		}
		
		
		arr = temp;
	}

	//오른쪽 90도 회전
	private static void Rotation3() {
		int[][] temp = new int[M][N];
		
		int col = N-1;
		for(int i = 0;i<N;i++) {
			for(int j=0;j<M;j++) {
				temp[j][col] = arr[i][j];
			}
			col--;
		}
		
		int tem=N;
		N=M;
		M=tem;
		
		arr = temp;
	}

	//왼쪽 90도 회전
	private static void Rotation4() {
		int[][] temp = new int[M][N];

		for(int i = 0;i<N;i++) {
			for(int j=0;j<M;j++) {
				temp[M-j-1][i] = arr[i][j];
			}
		}
		
		int tem = N;
		N = M;
		M = tem;
		
		arr = temp;
	}


	//5번 연산
	private static void Rotation5() {
		int[][] temp = new int[N][M];

		//4->1
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) temp[i][j] = arr[i+N/2][j];
		}
		//1->2
		for(int i=0;i<N/2;i++) {
			for(int j=M/2;j<M;j++) temp[i][j] = arr[i][j-M/2];
		}
		//2->3
		for(int i=N/2;i<N;i++) {
			for(int j=0;j<M/2;j++) temp[i][j] = arr[i][j+M/2];
		}
		//3->4
		for(int i=N/2;i<N;i++) {
			for(int j=M/2;j<M;j++) temp[i][j] = arr[i-N/2][j];
		}

		arr=temp;

	}

	//6번 연산
	private static void Rotation6() {
		int[][] temp = new int[N][M];


		//2->1
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++) temp[i][j] = arr[i][j+M/2];
		}
		
		//1->4
		for(int i=N/2;i<N;i++) {
			for(int j=0;j<M/2;j++) temp[i][j] = arr[i-N/2][j];
		}
		
		//4->3
		for(int i=N/2;i<N;i++) {
			for(int j=M/2;j<M;j++) temp[i][j] = arr[i][j-M/2];
		}
		
		//3->2
		for(int i=0;i<N/2;i++) {
			for(int j=M/2;j<M;j++) temp[i][j] = arr[i+N/2][j];
		}
		
		arr=temp;
	}

}
