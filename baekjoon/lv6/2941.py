# 실버 5
# 2941: 크로아티아 알파벳

# 크로아티아 알파벳으로 이루어진 문자열 입력
string = input()
# 알파벳 개수 세기
croatia_alphabet = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
for alpha in croatia_alphabet:
    if alpha in string:
        string = string.replace(alpha, 'a')
# 개수 출력
print(len(string))