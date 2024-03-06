A = list(map(int, input().split(' : ')))
B = list(map(int, input().split(' : ')))
timeA = 3600*A[0]+60*A[1]+A[2]
timeB = 3600*B[0]+60*B[1]+B[2]
if timeA>timeB: timeB+=86400
print(timeB-timeA)