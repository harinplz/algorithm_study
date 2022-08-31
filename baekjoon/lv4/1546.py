# 브론즈 1
# 1546번: 평균

N = int(input())# 시험 본 과목 개수 입력
orig_list = list(map(int, input().split()))# 세준이 현재 성적

max_score = max(orig_list)
new_list = []

# 점수 조작
for i in range(N):
    new_score = (orig_list[i]/max_score)*100
    new_list.append(new_score)

# 조작된 평균 출력
print(sum(new_list)/N)
