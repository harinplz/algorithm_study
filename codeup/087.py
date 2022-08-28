# 6087 : [기초-종합] 3의 배수는 통과

num = int(input())

for i in range(num +1):
    if i%3 ==0:
        continue
    else:
        print(i, end=" ")