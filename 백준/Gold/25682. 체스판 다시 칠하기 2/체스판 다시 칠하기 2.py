import sys
input = sys.stdin.readline
N, M, K = map(int, input().split())
chess = [list(input().rstrip()) for _ in range(N)]    

def find(shape):
    check = [[0]*(M) for _ in range(N)]
    checksum = [[0]*(M+1) for _ in range(N+1)]
    for i in range(N):
        for j in range(M):
            if (i+j) % 2 == 0:
                if chess[i][j] == shape:
                    check[i][j] = 1
            else:
                if chess[i][j] != shape:
                    check[i][j] = 1
            checksum[i+1][j+1] = checksum[i][j+1] + checksum[i+1][j] - checksum[i][j] + check[i][j]

    ans = 987654321
    for i in range(1, N-K+2):
        for j in range(1, M-K+2):
            tmp = checksum[i+K-1][j+K-1] - checksum[i-1][j+K-1] - checksum[i+K-1][j-1] + checksum[i-1][j-1]
            ans = min(ans, tmp)
    return ans

print(min(find('B'), find('W')))