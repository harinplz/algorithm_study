# 브론즈 5
# 10951번: A+B-4
import sys

lines = sys.stdin.readlines()

for line in lines:
    a,b = map(int, line.split())
    print(a+b)