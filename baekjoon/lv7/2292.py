# 브론즈2
# 2292: 벌집

# 220915 풀이
N = int(input())
bee_house = 1 
cnt = 1

while N>bee_house: 
    bee_house += cnt*6
    cnt+=1

print(cnt)

# # 220906 풀이
# N = int(input()) # N 입력 받음
# bee_house = 1 # 벌집 개수, 처음은 1
# cnt = 1 # 층 개수, 처음은 1

# while N>bee_house: #벌집 개수가 N보다 작을 때 반복문 실행
#     bee_house += cnt*6
#     cnt+=1

# print(cnt)
