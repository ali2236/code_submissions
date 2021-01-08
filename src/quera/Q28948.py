s = list(input())
stk = []
for c in s:
    if c == '=':
        if stk:
            stk.pop()
    else:
        stk.append(c)
print(''.join(stk))
