# 브론즈1
# 11653번: 소인수분해

# 구글링 후 수정한 코드
N = int(input())
num = 2
if N>1:
    while num*num <= N:
        if N%num == 0:
            N //= num
            print(num)
        else:
            num+=1
    print(N)

# # 맞았지만 시간이 너무 오래걸린 코드
# N=int(input())
# num=2
# while N>1:
#     if N%num == 0:
#         N = N//num
#         print(num)
#     else:
#         num+=1