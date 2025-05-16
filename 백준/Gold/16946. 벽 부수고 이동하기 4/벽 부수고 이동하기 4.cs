var sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
var sw = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));
string[] Input = sr.ReadLine().Split();
int N = int.Parse(Input[0]);
int M = int.Parse(Input[1]);
int[,] map = new int[N, M];
int[,] typeNum = new int[N, M];
int[] type = new int[500001];
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
bool[,] visited = new bool[N, M];
int cnt = 1;
void DFS(int a, int b, int k)
{
    visited[a, b] = true;
    for (int i = 0; i < 4; ++i)
    {
        int na = a + MoveLR[i];
        int nb = b + MoveUP[i];
        if (na < 0 || na >= N || nb < 0 || nb >= M || visited[na, nb] || map[na, nb] == 1) continue;
        ++cnt;
        DFS(na, nb, k);
    }
    typeNum[a, b] = k;
}
int k = 1;
for (int i = 0; i < N; ++i)
{
    for (int j = 0; j < M; ++j)
    {
        if (map[i, j] == 0 && !visited[i, j])
        {
            cnt = 1;
            DFS(i, j, k);
            type[k] = cnt;
            ++k;
        }
    }
}
List<int> list = new List<int>();
for (int i = 0; i < N; ++i)
{
    for (int j = 0; j < M; ++j)
    {
        if (map[i, j] == 0) continue;
        for (int t = 0; t < 4; ++t)
        {
            int na = i + MoveLR[t];
            int nb = j + MoveUP[t];
            if (na < 0 || na >= N | nb < 0 || nb >= M) continue;
            if (list.Contains(typeNum[na, nb])) continue;
            list.Add(typeNum[na, nb]);
            map[i, j] += type[typeNum[na, nb]];
        }
        map[i, j] %= 10;
        list.Clear();
    }
}
for (int i = 0; i < N; ++i)
{
    for (int j = 0; j < M; ++j)
    {
        sw.Write(map[i, j]);
    }
    sw.WriteLine();
}
sr.Close();
sw.Close();