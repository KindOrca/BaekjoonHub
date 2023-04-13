import sys

input = sys.stdin.readline
dic = {
"A+":4.5,
"A0":4.0,
"B+":3.5,
"B0":3.0,
"C+":2.5,
"C0":2.0,
"D+":1.5,
"D0":1.0,
"F":0.0
}
cnt = 0
ans = 0
for i in range(20):
    _, credit, grade = input().split()
    credit = int(credit[0])
    if grade == 'P': continue
    grade = dic[grade]
    cnt += credit
    ans += credit * grade
print(ans/cnt)