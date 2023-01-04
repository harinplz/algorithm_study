# 브론즈1
# 10989: 수 정렬하기 3
import sys
cnt_list=[0 for _ in range(10000+1)]
N=int(sys.stdin.readline())
for i in range(N):
    num=int(sys.stdin.readline())
    cnt_list[num]+=1
for i in range(1, 10000+1):
    cnt = cnt_list[i]
    for _ in range(cnt):
        print(i)