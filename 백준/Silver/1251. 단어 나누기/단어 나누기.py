n = len(s:=input()[::-1])
print(min(s[j:]+s[i:j]+s[:i] for i in range(1,n-1) for j in range(i+1,n)))