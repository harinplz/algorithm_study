# 6093 : [기초-리스트] 이상한 출석 번호 부르기2

n = int(input())
a = input().split()

for i in range(n-1, 0-1, -1):
    print(a[i], end=' ')