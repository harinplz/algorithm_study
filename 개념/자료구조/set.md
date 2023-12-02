# Set

## Set이란?
- 데이터 자료구조 중 하나로 특정한 값을 저장하는 추상자료형이다.
- 이때, **값들은 순서가 존재하지 않으며 중복되지 않는다.**
- 다른 컬렉션 타입은 특정 원소를 검색하는 것이 주 업무인 반면, Set은 대상 원소가 Set에 소속되어있는지 여부를 확인한다.  
- Set은 비선형 구조이기 때문에 '순서'의 개념과 '인덱스'가 존재하지 않아 삽입한 데이터가 순서대로 저장되지 않는다.
- 이 때문에, 값을 추가/삭제하는 경우 Set 내부에서 타겟 값을 검색하여 원하는 기능을 수행해야하기 때문에, 처리 속도가 리스트 구조에 비해 느리다는 단점이 존재한다.

<br>

## Set 구현 클래스

## HashSet
### 1. HashSet이란?
- HashSet은 Set 인터페이스에서 지원하는 구현 클래스이다.
- 이 때문에 Set의 성질을 그대로 상속받는다.
- HashSet은 중복된 값을 허용하지 않으며, List 등과 다르게 저장된 순서가 보장되지 않는다.
  - 만약 저장 순서를 유지해야한다면 LinkedHashSet을 사용해야한다.
- null을 값으로 허용한다.

<br>

### 2. HashSet 구현
#### 1️⃣ HashSet 생성
``` java
// 타입 지정 가능
HashSet<타입명> set1 = new HashSet<타입명>();

// 타입을 생략하여 사용 가능 -> 빈 HashSet 생성 시 사용한다.
HashSet<타입명> set2 = new HashSet<>();

// set1의 모든 값을 가진 HashSet 생성
HashSet<타입명> set4 = new HashSet<>(set1);

// 초기값 지정 가능
HashSet<타입명> set5 = new HashSet<>(Arrays.asList("zero", "base", "one"));
```

<br>

#### 2️⃣ HashSet 값 추가 
- 생성된 HashSet에 `add()` 메서드를 호출하여 값을 추가할 수 있다.
- HashSet은 저장 순서가 보장되지 않기 때문에 특정 위치에 값을 추가할 수 없다. 
``` java
HashSet<String> set = new HashSet<>();
set.add("zero");
set.add("base");
set.add("one");
```

<br>

#### 3️⃣ HashSet 크기 구하기
- `size()` 메서드를 호출하여 크기를 구할 수 있다.
``` java
HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(1,2,3));

System.out.println(set.size()); // 3 출력
```

<br>

#### 4️⃣ HashSet 값 삭제
- `remove(value)`와 `clear()` 메서드를 호출하여 HashSet의 값을 제거할 수 있다.
``` java
HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(1,2,3));

// 값 1 제거하기
set.remove(2);

// 모든 값을 제거하기
set.clear();
```

<br>

#### 5️⃣ HashSet 값 검색
- `contains(value)` 메서드를 호출하여 value가 HashSet 내부에 존재하는 지 확인할 수 있다.
``` java
HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(1, 2, 3));

// set 내부에 1이 있다면 true를 출력하고, 없다면 false를 출력한다.
System.out.println(set.contains(1));
```

<br>

## TreeSet
### 1. TreeSet이란?
- Set 인터페이스를 구현한 클래스로써 객체를 중복해서 저장할 수 없고 저장 순서가 유지되지 않는다는 Set의 성질을 그대로 가지고 있다.
- 이진 탐색 트리의 구조로 이루어져있다. 이진 탐색 트리는 추가와 삭제에는 시간이 조금 더 걸리지만 정렬, 검색에는 높은 성능을 보인다.
- 이진 탐색 트리 형태로 데이터를 저장하기에 기본적으로 *nature ordering을 지원하며 생성자의 매개변수로 Comparator 객체를 입력하여 정렬 방법을 임의로 지정할 수 있다.
  - *nature ordering : 데이터를 저장할 때, 데이터의 자연적인 순서를 기본으로 지원한다는 뜻. 예를 들어 숫자일 경우에는 작은 숫자가 왼쪽에 위치하고 큰 숫자가 오른쪽에 위치하도록 트리가 구성된다.
- TreeSet은 이진 탐색 트리 중에서도 성능을 향상시킨 *레드-블랙 트리로 구현되어있다.
  - *레드-블랙 트리 : 부모보다 작은 값을 가지는 노드는 왼쪽 자식으로, 부모보다 큰 값을 가지는 노드는 오른쪽 자식으로 배치하여 데이터의 추가나 삭제 시 트리가 한쪽으로 치우쳐지지 않도록 균형을 맞추어준다.  
    ![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fczb0Rs%2FbtqEt6tVogn%2FKpmfrL9PfiNK9ioz0WkRq1%2Fimg.png)

<br>

### 2. TreeSet 구현
#### 1️⃣ TreeSet 생성
``` java
TreeSet<Integer> set1 = new TreeSet<Integer>();

// 타입을 생략하여 사용이 가능
TreeSet<Integer> set2 = new TreeSet<>();

// 초기값 지정
TreeSet<Integer> set3 = new TreeSet<Arrays.asList(1,2,3)); 
```
<br>

#### 2️⃣, 3️⃣, 4️⃣, 5️⃣
- TreeSet에 값을 추가, 삭제, 크기 구하기, 검색은 HashSet과 동일한 방식을 사용한다.

<br>

#### 6️⃣ TreeSet 내림차순 정렬
- TreeSet을 생성할 때 파라미터에 Comparator을 입력하여 임의로 정렬할 수 있다.
``` java
// Comparator 입력하여 임의로 내림차순 정렬한다.
TreeSet treeSet = new TreeSet<>(Comparator.reverseOrder());
treeSet.add(5);
treeSet.add(3);
treeSet.add(9);

System.out.println(treeSet); // 출력 결과 : [9, 5, 3]
```

<br>

#### 7️⃣ TreeSet 가장 큰 값, 가장 작은 값 반환 
- `first()` 메서드를 호출하여 가장 작은 값, 즉 이진트리에서 가장 왼쪽 값을 반환한다.
- `last()` 메서드를 호출하여 가장 큰 값, 즉 이진트리에서 가장 오른쪽 값을 반환한다.
``` java
TreeSet<Integer> treeSet = new TreeSet<Arrays.asList(1,2,3));

System.out.println(treeSet.first()); // 출력 결과 : 1
System.out.println(treeSet.last()); // 출력 결과 : 3
```


<br>

#### 참고
[[Java] Set 이란? Java Set 사용법](https://godsu94.tistory.com/173)  
[[Java] HashSet의 개념과 사용법 정리](https://velog.io/@acacia__u/hashSet)  
[Java TreeSet 이진 트리 구조](https://godog.tistory.com/entry/Java-TreeSet-%EC%9D%B4%EC%A7%84-%ED%8A%B8%EB%A6%AC-%EA%B5%AC%EC%A1%B0)  
[[Java] 트리셋(TreeSet) 자료구조 정리](https://velog.io/@db_jam/Java-%ED%8A%B8%EB%A6%AC%EC%85%8BTreeSet-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%EC%A0%95%EB%A6%AC)  
