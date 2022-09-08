# 실버5
# 2869: 달팽이는 올라가고 싶다.

A,B,V = map(int, input().split())

# a*days - b*(days-1) >= V : 낮시간
# a*days - b*days - b >= V
# days(a-b) >= V+b
# days >= (V+b)/(a-b)

if (V-B) % (A-B) == 0:
    print((V-B)//(A-B))
else:
    print((V-B)//(A-B)+1)
