# 6078 : [기초-종합] 원하는 문자가 입력될 때까지 반복 출력하기

# 문자들이 1개씩 계속해서 입력된다.
# 영문 소문자 'q'가 입력될 떄 까지 입력한 문자를 계속해서 출력한다.

while True:
    c = input()
    if c == 'q':
        print(c)
        break
    else:
        print(c)