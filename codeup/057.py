# 6057 : [기초-논리연산] 참/거짓이 서로 같을 때에만 참 출력하기

a, b = map(int, input().split())
a = bool(a)
b = bool(b)

bol = ((not a) and (not b)) or (a and b)
print(bol)