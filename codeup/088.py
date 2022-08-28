# 6088 : [기초-종합] 수 나열하기1

a, d, n = map(int, input().split())
result = 0

for i in range(1, n+1):
    if i == 1:
        result = a
    else:
        result = result + d

print(result)