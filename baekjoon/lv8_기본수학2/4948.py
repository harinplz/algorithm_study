# 실버3
# 4948: 베르트랑 공준
prime_num = [True for _ in range(123456*2+1)]
prime_num[0], prime_num[1] = False, False
for i in range(2, int(123456*2**0.5) + 1):
    if prime_num[i] == True:
        j = 2
        while i*j <= 2*123456:
            prime_num[i*j] = False
            j+=1
while True:
    N=int(input())
    if N==0:
        break
    else:
        cnt=0
        for i in range(N+1, 2*N+1):
            if prime_num[i] == True:
                cnt+=1
        print(cnt)