#실버4
#11047: 동전0
n, k = map(int, input().split())
coin_list = []
count = 0
for i in range(n):
	i = int(input())
	if i<=k:
		coin_list.append(i)
coin_list.reverse()
for coin in coin_list:
	count += k // coin
	k = k%coin
	if k == 0:
		break
print(count)