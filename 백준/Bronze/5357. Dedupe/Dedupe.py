for _ in range(int(input())):
    word = input()
    print(word[0], end='')
    for i in range(1, len(word)):
        if word[i]!=word[i-1]:
            print(word[i], end='')
    print()