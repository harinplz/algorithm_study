# 6068 : [기초-조건/선택실행구조] 점수 입력받아 평가 출력하기

score = int(input())

if score >= 90:
    print('A')
else:
    if score >= 70:
        print('B')
    else:
        if score >= 40:
            print('C')
        else:
            print('D')