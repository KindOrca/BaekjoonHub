N, A, B, C, D = map(int, input().split())
a = N//A+1 if N%A else N//A
c = N//C+1 if N%C else N//C
print(min(a*B, c*D))