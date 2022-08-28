# 6086 : [기초-종합] 거기까지! 이제 그만~

num = int(input())
sum = 0
c = 1

while True:
    sum = sum + c
    c = c+1
    if sum >= num:
        break

print(sum)