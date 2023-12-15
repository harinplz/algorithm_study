## BOJ 골드1 1300 K번째 수

- 풀이 시간 : 블로그 참고 😂
- 풀이 방법 : 이분탐색

<br>

### 첫 번째 시도
- 당연히 안될 걸 알지만 ... 문제를 푸는데 감이 안 잡혀서 이중 for 문으로 구현했다.
- 당연히 ... 입력이 최대 10만이어서 시간 복잡도가 n^2가 되면 100억으로 100초 걸렸음.
- 또한 메모리도 초과되었음 ㅠㅠ 

<br>

### 블참 

<br>

- `B[K]=x` 의 기본적인 의미는 B 배열의 K번째 값은 x라는 의미이다.
- 그리고, **x이라는 값보다 작거나 같은 원소의 개수는 K개이다.** 라고 해석할 수도 있다.
- 정리하자면 **B[K] = x라는 의미는 x보다 작거나 같은 원소의 개수가 최소 K개이다.** 라는 뜻이다.
- 문제에서 요구하는 것은 K번째 수가 어떤 값인지, `B[K]=x`에서 x 값을 찾아야 한다.
- 그렇다면 우리는 x의 값을 조정해나가며, **x보다 작거나 같은 원소의 개수**를 찾아 K랑 일치하는 지 확인해야 한다.

<br>

- 그러면 x보다 작거나 같은 원소의 개수를 어떻게 해서 찾을 것인가?
- 구구단을 예로 들어 생각해보면 쉽게 이해할 수 있다.
- 만약, 누군가가 당신에게 '각 단 별로 8보다 작거나 같은 수의 개수를 찾아보시오' 라고 질문하면 어떻게 계산할 것인가?
- 만약 1단에서 구한다면? 8/1 = 8로, 8보다 작거나 같은 수의 개수는 8개가 된다.
- 2단은 8/2=4로, 8보다 작거나 같은 수의 개수는 4개가 된다.
- 3단은 8/3=2로, 8보다 작거나 같은 수의 개수는 2개가 된다.
- 4단은 8/4=2로, 8보다 작거나 같은 수의 개수는 2개가 된다.

<br> 

즉, 위 과정을 통해 우리가 직접 행렬을 생성할 필요가 없이  
1 ~ N까지 임의의 x로 나눠가며 해당 합이 K와 같은지 판별하면 된다.  

<br>

정리하면  
B[K] = x에서 찾아야하는 것은 x이며,  
x를 통해 x보다 작은 원소의 개수를 찾아 해당 값이 문제에서 주어지는 K값과 일치하는 지 이분탐색으로 찾으면 된다.  
``` java
while(left < right) {
  mid = (left + right) / 2;

  for(int i=1; i<=N; i++) {
    count += mid / i;
  }

if(count < K) {
  // count 값이 K보다 작으면, left = mid + 1로 범위를 높인다.
}
else {
  // count의 값이 K보다 크면, right = mid - 1로 범위를 낮춘다. 
}
}
```

<br>

- 먼저 left, right의 값 즉 x의 범위를 생각해봐야한다.
- x의 초기 범위는 1~N^2까지이다. 만약, N이 4라면, x의 초기 범위는 1 <= x <= 16이다.

<img src="https://blog.kakaocdn.net/dn/dJoNiP/btro39eyZ6r/N1HdGloMiiVfwMoDGzWNSK/img.png" width="700px"/>

- 위 이미지를 보면, B 배열에서 x는 항상 K보다 작거나 같은 것을 알 수 있다.
- 왜냐하면, K가 가질 수 있는 인덱스는 N^2 안에 있고, K의 최댓값은 N^2랑 같기 때문이다.
- 정리하자면, x의 범위를 1 <= x <= k로 좁힐 수 있으며, left = 1, right = k로 정의할 수 있다.

<br>

``` java
  for(int i=1; i<=N; i++) {
    count += mid / i;
  }
```
- 해당 코드에서 주의할 점이 있다.
- 만약, mid 값 즉 x값이 13이고 N이 4라고 가정하자.
- 이때, i=1이라면, 13/1로 13보다 작은 원소의 개수는 13이 된다.
- 하지만, A 배열에서 볼 수 있듯 A열은 N*N 배열로 한 행에 4개의 원소를 갖고 있다.
- 즉, **x보다 작은 원소의 개수는 최대 N개이다.** 그러면 코드를 다음과 같이 바꿀 수 있다.
``` java
  for(int i=1; i<=N; i++) {
    count += Math.min(mid/i,, N);
  }
```

<br>

### 왜 left를 출력하는가?
- 이분탐색과 같은 경곗값을 찾는 알고리즘에는 Upper-Bound를 쓸지, Lower-Bound를 써야하는 지 선택해야한다.
- **Upper-Bound**는 특정 값보다 처음으로 큰 값의 위치를 찾는 것이다. 

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbL9VBl%2FbtrUus3uxhi%2FdAjAjIKvm1VpAt4CPgfRtK%2Fimg.png" width="700px"/>

- **Lower-Bound**는 특정 값의 시작 위치를 찾는 것이다.
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcDcl4d%2FbtrUxdRXj9f%2FrEPGYLIYk7pK2bUXOKqWtK%2Fimg.png" width="700px"/>

- K값에 대해 x보다 작은 수가 K값이랑 같은 경우의 수가 여러 개일 가능성이 발생할 수 있다.
- 그렇기 때문에, 찾고자 하는 값과 같거나 큰 수가 있는 첫 번째 인덱스를 찾는 Lower-Bound 방식을 써야한다. 

<br>

### 정리 
- B[k]=x에서 x값을 구하는 문제이다.
- 이때, B[k] = x는 x보다 작은 값의 개수가 K개라는 것을 의미하고, x를 조절해가며 x보다 작은 값의 개수를 구해 K랑 같은지 확인하면 된다. 

<br>

### 출처
- [Lower bound & Upper bound 개념 및 구현](https://yoongrammer.tistory.com/105)
- [[백준] 1300번 : K번째 수 - JAVA [자바]](https://st-lab.tistory.com/281)

<br>

### 회고
- 어떻게 이런 문제를 인터넷을 참고 안하고 풀 수 있을까 ... ? (ㅠㅠ)
- 너모 어렵다 ... 더 노력해야지 ㅠㅠ 
