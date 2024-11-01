import java.io.*;
import java.util.*;

public class BriquetSize {
    public static void main(String[] args) {
        int nResult = 0; // Result
        Scanner sc = new Scanner(System.in); // Scanner
        int nCnt = Integer.parseInt(sc.nextLine()); // Count
        int[] arrRadius = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // String[] -> Int[]
        Arrays.sort(arrRadius); // Sorting

        for (int i = 2; i <= 100; i++){ // 반지름의 모든 크기
            int nTmp = 0; // Temp
            for (int j = 0; j < nCnt; j++){ // 연탄 개수
                if (arrRadius[j] % i == 0){
                    nTmp++;
                }
            }

            if (nResult < nTmp) {
                nResult = nTmp;
            }
        }

        System.out.println(nResult);
    }
}
