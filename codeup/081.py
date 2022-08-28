# 6081 : [기초-종합] 16진수 구구단 출력하기

num = int(input(), 16) #16진수 입력받는 방법

for i in range(1, 16):
    print('%X'%num, '*%X'%i, '=%X'%(num*i), sep='')

