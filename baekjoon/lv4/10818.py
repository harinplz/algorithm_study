# 브론즈 3
# 10818번: 최소, 최대
import sys

N = int(input())

num_list = list(map(int, sys.stdin.readline().split()))
print(min(num_list), max(num_list), end=" ")