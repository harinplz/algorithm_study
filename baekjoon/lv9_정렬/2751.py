# 실버5
# 2751: 수 정렬하기2
import sys
N=int(input())
num_list=[]
for _ in range(N):
    num=int(sys.stdin.readline())
    num_list.append(num)
for num in sorted(num_list):
    print(num)