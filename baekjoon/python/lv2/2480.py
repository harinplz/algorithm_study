# 브론즈 4
# 2480번: 주사위 세개

# # 처음 짠 코드
# a,b,c = map(int, input().split())

# if a==b and b==c and a==c:
#     print(10000 + a*1000)
# elif a!=b and b!=c and a!=c:
#     if a<b:
#         max = b
#     else:
#         max = a
    
#     if max<c:
#         max = c
#     print(max*100)
# else:
#     if a==b and a!=c:
#         print(1000 + a*100)
#     elif b==c and a!=c:
#         print(1000 + b*100)
#     else:
#         print(1000 + c*100)

# set(), sorted() 이용해서 구현
dice = sorted(map(int, input().split()), reverse=True)
k = len(set(dice))

if k == 1: #3개 모두 같을 경우
    print(10000 + 1000 * dice[0])
elif k == 2: #2개가 같을 경우
    print(1000 + dice[1] * 100)
else:
    print(dice[0] * 100)


# 걸리는 시간은 둘 다 같음