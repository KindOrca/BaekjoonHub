using System;
class MainApp
{
    static int Blue;
    static int White;
    static int[,] Map;
    static void Cut(int A, int B, int N)
    {
        int Pivot = Map[A, B];
        bool Check = true;
        for (int i = A; i < A + N; i++)
        {
            for (int j = B; j < B + N; j++)
            {
                if (Map[i, j] != Pivot)
                    Check = false;
            }
        }
        if (Check)
        {
            if (Pivot == 1) Blue++;
            else White++;
        }
        else
        {
            Cut(A, B, N / 2);
            Cut(A + N / 2, B, N / 2);
            Cut(A, B + N / 2, N / 2);
            Cut(A + N / 2, B + N / 2, N / 2);
        }
    }
    static void Main(string[] args)
    {
        int N = int.Parse(Console.ReadLine());
        Map = new int[N, N];
        for (int i = 0; i < N; i++)
        {
            string[] Input = Console.ReadLine().Split();
            for (int j = 0; j < N; j++)
            {
                Map[i, j] = int.Parse(Input[j]);
            }
        }
        Cut(0, 0, N);
        Console.WriteLine(White);
        Console.WriteLine(Blue);
    }
}