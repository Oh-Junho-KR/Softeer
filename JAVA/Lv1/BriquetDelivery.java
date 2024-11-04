import java.io.*;
import java.util.*;

public class BriquetDelivery {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        int nMin = 0;
        int nRst = 0;
        int nCnt = Integer.parseInt(sc.nextLine());
        String[] arrInput = sc.nextLine().split(" ");

        // 초기 입력 값을 기준
        nMin = Integer.parseInt(arrInput[1]) - Integer.parseInt(arrInput[0]);
        nRst++;

        // 2번째 마을부터 Min값 비교
        for (int i = 1; i < nCnt - 1; i++) {
            int nTmp = Integer.parseInt(arrInput[i + 1]) - Integer.parseInt(arrInput[i]);
            if (nTmp < nMin){
                nMin = nTmp;
                nRst = 1;
            } else if (nTmp == nMin) {
                nRst++;
            }
        }

        System.out.println(nRst);
    }
}
