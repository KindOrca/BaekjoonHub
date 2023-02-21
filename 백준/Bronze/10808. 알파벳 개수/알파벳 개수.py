from collections import Counter
counter = Counter(input())
seq = 'abcdefghijklmnopqrstuvwxyz'
for let in seq:
    print(counter[let], end=' ')