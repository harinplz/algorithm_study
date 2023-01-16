# 브론즈 5
# 10871번: X보다 작은 수
import sys

N, X = map(int, input().split())

num_list = list(map(int, sys.stdin.readline().split()))

for num in num_list:
    if num < X:
        print(num, end=" ")