# 브론즈2
# 2750: 수 정렬하기
N=int(input())
num_list=[]
for _ in range(N):
    num=int(input())
    num_list.append(num)
for num in sorted(num_list):
    print(num)