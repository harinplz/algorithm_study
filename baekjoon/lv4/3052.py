# 브론즈 2
# 3052번: 나머지

na_list = []
for i in range(0, 9+1):
    n = int(input())
    na_list.append(n%42)

print(len(set(na_list)))