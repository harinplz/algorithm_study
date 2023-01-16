# 브론즈 1
# 4344번: 평균은 넘겠지
import sys

# 테스트 케이스 입력
C = int(input())

# 테스트 케이스 반복
for i in range(C):
    # 학생의 수, N명의 점수 입력 받음
    score_list = list(map(int, sys.stdin.readline().split()))
    # 평균 계산
    avg = sum(score_list[1:])/score_list[0]
    # 평균을 넘는 학생 수 비율 계산
    cnt = 0
    for j in range(1, len(score_list)):
        if score_list[j] > avg:
            cnt += 1
    
    stu_rate = cnt/score_list[0] * 100
    print(f"{stu_rate:.3f}%")