# 6079 : [기초-종합] 언제까지 더해야 할까?

# 정수 1개가 입력된다.
# 1,2,3,4,5를 순서대로 계속 더해 합을 만들다가,
# 입력된 정수와 같거나 커졌을 때, 마지막에 더한 정수를 출력한다.

num = int(input())
sum = 0

for i in range(num+1):
    sum += i
    if(sum >= num):
        print(i)
        break
