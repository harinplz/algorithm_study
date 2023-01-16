arr = [[0 for _ in range(100)] for _ in range(100)]

tc = int(input())
for _ in range(tc):
    a, b = map(int, input().split())

    for i in range(10):
        for j in range(10):
            if arr[a-1+i][b-1+j] == 0:
                arr[a-1+i][b-1+j] = 1

ans = 0
for i in range(100):
    ans += arr[i].count(1)

print(ans)
