import java.io.*;
import java.util.*;

public class Vote {

    public static void main(String[] args) {
        StringBuilder sbResult = new StringBuilder();
        int nCnt = 0;
        Scanner sc = new Scanner(System.in);
        nCnt = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < nCnt; i++){
            sbResult.delete(0, sbResult.length());
            
            int nNum = Integer.parseInt(sc.nextLine());
            int nFive = nNum / 5;
            int nOne = nNum % 5;

            for (int j = 0; j < nFive; j++){
                if (sbResult.length() > 0){
                    sbResult.append(" ");
                }
                sbResult.append("++++");
            }

            for (int j = 0; j < nOne; j++){
                if (sbResult.length() > 0 && j == 0){
                    sbResult.append(" ");
                }

                sbResult.append("|");
            }

            System.out.println(sbResult);
        }
    }
}
