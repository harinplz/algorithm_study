# BOJ 실버1 3187 양치기 꿍

### 풀이 요약

- 풀이 시간 : 9:40AM ~ 9:58AM
- 풀이 방법 : DFS
- 메모리 : 15076KB, 시간 : 108ms

<br>

### 풀이 방법

DFS로 #로 경계친 구역안을 돌면서 양의 개수와 늑대 개수를 센 다음, 더 큰 수를 각각의 총 합에 더해주면 된다.

1. R, C 입력 
2. map, visited 배열 생성 
3. 양의 총 합과 늑대 총합을 저장하는 변수 생성 (totalSheep, totalWolf)
4. DFS 탐색을 한다.
    1. 구역 안을 돌면서 v이면 늑대 개수에++ k이면 양 개수에 ++해준다.
    2. 탐색을 끝내고 나서 sheep ≤ wolf 이면 totalWolf += wolf, sheep > wolf 이면 totalSheep += sheep; 해준다. 
5. 탐색이 끝나고 totalSheep, totalWoolf를 출력한다.
