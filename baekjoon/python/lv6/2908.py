# 브론즈 2
# 2908: 상수

# 두 수 입력
A,B = input().split()
# 상수 대답 판별
A = int(A[::-1])
B = int(B[::-1])
# 상수 대답 출력
print(max(A,B))