# 브론즈 5
# 1110번 : 더하기 사이클
N = int(input())
origin = N
cnt = 0

while(True):
    cnt=cnt+1

    a = N//10 #십의자리
    b = N%10 #일의자리
    c = (a+b)%10

    N = b*10 + c
    if N == origin:
        print(cnt)
        break