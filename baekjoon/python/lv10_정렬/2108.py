# 실버3
# 2108번: 통계학

# 수정한 코드
import sys
from collections import Counter
N=int(sys.stdin.readline())
num_list=[]
for _ in range(N):
    num_list.append(int(sys.stdin.readline()))
num_list.sort()
cnt_dict=Counter(num_list).most_common()
if N==1:
    most_frequency = cnt_dict[0][0]
else:
    if cnt_dict[0][1] == cnt_dict[1][1]:
        most_frequency = cnt_dict[1][0]
    else:
        most_frequency = cnt_dict[0][0]
print(round(sum(num_list)/N))
print(num_list[N//2])
print(most_frequency)
print(num_list[-1]-num_list[0])


# 수정 전 코드
import sys
from collections import Counter
N=int(input())
if N==1:
    num=int(sys.stdin.readline().strip())
    print(num)
    print(num)
    print(num)
    print(0)
else:
    num_list=[]
    for _ in range(N):
        num = int(sys.stdin.readline().strip())
        num_list.append(num)
    num_list.sort()
    cnt_dict = sorted(Counter(num_list).items(), key=lambda x:x[1], reverse=True)
    if cnt_dict[0][1] == cnt_dict[1][1]:
        most_frequency = cnt_dict[1][0]
    else:
        most_frequency = cnt_dict[0][0]
    print(round(sum(num_list)/N))
    print(num_list[N//2])
    print(most_frequency)
    print(num_list[N-1]-num_list[0])