# 6083 : [기초-종합] 빛 섞어 색 만들기

r, g,b = map(int, input().split())
sum = 0

for i in range(r):
    for j in range(g):
        for k in range(b):
            print(i, j, k)
            sum = sum+1

print(sum)