dic = {'i':'e', 'e':'i', 'I':'E', 'E':'I',}
while 1:
    try:
        name = input()
        for i in name:
            if i in ['i','e','I','E']:
                print(dic[i], end='')
            else:
                print(i, end='')
        print()
    except EOFError:
        break