# 브론즈 5
# 2739번: 구구단

N = int(input()) #N을 입력받음

for i in range(1, 9+1):
    print('{} * {} = {}'.format(N, i, N*i))