import sys

input = sys.stdin.readline

N, L = map(int, input().split())
Map = [list(map(int, input().split())) for _ in range(N)]

def check(arr):
    pre_len = 1
    pre_hei = arr[0]
    for i in range(1, N):
        if pre_hei == arr[i]: 
            pre_len += 1
            continue
        if abs(pre_hei - arr[i]) > 1: return False
        if pre_hei < arr[i]:
            if pre_len < L: return False
            pre_len = 0
        else:
            if i + L - 1 >= N: return False
            temp = L
            while temp:
                temp -= 1
                if arr[i+temp] != arr[i]: return False
            pre_len = -L
        pre_hei = arr[i]
        pre_len += 1
    return True

cnt = 0
for arr in Map:
    if check(arr):
        cnt += 1

for i in range(N):
    temp = []
    for j in range(N):
        temp.append(Map[j][i])
    if check(temp):
        cnt += 1

print(cnt)