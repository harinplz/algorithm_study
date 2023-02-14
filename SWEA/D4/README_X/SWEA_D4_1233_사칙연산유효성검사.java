package ssafy.com.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_D4_1233_사칙연산유효성검사 {
	
	private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
        for(int tc = 1; tc<=10; tc++) {
            boolean isTrue = true;
            sb.append("#").append(tc).append(" ");
             
            int N = Integer.parseInt(in.readLine());
             
            for(int i = 1;i<=N;i++) {
                 
                String [] split = in.readLine().split(" ");
                 
                if(split.length == 2) {
                    if((split[1].equals("+")) || split[1].equals("*") ||
                            split[1].equals("-") || split[1].equals("/")) {
                        isTrue = false;
                    }
                }
            }
             
            if(isTrue) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
         
        System.out.println(sb);
    }
}
