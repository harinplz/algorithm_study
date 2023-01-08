import sys
tc = int(sys.stdin.readline().rstrip())
arr = []
for _ in range(tc):
    cmd = sys.stdin.readline().rstrip()
    if 'push' in cmd:
        p, x = cmd.split()
        x = int(x)
        arr.append(x)
        continue
    if cmd == 'pop':
        if len(arr) == 0:
            print(-1)
        else:
            print(arr.pop())
    elif cmd == 'size':
        print(len(arr))
    elif cmd == 'empty':
        if len(arr) == 0:
            print(1)
        else:
            print(0)
    elif cmd == 'top':
        if len(arr) == 0:
            print(-1)
        else:
            print(arr[len(arr)-1])