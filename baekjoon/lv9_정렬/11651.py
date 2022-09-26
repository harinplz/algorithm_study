# 실버 5
# 11651번: 좌표 정렬하기
import sys
N=int(sys.stdin.readline())
coordinate=[]
for _ in range(N):
    x,y = map(int, sys.stdin.readline().split())
    coordinate.append([x,y])
for x, y in sorted(coordinate, key=lambda x:(x[1], x[0])):
    print(x, y)