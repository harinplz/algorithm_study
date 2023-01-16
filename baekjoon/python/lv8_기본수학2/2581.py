# 실버5
# 2581번: 소수
M = int(input())
N = int(input())
prime_num = []
for i in range(M, N+1):
    if i > 1:
        check=0
        for j in range(2, i):
            if i % j == 0:
                check=1
                break
        if check==0:
            prime_num.append(i)
if len(prime_num) == 0:
    print(-1)
else:
    print(sum(prime_num))
    print(prime_num[0])