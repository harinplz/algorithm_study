# 실버 4
# 1065번: 한수

# 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다.
# 등차수열은 연속된 두 개의 수 차이가 일정한 수열을 말한다.

## 문제를 다시 읽고 짠 코드 : 시간 68ms
# 입력 1000보다 작은 숫자라고 제한을 둠. 첫번째 두번째 자리 수 차이와 두번째 세번째 자리 수 차이만 비교하면 된다.
# 문제 잘 읽기!!
def hansoo(num):
    cnt = 0
    for i in range(1, num+1):
        if i<100:
            cnt+=1
        elif int(str(i)[0]) - int(str(i)[1]) == int(str(i)[1]) - int(str(i)[2]):
            cnt+=1
    
    return cnt

## 너무 복잡하게 짠 처음 코드 시간 : 72ms
# def hansoo(num):
#     cnt = 0
#     for i in range(1, num+1):
#         if i in range(1, 99+1):
#             cnt+=1
#         else:
#             for j in range(len(str(i))-1):
#                 if j == 0:
#                     diff = int(str(i)[j]) - int(str(i)[j+1])
#                 else:
#                     if diff == int(str(i)[j]) - int(str(i)[j+1]):
#                         check = 0
#                     else:
#                         check = 1

#             if check == 0:
#                 cnt += 1 
#     return cnt


n = int(input())
print(hansoo(n))