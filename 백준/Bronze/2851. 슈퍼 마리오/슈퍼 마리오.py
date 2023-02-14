import sys
input = sys.stdin.readline
mushrooms = [int(input()) for _ in range(10)]
mSum = [mushrooms[0]]+[0]*9
for i in range(1, 10):
    mSum[i] = mSum[i-1] + mushrooms[i]
    if mSum[i] > 100: break
diff_a = mSum[i] - 100
diff_b = 100 - mSum[i-1]
if diff_a > diff_b: print(mSum[i-1])
else: print(mSum[i])