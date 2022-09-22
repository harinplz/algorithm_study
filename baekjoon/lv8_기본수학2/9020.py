# 실버2
# 골드바흐의 추측
prime_num=[True for _ in range(10000+1)]
prime_num[0], prime_num[1] = False, False
for i in range(2, int(10000**0.5)+1):
    if prime_num[i] == True:
        j = 2
        while i*j <= 10000:
            prime_num[i*j] = False
            j+=1
T = int(input())
while T>0:
    gold = int(input())
    for i in range(gold//2, 2-1, -1):
        if prime_num[i] and prime_num[gold-i]:
            partition = i
            break
    print(partition, gold-partition)
    T-=1