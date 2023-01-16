# 실버5
# 2869: 달팽이는 올라가고 싶다.

# 9월 16일 푼 방식

import math
A,B,V = map(int, input().split())
X = (V-A)/(A-B)
# X(A-B) + A >= V 에서 생각해낸 식
# A가 더해진다는 건 하루가 더 흘렀다는 이야기이기 때문에
# X값에 1을 더한 상태로 올림을 해준다.
print(math.ceil(X+1))

# #  9월 8일 푼 방식
# A,B,V = map(int, input().split())

# # a*days - b*(days-1) >= V : 낮시간
# # a*days - b*days - b >= V
# # days(a-b) >= V+b
# # days >= (V+b)/(a-b)

# if (V-B) % (A-B) == 0:
#     print((V-B)//(A-B))
# else:
#     print((V-B)//(A-B)+1)
