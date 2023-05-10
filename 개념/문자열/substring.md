# substring

* `Java` 사용 중 문자열을 **잘라야할 때** 사용하는 함수
* subString 함수는 인자 값의 개수에 따라 2개로 나눠진다. 

<br/>

<h3> ✅ String substring(int index) </h3>

* String의 index부터 끝까지 잘라준다.
* 예시)
``` java
String str = "알고리즘짱";
System.out.println(str.substring(1));
```
위의 코드를 실행하면 콘솔창에 `고리즘짱` 이 출력이 된다. 

<br/>

<h3> ✅ String substring(int beginIndex, int endIndex) </h3>

* String의 beginIndex 지점부터 endIndex 전 위치까지의 문자열을 잘라서 리턴해준다.
* 예시)
``` java
String str = "알고리즘짱";
System.out.println(str.substring(0, 4));
```
위의 코드를 실행하면 콘솔창에 `알고리즘` 이 출력된다. 

<br/>
<br/>
