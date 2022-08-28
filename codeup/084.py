# 6084 : [기초-종합] 소리 파일 저장용량 계산하기

h, b, c, s = map(int, input().split())

space = h * b * c * s / 8 /1024 /1024
print("%.1f MB"%space)