import sys
input = sys.stdin.readline

input()
A = set(map(int, input().split()))
B = set(map(int, input().split()))
A_B = len(A-B)
B_A = len(B-A)
print(A_B + B_A)