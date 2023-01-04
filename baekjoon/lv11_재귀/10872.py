# 브론즈 5
# 10872: 팩토리얼
import sys
def fact(n):
	if n == 1 or n == 0:
		return 1
	else:
		return n * fact(n-1)
N=int(sys.stdin.readline())
print(fact(N))