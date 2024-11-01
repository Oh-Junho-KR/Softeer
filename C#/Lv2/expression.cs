using System;
using System.Text;

namespace softeer
{
    class expression
    {
        static void Main(string[] args)
        {
            string sInput = Console.ReadLine();
            StringBuilder sbResult = new StringBuilder();
            for (int i = 0; i < sInput.Length; i++){
                sbResult.Append(sInput[i]);
                if (i + 1 < sInput.Length){
                    if (sInput[i] == '(' && sInput[i] != sInput[i + 1]){
                        sbResult.Append("1");
                    }

                    if (sInput[i] == ')' && sInput[i + 1] != ')'){
                        sbResult.Append("+");
                    }
                }
            }

            Console.WriteLine(sbResult.ToString());
        }
    }
}
