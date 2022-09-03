# 브론즈 2
# 5622: 다이얼

# 외운 단어 입력
string = input()
# 단어를 걸기 위한 최소시간 계산
# 2:ABC, 3:DEF, 4:GHI, 5:JKL, 6:MNO, 7:PQRS, 8:TUV, 9:WXYZ
# 2:3초, 3:4초, 4:5초, 5:6초, ..., 9:10초
dial_list=['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']
time = 0
for alpha in string:
    for i in range(len(dial_list)):
        if alpha in dial_list[i]:
            time+=i+3
# 최소시간 계산
print(time)