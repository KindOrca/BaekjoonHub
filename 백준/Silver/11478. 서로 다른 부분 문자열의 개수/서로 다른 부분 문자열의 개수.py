word = input()
L = len(word)
tmp = set()
for i in range(1, L):
    for j in range(L-i+1):
        tmp.add(word[j:j+i])
print(len(tmp)+1)