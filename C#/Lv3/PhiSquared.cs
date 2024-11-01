using System;
using System.Collections.Generic;

namespace softeer
{
    class Micro {
        public int nIdx;
        public long lSize;

        public Micro(int nIdx, long lSize){
            this.nIdx = nIdx;
            this.lSize = lSize;
        }
    }
    
    class PhiSquared
    {
        static void Main(string[] args)
        {
            // List -> Queue, Stack 변경 (속도 개선)
            Queue<Micro> queMicro = new Queue<Micro>(); 
            Stack<Micro> stkMicro = new Stack<Micro>();
            Stack<Micro> stkReverse = new Stack<Micro>();
            // 개수
            int nCnt = Convert.ToInt32(Console.ReadLine());
            
            string[] sSize = Console.ReadLine().Split(' ');
            // Queue에 초기화
            for (int i = 0; i < sSize.Length; i++){
                queMicro.Enqueue(new Micro(i + 1, Convert.ToInt32(sSize[i])));
            }

            while (queMicro.Count > 1){
                while (queMicro.Count > 0){
                    Micro mCur = queMicro.Dequeue(); // 현재
                    long lSize = mCur.lSize; // 사이즈

                    // 앞 미생물이 존재할 때 사이즈 비교
                    if (stkMicro.Count > 0 && stkMicro.Peek().lSize <= mCur.lSize){
                        Micro mTmp = stkMicro.Pop();
                        lSize += mTmp.lSize;
                    }

                    // 뒷 미생물이 존재할 때 사이즈 비교
                    if (queMicro.Count > 0 && queMicro.Peek().lSize <= mCur.lSize){
                        Micro mTmp = queMicro.Dequeue();
                        lSize += mTmp.lSize;
                    }

                    stkMicro.Push(new Micro(mCur.nIdx, lSize));
                }

                // Stack Reverse
                stkReverse.Clear();
                while (stkMicro.Count > 0){
                    Micro mTmp = stkMicro.Pop();
                    stkReverse.Push(mTmp);
                }

                queMicro.Clear();
                while (stkReverse.Count > 0){
                    Micro mTmp = stkReverse.Pop();
                    queMicro.Enqueue(mTmp);
                }
            }
                
            Console.WriteLine(queMicro.Peek().lSize);
            Console.WriteLine(queMicro.Peek().nIdx);
        }
    }
}
