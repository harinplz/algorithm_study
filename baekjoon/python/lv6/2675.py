# 브론즈 2
# 2675: 문자열반복
import sys

T = int(input())

for i in range(T):
    R, S = sys.stdin.readline().split()
    R = int(R)

    for word in S:
        print(word*R, end="")
    print()