# BOJ 실버3 10973 이전 순열

<br>

### 풀이 요약

- 풀이 시간 : 약 40분
- 풀이 방법 : 구현
- 메모리 :  14924KB, 시간 : 128ms

<br>

### 풀이 방법

다음 순열과 같은 방식으로 풀면 된다. 하지만, 이전 순열은 앞 요소가 뒷 요소보다 작을 때 바꿔주는 게 아니라 앞 요소가 뒷 요소보다 클 때 바꿔줘야한다. 

<br>

1. i는 arr[i] 값이 arr[i-1]보다 작을 때까지 1씩 감소시킨다. 
    - 만약 i가 0이 된다면 이전 순열은 없다는 뜻이므로 false를 리턴한다.
2. j는 i≤j를 만족하고 arr[i-1] ≥ arr[j]을 만족할 때 까지 1씩 감소시킨다. 
    - 그러면 while문을 통해 1씩 감소시킬 경우 조건문은 반대로 되겠죠..!!!
3. 모든 조건을 만족하는 i와 j를 찾은 경우, arr[i-1]와 arr[j]의 위치를 변경해준다. 
4. 그 이후, i가 j보다 커질 때 까지 둘의 위치를 바꿔준다. (순열을 뒤집는다) ⭐ 

```java
public static boolean previousPermutation(int arr[]) {
    int i = arr.length - 1;
    while (i > 0 && arr[i] > arr[i - 1]) {
        i--;
    }

    if (i == 0) return false;

    int j = arr.length - 1;
    while (arr[i - 1] < arr[j]) {
        j--;
    }

    int temp = arr[j];
    arr[j] = arr[i - 1];
    arr[i - 1] = temp;

    j = arr.length - 1;
    while (i < j) {
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
    }
    return true;
}
```
