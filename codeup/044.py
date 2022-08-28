# [기초-산술연산] 정수 2개 입력받아 자동 계산하기(py)

num1, num2 = input().split()

num1 = int(num1)
num2 = int(num2)

print(num1+num2)
print(num1-num2)
print(num1*num2)
print(num1//num2)
print(num1%num2)
print(format(num1/num2, ".2f"))