G = int(input())
start = end = 1
ans = []
while True:
    weight = end*end - start*start
    if weight == G: ans.append(end)
    if weight <= G: end += 1
    else: start += 1
    if end == 50001: break

if ans:
    for i in ans:
        print(i)
else: print(-1)