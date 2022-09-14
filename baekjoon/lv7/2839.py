# 실버4
# 설탕배달

N = int(input())
check = 0

if N%5 == 0:
    check==1
    print(N//5)
else:
    val5 = N//5
    if val5 == 0:
        if N%3 != 0:
            check=1
            print(-1)
        else:
            check=1
            print(1)
    else :
        for i in range(val5, 0-1, -1):
            val3 = N-(5*i)
            if val3 % 3 == 0:
                check=1
                print(5*i//5 + val3//3)
                break
    if check == 0:
        print(-1)
