# 실버5
# 1427번: 소트인사이드
import sys
N=sys.stdin.readline().strip()
num_list=[]
for i in N:
    num_list.append(i)
for i in sorted(num_list, reverse=True):
    print(i, end="")