var sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
string[] Input = sr.ReadLine().Split();
int N = int.Parse(Input[0]);
int M = int.Parse(Input[1]);
int[,] map = new int[N, M];
int[,,] path = new int[N, M, 2];
for (int i = 0; i < N; ++i)
{
    for (int j = 0; j < M; ++j)
    {
        path[i, j, 0] = int.MaxValue;
        path[i, j, 1] = int.MaxValue;
    }
}
for (int i = 0; i < N; ++i)
{
    string input = sr.ReadLine();
    for (int j = 0; j < M; ++j)
    {
        map[i, j] = int.Parse(input[j].ToString());
    }
}
int[] MoveLR = { -1, 1, 0, 0 };
int[] MoveUP = { 0, 0, -1, 1 };
void BFS()
{
    Queue<(int, int, bool)> queue = new Queue<(int, int, bool)>();
    bool[,,] visited = new bool[N, M, 2];
    queue.Enqueue((0, 0, false));
    path[0, 0, 0] = 1;
    visited[0, 0, 0] = true;
    while (queue.Count > 0)
    {
        var now = queue.Dequeue();
        for (int i = 0; i < 4; ++i)
        {
            int na = now.Item1 + MoveLR[i];
            int nb = now.Item2 + MoveUP[i];
            if (na < 0 || na >= N || nb < 0 || nb >= M) continue;
            if (map[na, nb] == 1 && !now.Item3)
            {
                path[na, nb, 1] = path[now.Item1, now.Item2, 0] + 1;
                queue.Enqueue((na, nb, true));
            }
            if (map[na, nb] == 1) continue;
            if (now.Item3)
            {
                if (visited[na, nb, 1]) continue;
                path[na, nb, 1] = path[now.Item1, now.Item2, 1] + 1;
                visited[na, nb, 1] = true;
                queue.Enqueue((na, nb, true));
            }
            else
            {
                if (visited[na, nb, 0]) continue;
                path[na, nb, 0] = path[now.Item1, now.Item2, 0] + 1;
                visited[na, nb, 0] = true;
                queue.Enqueue((na, nb, false));
            }
        }
    }
}
BFS();
int ans = Math.Min(path[N - 1, M - 1, 0], path[N - 1, M - 1, 1]);
if (ans == int.MaxValue) Console.WriteLine(-1);
else Console.WriteLine(ans);
sr.Close();