import java.io.*;
import java.util.*;

public class AttackTree {

    public static void main(String[] args) {
        int nResult = 0;
        Scanner sc = new Scanner(System.in);
        String[] arrNM = sc.nextLine().split(" ");
        String[] arrWave = null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < Integer.parseInt(arrNM[0]); i++){ // row
            map.put(i, 0); // row의 1 개수 초기화
            String[] arrRow = sc.nextLine().split(" "); // 입력 받기
            for (int j = 0; j < arrRow.length; j++){
                if (Integer.parseInt(arrRow[j]) == 1) {
                    map.put(i, map.get(i) + 1); // 1이 있으면 해당 row에 1 개수 증가
                }
            }
        }

        for (int j = 0; j < 2; j++){
            arrWave = sc.nextLine().split(" ");
        
        for (int i = Integer.parseInt(arrWave[0]) - 1; i < Integer.parseInt(arrWave[1]); i++) {
            if (map.get(i) > 0){
                map.put(i, map.get(i) - 1);
                }
            }
        }
        
        for (int i = 0; i < Integer.parseInt(arrNM[0]); i++){
            if (map.get(i) > 0){
                nResult += map.get(i);
            }
        }

        System.out.println(nResult);
    }
}
