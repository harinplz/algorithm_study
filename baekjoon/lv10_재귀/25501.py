import sys
def recursion(s: str, l:int, r:int):
	global cnt
	cnt += 1
	if(l>=r): return 1;
	elif(s[l] != s[r]): return 0;
	else: return recursion(s, l+1, r-1);

def is_palindrome(s: str):
	return recursion(s, 0, len(s)-1)

input_num = int(sys.stdin.readline())
for _ in range(input_num):
	cnt=0
	s = sys.stdin.readline().strip()
	print(is_palindrome(s), cnt)