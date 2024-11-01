using System;
using System.Text;

namespace softeer
{
    class XMarksTheSpot
    {
        static void Main(string[] args)
        {
            int nCnt = Convert.ToInt32(Console.ReadLine());
            StringBuilder sbResult = new StringBuilder();
            
            for (int i = 0; i < nCnt; i++) {
                string[] arrWord = Console.ReadLine().Split(' ');
                arrWord[0] = arrWord[0].ToUpper();
                sbResult.Append(arrWord[1].Substring(arrWord[0].ToUpper().IndexOf('X'), 1).ToUpper());
            }

            Console.WriteLine(sbResult.ToString());
        }
    }
}
