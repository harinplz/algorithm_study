# 브론즈 5
# 3003번: 킹, 퀸, 룩, 비숍, 나이트, 폰

# 체스는 총 16개의 피스 사용
# 킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개로 구성
# 흰색 피스가 주어졌을 때 몇 개를 더하거나 빼야 올바른 세트?


# 내가 짠 코드
k,q,l,b,n,p = map(int, input().split())
print(1-k, 1-q, 2-l, 2-b, 2-n, 8-p)

# # 이렇게 코드 작성하는 것이 더 좋을 듯
# origin = [1,1,2,2,2,8]
# data = list(map(int, input().split()))

# for i in range(6):
#     print(origin[i] - data[i], end=" ")