using System;
using System.IO;
using System.Text;
using System.Collections.Generic;
class MainApp
{
    static void TopologySort(List<List<int>> list, int[] indegree, StringBuilder sb)
    {
        var queue = new Queue<int>();
        for (int i = 1; i < indegree.Length; i++)
        {
            if (indegree[i] == 0)
                queue.Enqueue(i);
        }
        while (queue.Count > 0)
        {
            int now = queue.Dequeue();
            sb.Append(now + " ");
            for (int i = 0; i < list[now].Count; i++)
            {
                int A = list[now][i];
                if (--indegree[A] == 0)
                    queue.Enqueue(A);
            }
        }
        for (int i = 1; i < indegree.Length; i++)
        {
            if (indegree[i] != 0)
            {
                sb.Clear();
                sb.Append("IMPOSSIBLE");
                break;
            }
        }
    }
    static void Main(string[] args)
    {
        var sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
        int T = int.Parse(sr.ReadLine());
        string[] Result = new string[T];
        for (int i = 0; i < T; i++)
        {
            List<List<int>> list = new List<List<int>>();
            var sb = new StringBuilder();
            int N = int.Parse(sr.ReadLine());
            string[] Input = sr.ReadLine().Split();
            int[] indegree = new int[N + 1];
            bool[] rank = new bool[N + 1];
            for (int j = 0; j < 501; j++)
            {
                list.Add(new List<int>());
            }
            for (int j = 0; j < N; j++)
            {
                int A = int.Parse(Input[j]);
                rank[A] = true;
                for (int t = 1; t < N + 1; t++)
                {
                    if (rank[t] == false)
                    {
                        list[A].Add(t);
                        indegree[t]++;
                    }
                }
            }
            int M = int.Parse(sr.ReadLine());
            for (int j = 0; j < M; j++)
            {
                string[] input = sr.ReadLine().Split();
                int A = int.Parse(input[0]);
                int B = int.Parse(input[1]);
                if (list[A].Contains(B))
                {
                    list[A].Remove(B);
                    indegree[B]--;
                    list[B].Add(A);
                    indegree[A]++;
                }
                else
                {
                    list[B].Remove(A);
                    indegree[A]--;
                    list[A].Add(B);
                    indegree[B]++;
                }
            }
            TopologySort(list, indegree, sb);
            Result[i] = sb.ToString();
        }
        foreach (string item in Result)
        {
            Console.WriteLine(item);
        }
        sr.Close();
    }
}