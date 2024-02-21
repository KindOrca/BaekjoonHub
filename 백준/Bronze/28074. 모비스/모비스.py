check = True
s = input()
for i in ['M','O','B','I','S']:
    if not i in s:
        check = False
        break
if check: print('YES')
else: print('NO')