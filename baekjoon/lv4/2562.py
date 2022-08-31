# 브론즈 3
# 최댓값

num_list=[]
max = 0
index = 0
for i in range(9):
    a = int(input())
    num_list.append(a)
    if max < a:
        max = a
        index = i+1
        

print(max, index, end='\n')
