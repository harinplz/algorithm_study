# 브론즈 1
# 1157: 단어 공부

# 문자열 입력
s = input()

# 문자열 안에서 가장 많은 문자 계산
s = s.upper()
alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

alpha_list = []
for a in alphabet:
    alpha_list.append(s.count(a))

max_alpha = max(alpha_list)

# 가장 많은 문자 출력
if alpha_list.count(max_alpha) == 1:
    print(chr(65+alpha_list.index(max_alpha)))
elif alpha_list.count(max_alpha) > 1:
    print('?')