# BOJ 골드5 5972 택배 배송

### 풀이 요약

- 풀이 시간 : 측정 X
- 풀이 방법 : 다익스트라
- 메모리 : 43384KB, 시간 : 524ms

<br>

### 풀이 방법

전형적인 다익스트라 문제로 1부터 N까지 최단 경로를 구하면 된다. 다익스트라 문제를 푸는 방법 중 우선 순위 큐로 푸는 방법을 사용했다.

<br>

1. 노드 클래스 생성
2. 노드와 간선 수 입력 
3. 그래프 생성 후 초기화 
4. 간선 수 만큼 반복하며 시작점, 종착점, 비용을 입력 받는다. 택배 배송 문제는 양방향이기 때문에 a에서 b, b에서 a 둘 다 넣어준다.
5. 우선 순위 큐를 생성한다. (비용이 작은 순)
6. 큐에서 하나씩 노드를 꺼낸다.
    1. 만약, dist[curNode.idx] < curNode.cost 라면 방문한 정점을 중복으로 방문할 수 있으므로 continue 처리한다.
    2. curNode와 인접한 노드를 방문하며 경로를 갱신한다.
        1. if(dist[nextNode.idx] > dist[curNode.idx] + nextNode.cost) 라면 dist[nextANode.idx] 값을 dist[curNode.idx] + nextNode.cost 로 갱신한다.
        2. 그 다음 queue에 Node(nextNode.idx, dist[nextNode.idx]) 를 넣어준다. 
7. 다익스트라 알고리즘을 통해 갱신된 최단 거리를 출력한다.
