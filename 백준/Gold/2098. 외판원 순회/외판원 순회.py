import sys
input = sys.stdin.readline
INF = 987654321

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]
DP = [[0]*(2**N) for _ in range(N)]

def TSP(n, visited):
    if visited == (1<<N)-1:
        if graph[n][0] == 0: return INF
        return graph[n][0]
    if DP[n][visited]: return DP[n][visited]
    DP[n][visited] = INF
    for i in range(N):
        next = 1 << i
        if graph[n][i] == 0 or (visited & next): continue
        DP[n][visited] = min(DP[n][visited], TSP(i, visited|next) + graph[n][i])
    return DP[n][visited]

print(TSP(0,1))