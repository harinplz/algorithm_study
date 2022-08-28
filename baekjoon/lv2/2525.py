# 브론즈 3
# 2525번: 오븐 시계

A,B=map(int, input().split())
C = int(input())

B = B+C
A = A + (B//60)
B = B%60

if A >= 24:
    A = A%24

print(A,B)
