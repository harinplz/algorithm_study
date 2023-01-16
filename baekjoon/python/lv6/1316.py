# 실버 5
# 그룹 단어 체커

# # 내가 짜서 엄청 복잡한 코드 .. 
# N=int(input())
# cnt=0
# for i in range(N):
#     word = input()
#     alpha_list=[0 for _ in range(26)]
#     for a in range(len(word)):
#         alpha_index = ord(word[a]) - 97
#         alpha_list[alpha_index]+=1
#         if a != 0:
#             if word[a] == word[a-1]:
#                 alpha_list[alpha_index] -= 1
#             elif alpha_list[alpha_index]>1:
#                 break
#     if len(set(alpha_list))==2:
#         cnt+=1
# print(cnt)
    
# 훨씬 간결한 코드! 참고하기!
result = 0
for i in range(int(input())):
    word = input()
    if list(word) == sorted(word, key=word.find):
        result += 1
print(result)
