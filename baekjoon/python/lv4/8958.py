# 브론즈2
# 8958번: OX퀴즈
import sys

# 테스트케이스 수 입력
N = int(input())

for i in range(N):
    # OX입력받기
    ox = sys.stdin.readline()
    # O가 나오면 점수 1점
    # 연달아 나올 수록 점수가 +1 된다.
    # X가 나오면 점수 리셋
    # 입력받은 OX로 점수 계산
    check = 1
    score = 0
    for j in range(len(ox)):
        if ox[j] == 'O':
            score += check
            check += 1
        else:
            check = 1

    print(score)