# 브론즈 5
#10809: 알파벳 찾기


# #내가 짠 코드
# stri = input()

# for i in range(97,122+1):
#     check = 0
#     for j in range(len(stri)):
#         if stri[j]==chr(i):
#             check=1
#             print(j, end=" ")
#             break
#     if check == 0:
#         print(-1, end=" ")


# 참고해서 짠 코드
# python의 find 함수를 사용하면 없을 시 -1을 출력한다. 
# 시간은 위 코드가 더 짧음
string = input()
alphabet = "abcdefghijklmnopqrstuvwxyz"
for i in alphabet:
    print(string.find(i), end=" ")