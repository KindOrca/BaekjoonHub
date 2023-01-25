var sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
int N = int.Parse(sr.ReadLine());
if (N == 1)
{
    Console.WriteLine(0);
    return;
}
List<List<(int, int)>> list = new List<List<(int, int)>>();
for (int i = 0; i < N + 1; ++i)
{
    list.Add(new List<(int, int)>());
}
for (int i = 0; i < N - 1; ++i)
{
    string[] Input = sr.ReadLine().Split();
    int A = int.Parse(Input[0]);
    int B = int.Parse(Input[1]);
    int D = int.Parse(Input[2]);
    list[A].Add((B, D));
}
int[] Cache = new int[N + 1];
int BFS(int a)
{
    if (list[a].Count == 0) return 0;
    foreach (var item in list[a])
    {
        Cache[a] = Math.Max(Cache[a], BFS(item.Item1) + item.Item2);
    }
    return Cache[a];
}
BFS(1);
int cnt = Cache[list[1][0].Item1] + list[1][0].Item2;
List<int> ps = new List<int>();
for (int i = 1; i < N + 1; ++i)
{
    if (list[i].Count <= 1) continue;
    foreach (var item in list[i])
    {
        ps.Add(Cache[item.Item1] + item.Item2);
    }
    ps.Sort();
    cnt = Math.Max(cnt, ps[ps.Count - 1] + ps[ps.Count - 2]);
    ps.Clear();
}
Console.WriteLine(cnt);
sr.Close();