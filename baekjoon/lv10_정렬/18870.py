# 실버 2
# 18870: 좌표 압축
import sys
N=int(sys.stdin.readline())
num_list = list(map(int, sys.stdin.readline().split()))
sorted_num_list = sorted(set(num_list))
sorted_dict={}
for i in range(len(sorted_num_list)):
	sorted_dict[sorted_num_list[i]] = i
for num in num_list:
	print(sorted_dict[num], end=" ")