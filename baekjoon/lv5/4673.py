# 실버 5
# 4673번: 셀프 넘버

# 셀프 넘버를 구하는 방법!
# 모든 숫자 - 생성자가 있는 수 빼기!!  #

all_num = set(range(1, 10000+1))
not_selfnum = set()

for i in range(1, 10000+1):
    num = 0
    for j in str(i): #33
        num += int(j)
    num += i
    not_selfnum.add(num)

selfnum = all_num - not_selfnum
selfnum = sorted(selfnum)

for num in selfnum:
    print(num)


