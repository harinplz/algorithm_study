# 6058 : [기초-논리연산] 둘 다 거짓일 경우만 참 출력하기

a, b = map(int, input().split())
a = bool(a)
b = bool(b)

bol = ((not a) and (not b))

print(bol)