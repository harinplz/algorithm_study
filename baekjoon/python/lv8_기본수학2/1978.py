# 실버 5
# 1978번: 소수 찾기
N = int(input())
num = list(map(int, input().split()))
cnt = 0
for i in range(N):
    if num[i] > 1:
        check=0
        for j in range(2, num[i]):
            if num[i] % j == 0:
                check=1
                break
        if check==0:
            cnt+=1
print(cnt)