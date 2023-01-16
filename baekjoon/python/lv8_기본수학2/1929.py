# 실버 3
# 1929번: 소수 구하기
M,N = map(int, input().split())
prime_num = [True for _ in range(N+1)]
prime_num[0], prime_num[1] = False, False
for i in range(2, int(N**0.5)+1):
    if prime_num[i] == True:
        j = 2
        while i*j<=N:
            prime_num[i*j] = False
            j+=1
for i in range(M, N+1):
    if prime_num[i] == True:
        print(i)