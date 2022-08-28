# 6090 : [기초-종합] 수 나열하기3

a, m, d, n = map(int, input().split())
result = 0

while n -1 > 0:
    a = a*m + d
    n = n-1
        
print(a)
