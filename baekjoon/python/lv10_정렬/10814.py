# 실버 5
# 10814: 나이순 정렬
import sys
N=int(sys.stdin.readline())
member_list=[]
for _ in range(N):
	age, name = sys.stdin.readline().split()
	age = int(age)
	member_list.append((age, name))
for age, name in sorted(member_list, key=lambda x:x[0]):
	print(age, name)