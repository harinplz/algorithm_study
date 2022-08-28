# 6089 : [기초-종합] 수 나열하기2

a, r, n = map(int, input().split())
result = 0

for i in range(1, n+1):
    if i == 1:
        result = a
    else:
        result = result * r

print(result)