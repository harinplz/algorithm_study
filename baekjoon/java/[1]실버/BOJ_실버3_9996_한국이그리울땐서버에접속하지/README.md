# BOJ 실버3 9996 한국이 그리울 땐 서버에 접속하지

<br>

## 요약 
- 풀이 시간 : 20분 정도 ... 
- 풀이 방법 : 문자열 

<br>

## 풀이 방법
- 패턴을 먼저 입력 받은 후, * 앞 뒤로 어떤 문자열이 오는 지 저장한다.
- 편의상, 앞 문자열은 `startStr`, 뒷 문자열은 `endStr`로 이름을 붙이겠다.
- N만큼 반복하여 입력 받으며, substring을 사용해서 입력받은 문자열 `str`의 startStr의 길이만큼 자른 후 `equals` 함수로 비교한다.
- 뒷 문자열도 마찬가지로 뒤에서 `endStr`의 길이만큼 자른 후 `equals` 함수로 비교한다.
- 둘 다 만족하면 DA를, 하나라도 만족하지 않으면 NE를 출력한다.

<br>

## 주의할 점
`if(str.length() >= startStr.length() + endStr.length())` 이 조건문을 사용하지 않으면,  
substring 함수를 사용할 때  

```
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: begin 0, end 4, length 2
```

- 위와 같이 런타임 에러 (StringIndexOutOfBounds)가 발생할 수 있으므로 주의!! 

<br>
