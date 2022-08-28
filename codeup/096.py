# 6096 : [기초-리스트] 바둑알 십자 뒤집기

# 19x19 바둑판 생성
d = [[0 for j in range(20)] for i in range(20)]

# 바둑판 0, 1 입력
for i in range(19):
    a = input().split()
    for j in range(19):
        d[i+1][j+1] = int(a[j])
    
# 좌표 수 입력받기
n = int(input())

# 좌표 입력받기 -> 십자 뒤집기
for i in range(n):
    x, y = input().split()
    x = int(x)
    y = int(y)
    for j in range(1, 20):
        if j == y:
            continue
        if d[x][j] == 0:
            d[x][j] = 1
        else:
            d[x][j] = 0

    for k in range(1, 20):
        if k == x:
            continue
        if d[k][y] == 0:
            d[k][y] = 1
        else:
            d[k][y] = 0


# 십자 뒤집기 한 바둑판 출력
for i in range(1, 20):
    for j in range(1,20):
        print(d[i][j], end=' ')
    print()


