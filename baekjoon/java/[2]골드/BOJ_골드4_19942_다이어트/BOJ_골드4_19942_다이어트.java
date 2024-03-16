import java.io.*;
import java.util.*;

public class BOJ_골드4_19942_다이어트 {
	
	static class Ingredient {
		int protein;
		int fat;
		int carb;
		int vitamin;
		int cost;
		
		public Ingredient(int protein, int fat, int carb, int vitamin, int cost) {
			this.protein = protein;
			this.fat = fat;
			this.carb = carb;
			this.vitamin = vitamin;
			this.cost = cost;
		}
	}
	
	static int mp, mf, ms, mv;
	static Ingredient[] ingredients;
	static int N;
	static boolean[] isSelected;
	
	static int minCost = Integer.MAX_VALUE;
	static String ansStr = "Z";
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		mp = Integer.parseInt(st.nextToken());
		mf = Integer.parseInt(st.nextToken());
		ms = Integer.parseInt(st.nextToken());
		mv = Integer.parseInt(st.nextToken());
		
		ingredients = new Ingredient[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			int protein = Integer.parseInt(st.nextToken());
			int fat = Integer.parseInt(st.nextToken());
			int carb = Integer.parseInt(st.nextToken());
			int vitamin = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			ingredients[i] = new Ingredient(protein, fat, carb, vitamin, cost);
		}
		
		// 부분 집합 시작 
		isSelected = new boolean[N];
		subset(0);
		
		if(minCost == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(minCost);
			System.out.println(ansStr);
		}
	
	}
	
	public static void subset(int cnt) {
		if(cnt == N) {
			int sp = 0; int sf = 0; int ss = 0; int sv = 0; int cost = 0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					sp += ingredients[i].protein;
					sf += ingredients[i].fat;
					ss += ingredients[i].carb;
					sv += ingredients[i].vitamin;
					cost += ingredients[i].cost;
				}
			}
			
			if(sp >= mp && sf >= mf && ss >= ms && sv >= mv) {
				if(minCost >= cost) {
					if(minCost != cost) ansStr = "Z"; 
					String str = "";
					for(int i=0; i<N; i++) {
						if(isSelected[i]) {
							str += (i+1) + " ";
						}
					}
					if(str.compareTo(ansStr) < 0) ansStr = str;
					minCost = cost;
				}
			}
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt + 1);
		
		isSelected[cnt] = false;
		subset(cnt + 1);
	}
	
		
}
