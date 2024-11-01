import java.io.*;
import java.util.*;

public class TrenDelFindelMundo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nCnt = Integer.parseInt(sc.nextLine());
        int nMinX = 1000;
        int nMinY = 1000;

        if (nCnt == 1){
            String[] sPoint = sc.nextLine().split(" ");
            nMinX = Integer.parseInt(sPoint[0]);
            nMinY = Integer.parseInt(sPoint[1]);
        } else {
            for (int i = 0; i < nCnt; i++){
                String[] sPoint = sc.nextLine().split(" ");
                nMinX = nMinY > Integer.parseInt(sPoint[1]) ? Integer.parseInt(sPoint[0]) : nMinX;
                nMinY = nMinY > Integer.parseInt(sPoint[1]) ? Integer.parseInt(sPoint[1]) : nMinY;
            }
        }

        System.out.println(nMinX + " " + nMinY);
    }
}
