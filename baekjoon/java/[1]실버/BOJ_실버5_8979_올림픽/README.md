## BOJ 실버5 8679 올림픽

### 문제 요약
- N: 국가의 수, K: 등수를 알고 싶은 국가의 번호
- N과 K 그리고 국가별로 금메달, 은메달, 동메달 수를 입력받아 등수를 구하면 된다.
- 등수의 기준은 금메달 개수 - 은메달 개수 - 동메달 개수이다.
- 만약, 금메달 개수, 은메달 개수, 동메달 개수가 모두 똑같다면 그 나라들은 등수가 같다.

<br>

### 문제 풀이 방법
- 이 문제의 핵심은 **K 번호의 나라의 등수를 구하는 것**이다.
- 먼저 초기 rank 변수를 1로 초기화한다.
- 그리고 순서대로 금메달, 은메달, 동메달 개수를 검사하며 rank를 증가시킨다.

<br>

### 첫 번째 시도 
- 처음에는 Olympic 클래스를 생성해서 Comparable 인터페이스를 implements해서 정렬했다.
- 근데 동점자수를 구하는 데 계속 틀렸다고 나옴. 흠  
▶️ 해결해서 코드 업데이트함! 진짜 생각해보는 연습이 많이 필요한 듯 ㅠㅠ [코드](https://github.com/harinplz/Algorithm-Study/blob/main/baekjoon/java/%5B1%5D%EC%8B%A4%EB%B2%84/BOJ_%EC%8B%A4%EB%B2%845_8979_%EC%98%AC%EB%A6%BC%ED%94%BD/BOJ_%EC%8B%A4%EB%B2%845_8679_%EC%98%AC%EB%A6%BC%ED%94%BD_2.java)

<br>

### 두 번째 시도 
- 어짜피 K 나라의 등수를 구하면 되니까 금메달 개수, 은메달 개수, 동메달 개수를 비교해서 rank를 증가시켰다.
``` java
		// rank 계산하기 
		int rank = 1;
		
		// 금메달 비교하기 
		for(int i=1; i<=N; i++) {
			if(medal[i][0] > medal[K][0]) rank++;
		}
		
		// 은메달 비교하기 
		for(int i=1; i<=N; i++) {
			if(medal[i][0] == medal[K][0] && medal[i][1] > medal[K][1]) rank++;
		}
		
		// 동메달 비교하기 
		for(int i=1; i<=N; i++) {
			if(medal[i][0] == medal[K][0] && medal[i][1] == medal[K][1] 
					&& medal[i][2] > medal[K][2]) rank++;

		}
```

<br>

### 회고
- 문제를 너무 어렵게 풀려고 하는 것 같다.. 일단 문제 푸는 핵심 로직부터 파악하고 문제를 풀어야할 듯!!!!! 🥺 
