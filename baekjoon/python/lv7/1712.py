# 브론즈 2
# 1712: 손익분기점

# 220915 풀이
A,B,C = map(int, input().split())
if B>=C:
    print(-1)
else:
    print(int(A/(C-B)+1))

# # 220906 풀이
# A,B,C = map(int, input().split())
# if B>=C:
#     print('-1')
# else:
#     print(int(A/(C-B))+1)

# # 손익분기점이 없을 경우는 A+B*i값이 C*i 값보다 영원히 큰 경우인데, B>=C이면 해당 문장이 성립하므로,
# # B>=C 일때 -1을 출력하도록 한다.
# # A+B*i = C*i 일때 i가 손익분기점. 여기서 +1을 해야 손익분기점을 넘어선다.
# # i를 구하도록 정리를 하면 C*i -B*i = A -> i(C-B) = A -> i = A/C-B
# # i의 값이 정수가 아닐수도 있으므로 int()를 통해 정수로 만들어준다.