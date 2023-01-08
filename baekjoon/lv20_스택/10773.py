import sys
k = int(sys.stdin.readline().rstrip())
arr = []
for _ in range(k):
    num = int(sys.stdin.readline().rstrip())
    if num == 0:
        arr.pop()
    else:
        arr.append(num)
print(sum(arr))