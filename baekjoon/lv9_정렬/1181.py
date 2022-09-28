# 실버 5
# 1181: 단어 정렬
import sys
N=int(sys.stdin.readline())
word_list = set()
for _ in range(N):
	word = sys.stdin.readline().strip()
	word_list.add(word)
for word in sorted(sorted(word_list), key=len):
	print(word)