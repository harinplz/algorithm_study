# 6091 : [기초-종합] 함께 문제 푸는 날

a, b, c = map(int, input().split())

d = max(a,b,c)

while True:
    if d%a == 0 and d%b == 0 and d%c == 0:
        break
    else:
        d = d+1
    
print(d)