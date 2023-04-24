import sys
input = sys.stdin.readline
N = int(input())
X_set, Y_set = [], []
for _ in range(N):
    x, y = map(int, input().split())
    X_set.append(x)
    Y_set.append(y)
X = max(X_set) - min(X_set)
Y = max(Y_set) - min(Y_set)
print(X*Y)