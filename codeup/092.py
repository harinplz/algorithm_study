# 6092 : [기초-리스트] 이상한 출석 번호 부르기1

n = int(input())
a = input().split()

for i in range(n):
    a[i] = int(a[i])

d = [] #d라는 이름의 빈 리스트 생성
for i in range(23+1):
    d.append(0) #리스트 d 인덱스 23까지 생성

for i in range(n):
    d[a[i]] += 1

for i in range(1, 23+1):
    print(d[i], end=" ")
