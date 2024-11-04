import java.io.*;
import java.util.*;

public class FilialPiety {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sInput; // 라인 별 입력을 Array로 저장
        List<List<String>> lstInput = new ArrayList<List<String>>(); // X, Y 원본 값 저장
        
        while (sc.hasNext()){
            sInput = sc.nextLine().split(" ");
            List<String> lstTmp = new ArrayList<String>();
            for (int i = 0; i < sInput.length; i++){
                lstTmp.add(sInput[i]);
            }

            lstInput.add(lstTmp);
        }
        
        int nRst = 2;
        for (int i = 0; i < lstInput.size(); i++) {
            String[] arrRow = new String[lstInput.size()]; // 임시 Row
            String[] arrCol = new String[lstInput.size()]; // 임시 Col
            String sRow = ""; // 정렬 후 String
            String sCol = ""; // 정렬 후 String
            
            arrRow[0] = lstInput.get(i).get(0);
            arrRow[1] = lstInput.get(i).get(1);
            arrRow[2] = lstInput.get(i).get(2);
            
            arrCol[0] = lstInput.get(0).get(i);
            arrCol[1] = lstInput.get(1).get(i);
            arrCol[2] = lstInput.get(2).get(i);
            
            Arrays.sort(arrRow);
            Arrays.sort(arrCol);

            for (int j = 0; j < arrRow.length; j++){
                sRow += arrRow[j];
            }

            for (int j = 0; j < arrCol.length; j++){
                sCol += arrCol[j];
            }
            
            if (sRow.equals("111") || sRow.equals("222") || sRow.equals("333") ||
               sCol.equals("111") || sCol.equals("222") || sCol.equals("333")){
                nRst = 0;
            } else if (sRow.equals("112") || sRow.equals("122") || sRow.equals("223") || sRow.equals("233") ||
                      sCol.equals("112") || sCol.equals("122") || sCol.equals("223") || sCol.equals("233")){
                nRst = nRst > 1 ? 1 : nRst;
            } else {
                nRst = nRst > 2 ? 2 : nRst;
            }
        }

        System.out.println(nRst);
    }
}
