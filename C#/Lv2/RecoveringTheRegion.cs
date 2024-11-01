using System;

namespace softeer
{
    class RecoveringTheRegion
    {
        static void Main(string[] args)
        {
            int nCnt = Convert.ToInt32(Console.ReadLine());
            int[,] arrPuzzle = new int[nCnt,nCnt];
            for (int i = 0; i < nCnt; i++){
                if (i > 0) {
                    Console.WriteLine("");
                }
                
                for (int j = 0; j < nCnt; j++){
                    Console.Write(i + 1);
                    if (j != nCnt - 1){
                        Console.Write(" ");
                    }
                }
            }
        }
    }
}
