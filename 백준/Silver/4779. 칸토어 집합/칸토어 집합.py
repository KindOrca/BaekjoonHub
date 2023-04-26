import sys
input = sys.stdin.readline

def recursion(start, end):
    global line
    if end == 1: return
    L = (end - start)//3
    head = line[:start+L]
    tail = line[end-L:]
    line = head + ' '*L + tail
    if L <= 1: return
    recursion(start,start+L)
    recursion(end-L, end)

while True:
    try:
        N = int(input())
        line = '-'*(3**N)
        recursion(0, len(line))
        print(line)
    except:
        break