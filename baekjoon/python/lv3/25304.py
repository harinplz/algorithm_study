# 브론즈 5
# 25304번: 영수증

X = int(input()) # 총 금액
N = int(input()) # 구매한 물건의 총 개수

sum = 0

for i in range(N):
    a,b = map(int, input().split())
    sum += a*b

if sum == X:
    print('Yes')
else:
    print('No')