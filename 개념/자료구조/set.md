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

// 초기 용량 설정
HashSet<타입명> set3 = new HashSet<>(10);

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
### TreeSet이란?
- TreeSet



#### 참고
[[Java] Set 이란? Java Set 사용법](https://godsu94.tistory.com/173)  
[[Java] HashSet의 개념과 사용법 정리](https://velog.io/@acacia__u/hashSet)
