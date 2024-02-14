using System;
using System.Linq;
using System.IO;
class MainApp
{
    static long CurTree(long[] array, long K)
    {
        long Max = array.Max();
        long Min = 0;
        long Key = 0;
        long Sum;
        long Result = 0;
        while (Min <= Max)
        {
            Key = (Max + Min) / 2;
            Sum = 0;
            for (int i = 0; i < array.Length; i++)
            {
                if (Key < array[i]) Sum += array[i] - Key;
            }
            if (Sum < K) Max = Key - 1;
            else
            {
                Result = Key;
                Min = Key + 1;
            }
        }
        return Result;
    }
    static void Main(string[] args)
    {
        var sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
        string[] Input = sr.ReadLine().Split();
        long N = long.Parse(Input[0]);
        long K = long.Parse(Input[1]);
        string[] input = sr.ReadLine().Split();
        long[] array = new long[N];
        for (int i = 0; i < N; i++)
        {
            array[i] = int.Parse(input[i]);
        }
        long Ans = CurTree(array, K);
        Console.WriteLine(Ans);
    }
}