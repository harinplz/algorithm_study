# ACM 호텔
# 브론즈 2

T = int(input())

for _ in range(T):
    H,W,N=map(int,input().split()) #H:층, W:호 수, N:몇번쨰 손님인지

    if N%H == 0:
        floor = str(H)
        room = (N//H)
    else:
        floor = str(N%H)
        room = (N//H)+1

    if room < 10:
        room = '0'+str(room)
    else:
        room = str(room)

    print(floor+room)