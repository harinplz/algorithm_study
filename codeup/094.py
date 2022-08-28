# 6094 : [기초-리스트] 이상한 출석 번호 부르기3

n = int(input())
a = input().split()

for i in range(n):
    a[i] = int(a[i])

m = a[0]

for i in range(n-1):
    m = min(m, a[i+1])

print(m)