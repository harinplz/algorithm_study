
[SWEA D4 1210 Ladder1](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh&) 
 
<h2> 문제 </h2> 
 
링크 참고 
 
<br>  
 
<h2> 풀이 방법 </h2> 

**구현**

|메모리💻|시간⏲️| 
|------|---| 
|32640 KB|155 ms| 
 
**BFS**

|메모리💻|시간⏲️| 
|------|---| 
|34324 KB|150 ms| 

- BFS로도 풀 수 있는 문제 !!
- pair 클래스 생성
  - 변수로는 `int r` `int c`가 존재, 2차원 배열의 위치를 저장한다.
- 2차원 배열을 입력 받으면서 r이 99일 때, 값이 2가 나오는(=도착점) 위치를 찾는다.
  - 만약 찾았다면 `end = new pair(99, j)` end 라는 이름의 pair 객체를 새로 생성한다.
 
 <br>
 
- `bfs(end)` 호출
- `bfs(end)`에서 노드 탐색을 위해 pair 객체를 담는 큐 생성
  - 처음에 최상위 노드로 end의 값을 `offer` 한다.
  - queue가 비어있지 않은 경우 while문으로 계속 반복하며
    - t : 큐의 첫 번째 원소를 반환
    - t를 방문
    - for(t와 연결된 모든 간선에 대해) {u <- 조건에 맞는 t의 자식 노드; u를 큐에 삽입}
  - 이 과정들을 진행하면 된다.
```
//BFS 코드
	private static void bfs(pair end) {
		// bfs 탐색을 위한 큐 생성
		Queue<pair> queue = new ArrayDeque<pair>();
		queue.offer(new pair(end.r, end.c));
		isSelected[end.r][end.c] = true;
		
		while(!queue.isEmpty()) {
			pair temp = queue.poll();
			
			if(temp.r == 0) {
				sb.append(temp.c).append("\n");
				break;
			}
			
			for(int i = 0;i<3;i++) {
				int nr = temp.r + dr[i];
				int nc = temp.c + dc[i];
				
				if((0<= nr && nr <100) && (0 <= nc && nc < 100)
						&& (ladder[nr][nc] == 1) && (isSelected[nr][nc] == false)) {
					isSelected[nr][nc] = true;
					queue.offer(new pair(nr, nc));
					break;
				}
			
			}
		}
	}
```
