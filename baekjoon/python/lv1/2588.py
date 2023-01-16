# 브론즈 3
# 2588번: 곱셈

A = int(input())
B = int(input())

C = B % 10
D = (B % 100) // 10
E = B // 100

print(A*C, A*D, A*E, A*B, sep='\n')