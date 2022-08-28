# 6098 : [기초-리스트] 성실한 개미

# 10x10 크기의 2차원 배열 생성
p = [[0 for j in range(10+1)] for i in range(10+1)]

# 개미 길 입력 받기 
for i in range(10):
    a = input().split()
    for j in range(10):
        p[i+1][j+1] = int(a[j])

a = 2
b = 2
p[a][b] = 9

# 개미 길 찾는 알고리즘
while True:
    if a == 10 and b == 10: #개미가 맨 아래쪽 가장 오른쪽에 도달했을 경우 break
        break

    if p[a][b+1] == 2:
        p[a][b+1] = 9
        break
    if p[a][b+1] == 0: #개미 오른쪽이 0일때
        p[a][b+1] = 9
        b = b+1

    if p[a+1][b] == 2:
        p[a+1][b] = 9
        break
    elif p[a][b+1] == 1: #개미 오른쪽이 1(벽)일때
        if p[a+1][b] == 1: #개미의 아래쪽도 1이라면 이동할 수 X
            break
        elif p[a+1][b] == 0: #개미의 아래쪽이 0이라면 아래로 이동
            p[a+1][b] = 9
            a = a+1

# 개미 길 출력
for i in range(1, 10+1):
    for j in range(1, 10+1):
        print(p[i][j], end=' ')
    print()