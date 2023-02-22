
[SWEA D3 9229 한빈이와 Spot Mart](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN)

<h2> 문제 </h2>

링크 참고

<br> 

<h2> 풀이 방법 </h2>

|메모리💻|시간⏲️|
|------|---|
|24908 KB|166 ms|

<br>

- 한빈이가 고른 과자 중에서 2개를 골라 M 그램을 초과하지 않는 최대 무게를 구하면 된다.
- 2개를 순서 없이 고르는 것이기 때문에 `조합` 을 이용하면 쉽게 풀 수 있다!


```
//조합
// 재귀 함수 사용
private static void combination(int start, int cnt) {
  if(cnt == 2) {
    //알고리즘을 풀기위한 코드 작성
    return;
  }
  
  for(int i = start; i<N; i++) {
    numbers[cnt] = snacks[i];
    combination(i+1, cnt+1); //중복 없이 골라야하므로 i+1
  }
}
```
