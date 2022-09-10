# 부녀회장이 될테야
# 브론즈1

T = int(input())
for _ in range(T):
    k=int(input())
    n=int(input())
    apart=[i for i in range(1,n+1)]
    for floor in range(k):
        for room in range(1,n): #호수 1은 전부다 1임
            apart[room] += apart[room-1]
    print(apart[-1])
