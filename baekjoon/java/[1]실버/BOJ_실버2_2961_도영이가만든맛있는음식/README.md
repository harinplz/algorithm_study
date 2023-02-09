<br> 

[BOJ 실버2 2961 도영이가 만든 맛있는 음식](https://www.acmicpc.net/problem/2961)

<br>

<h2> 문제 </h2>

도영이는 짜파구리 요리사로 명성을 날렸었다. 이번에는 이전에 없었던 새로운 요리에 도전을 해보려고 한다.

지금 도영이의 앞에는 재료가 N개 있다. 도영이는 각 재료의 신맛 S와 쓴맛 B를 알고 있다. 여러 재료를 이용해서 요리할 때, 그 음식의 신맛은 사용한 재료의 신맛의 곱이고, 쓴맛은 합이다.

시거나 쓴 음식을 좋아하는 사람은 많지 않다. 도영이는 재료를 적절히 섞어서 요리의 신맛과 쓴맛의 차이를 작게 만들려고 한다. 또, 물을 요리라고 할 수는 없기 때문에, 재료는 적어도 하나 사용해야 한다.

재료의 신맛과 쓴맛이 주어졌을 때, 신맛과 쓴맛의 차이가 가장 작은 요리를 만드는 프로그램을 작성하시오.


<br>

<h2> 풀이 방법 </h2>

- 도영이가 만들 음식 중 재료를 고를 때 해당 재료의 집합에서 필요한 재료를 개수 제한 없이 골라서 답을 찾으면 된다.
- 집합에서 공집합을 제외한 모든 경우를 구하기 위해 `부분 집합` 알고리즘 사용

```
	private static void cook(int cnt, int sMul, int bSum) {
		//기저 부분
		if(cnt==N) {
			if(sMul != 1 && bSum != 0) {
				if(min > Math.abs(sMul-bSum)) min = Math.abs(sMul-bSum);
			}
			return;
		}
		
		//유도 부분
		
		isSelected[cnt] = true;
		cook(cnt+1, sMul*S[cnt], bSum + B[cnt]);
		
		isSelected[cnt] = false;
		cook(cnt+1, sMul, bSum);
		
	}
```

- isSelected 배열을 통해 해당 재료를 고를 수도 있고 고르지 않을 수도 있다.
- 만약에 재료를 고른다면 `cook(cnt+1, sMul*S[cnt], bSum+B[cnt]);` 코드를 통해 방금 고른 재료의 신맛을 곱해주고, 쓴맛을 더해준다.
- 고르지 않았다면 `cook(cnt+1, sMul, bSum);` 음식의 신맛과 쓴맛을 변화시키지 않고 다음 재료를 고르러 떠남 .. !!

<br>

- 모든 재료를 다 보았을 때, (다 넣은 것XXXXX)
  - 만약 sMul이 1이 아니고 bSum이 0이 아니라면 (= 최소 한 개의 재료라도 음식에 들어갔다면)
  - min 값과 `Math.abs(sMul-bSum) => 신맛과 쓴 맛의 차이` 를 비교한다.
    - 비교했을 때, min 값보다 `Math.abs(sMul-bSum)`값이 더 작다면? min 값을 `Math.abs(sMul-bSum)`으로 변경
    
<br>
