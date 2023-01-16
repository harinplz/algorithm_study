# 브론즈 4
# 15552번: 빠른 A+B
import sys

T = int(input())
for i in range(T):
    a,b = map(int, sys.stdin.readline().split())
    print(a+b)

# 알고리즘 문제를 풀다보면 시간초과가 뜨는 경우가 O
# 그럴 때는 input()대신 sys.stdin.readline()을 사용
# sys.stdin.readline()은 한 줄 단위로 입력받기 때문에 개행문자(\n) 제거가 필요하다. 