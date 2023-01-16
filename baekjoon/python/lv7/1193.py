# 브론즈 1
# 1193: 분수찾기

# 220916 직접 구현한 코드
X = int(input())
line = 1

while True:
    X-=line
    if X<=0:
        break
    line+=1
X+=line

if line%2==0:
    top = X
    bottom = line-X+1
else:
    top = line-X+1
    bottom = X
print(f"{top}/{bottom}")

# # 검색 후 수정한 코드
# input_num = int(input()) # 찾을 분수의 index 입력

# line=0 # line 선언
# end_index = 0 # 라인의 젤 끝에있는 인덱스

# while input_num > end_index: #input_num이 end_index보다 클 때 계속 반복
#     line+=1
#     end_index+=line #1라인:1, 2라인:3, 3라인:6 가 각각 라인의 제일 큰, 제일 끝인 인덱스값이다.

# # line이 짝수일 때는 [1/2, 2/1] 처럼 분자는 증가하고 분모는 감소한다.
# # line이 홀수 일 때는 [3/1, 2/2, 1/3] 처럼 분자는 감소하고 분모는 증가한다.

# diff = end_index - input_num #end_index와 input_num의 차이 계산.
# if line%2==0:
#     top = line-diff
#     bottom = diff+1
# else:
#     top = diff+1
#     bottom = line-diff

# print(f"{top}/{bottom}")



# # 내가 처음으로 작성한 코드
# # 반복문이 많아서 python3으로 검사하니 시간초과가 되었음
# # pypy3으로 돌리니까 성공은 하지만 시간이 오래걸림
# X=int(input())
# num=1
# cnt = 0

# while(True):
#     for i in range(1, num+1):
#         a = i
#         b = num-i+1
#         cnt+=1
#         if cnt==X:
#             break
#     if cnt==X:
#         break
#     else:
#         num+=1

# if num%2==0:
#     print(f"{a}/{b}")
# else:
#     print(f"{b}/{a}")
