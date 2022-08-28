# 6077 : [기초-종합] 짝수 합 구하기

# 정수 1개가 입력된다. (0~100)
# 1부터 그 수까지 짝수만 합해 출력한다.

num = int(input())
sum = 0

for i in range(1, num+1):
    if i%2 == 0:
        sum += i

print(sum)