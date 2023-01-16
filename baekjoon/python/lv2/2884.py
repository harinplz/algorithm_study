# 브론즈 3
# 2884번: 알람 시계

H, M = map(int, input().split())

if M>=45:
    M = M-45
else:
    M = 60 - (45 - M)
    if H == 0:
        H = 23
    else:
        H = H-1

print(H,M)