using System;
class MainApp
{
    static void Main(string[] args)
    {
        string[] Input = Console.ReadLine().Split();
        int N = int.Parse(Input[0]);
        int K = int.Parse(Input[1]);
        int[,] Map = new int[K + 1, N + 1];
        for (int i = 1; i < N + 1; i++)
        {
            Map[1, i] = 1;
        }
        for (int i = 1; i < K + 1; i++)
        {
            Map[i, 1] = i;
        }
        for (int i = 2; i < K + 1; i++)
        {
            for (int j = 2; j < N + 1; j++)
            {
                Map[i, j] = (Map[i, j - 1] + Map[i - 1, j]) % 1000000000;
            }
        }
        Console.WriteLine(Map[K, N]);
    }
}