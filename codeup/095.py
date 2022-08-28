# 6095 : [기초-리스트] 바둑판에 흰 돌 놓기

#크기가 19x19인 2차원 배열 생성
d = []
for i in range(20):
    d.append([])
    for j in range(20):
        d[i].append(0)

# 바둑판에 놓을 흰 돌 개수 입력
n = int(input())

# 흰 돌의 위치 좌표 입력
for i in range(n):
    x, y = input().split()
    x = int(x)
    y = int(y)
    d[x][y] = 1

# 바둑판 출력
for i in range(1, 20):
    for j in range(1, 20):
        print(d[i][j], end=' ')
    print()

