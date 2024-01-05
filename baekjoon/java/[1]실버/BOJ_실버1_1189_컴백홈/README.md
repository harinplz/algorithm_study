# BOJ 실버1 1189 컴백홈

<br>

### 풀이 요약

- 풀이 시간 : 5:27PM ~ 5:56PM
- 풀이 방법 : DFS
- 메모리 : 12020KB, 시간 : 96ms

<br>

### 풀이 방법

언제 BFS를 사용하고 언제 DFS를 사용하는 지는 아직도 헷갈리는 것 같다. BFS는 최단 경로를 구하는 거고 여기에서는 경로의 가짓수를 구하는 거니까 DFS를 쓰는 게 맞는 듯 호호 … 

DFS를 사용하면 간단하게 문제를 풀 수 있다. 한수는 R-1, 0 에서 시작하고 방문 처리를 해준다. (처음에 여기에서 방문처리를 안 해줘서 틀렸습니다. 가 떴다 😢) 또한, 집은 0, C-1에 위치하며 거리가 K인 가짓수를 구해야하기 때문에 r값이 0, c값이 C-1, 거리 값이 K일 때 가짓수를 증가해주고 return 한다. 

방문한 위치는 다시 방문하지 않기 때문에 visited 배열로 방문 처리를 해주어야 하지만, 다른 경로에서는 갈 수 있어야 하므로 현재 경로의 dfs를 다 돌고 나서는 방문 처리를 해제한다. (백트래킹)

```java
public static void DFS(int r, int c, int dis) {
    if (r == 0 && c == C - 1 && dis == K) {
        ans++;
        return;
    }

    for (int d = 0; d < 4; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (isRange(nr, nc)) {
            if (map[nr][nc] != 'T' && !visited[nr][nc]) {
                visited[nr][nc] = true;
                DFS(nr, nc, dis + 1);
                visited[nr][nc] = false;
            }
        }
    }
}
```
