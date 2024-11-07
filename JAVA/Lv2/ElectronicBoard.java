import java.io.*;
import java.util.*;

public class ElectronicBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nCnt = Integer.parseInt(sc.nextLine());
        List<Integer> lstResult = new ArrayList<Integer>();
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(0, "1110111");
        map.put(1, "0010010");
        map.put(2, "1011101");
        map.put(3, "1011011");
        map.put(4, "0111010");
        map.put(5, "1101011");
        map.put(6, "1101111");
        map.put(7, "1110010");
        map.put(8, "1111111");
        map.put(9, "1111011");
        map.put(10, "0000000"); // 아무것도 키지 않을 때 (자리수에 포함되지 않을 경우)
        
        for (int i = 0; i < nCnt; i++){
            String[] arrInput = sc.nextLine().split(" ");
            List<String> lstBefore = new ArrayList<String>();
            List<String> lstAfter = new ArrayList<String>();

            int nIdx = 0;
            for (int j = 0; j < 5; j++){
                if (5 - j > arrInput[0].length()){
                    lstBefore.add(map.get(10)); // 자리수 미포함일 경우
                } else {
                    lstBefore.add(map.get(Integer.parseInt(String.valueOf(arrInput[0].charAt(nIdx++)))));
                }
            }
            
            nIdx = 0;
            for (int j = 0; j < 5; j++){
                if (5 - j > arrInput[1].length()){
                    lstAfter.add(map.get(10)); // 자리수 미포함일 경우
                } else {
                    lstAfter.add(map.get(Integer.parseInt(String.valueOf(arrInput[1].charAt(nIdx++)))));
                }
            }

            lstResult.add(fnGetChangeCount(lstBefore, lstAfter));
        }

        for (int i = 0; i < lstResult.size(); i++){
            System.out.println(lstResult.get(i));
        }
    }

    public static int fnGetChangeCount(List<String> sBefore, List<String> sAfter){
        int nRst = 0;

        for (int i = 0; i < 5; i++) { // 5개 자리수
            for (int j = 0; j < 7; j++){ // 각 숫자별 0,1 체크 유무
                if (!sBefore.get(i).equals(sAfter.get(i))) {
                    if (String.valueOf(sAfter.get(i).charAt(j)).equals("0")){
                        if (String.valueOf(sBefore.get(i).charAt(j)).equals("1")) {
                            nRst++;
                        }
                    } else {
                        if (String.valueOf(sBefore.get(i).charAt(j)).equals("0")) {
                            nRst++;
                        }
                    }
                }
            }
        }
        
        return nRst;
    }
}
