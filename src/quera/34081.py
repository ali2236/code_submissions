n, k = map(int, input().split(' '))
start, count = 0, 0
while True:
    start = (start + k) % n
    count += 1
    if start == 0:
        break
    pass
pass
print(count)