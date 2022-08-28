# 6097 : [기초-리스트] 설탕과자 뽑기

# 첫 줄에는 격자판의 세로(h), 가로(w)가 공백을 두고 입력
# 두 번째 줄에는 놓을 수 있는 막대의 개수(n)
# 세 번째 줄부터 각 막대의 길이(k), 방향(d), 좌표(x,y)가 입력
# 방향 d == 0 : 가로, d == 1 : 세로

# 격자판의 세로, 가로 길이 입력 받음
h, w = map(int, input().split())

# 막대의 개수 입력
n = int(input())

# h, w 만큼 격자판 생성
p = [[0 for j in range(w+1)] for i in range(h+1)]

# 막대 입력
for i in range(n):
    k, d, x, y = map(int, input().split())

    if d == 0: # 막대가 가로로 놓아질 경우
        for i in range(k):
            p[x][y+i] = 1
    else: # 막대가 세로로 놓아질 경우
        for j in range(k):
            p[x+j][y] = 1
2

for i in range(1, h+1):
    for j in range(1, w+1):
        print(p[i][j], end=' ')
    print()
