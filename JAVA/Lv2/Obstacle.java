import java.io.*;
import java.util.*;

public class Obstacle {
    public static int[][] arrInput;
    public static int[][] arrResult;
    public static int nRstCnt = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nCnt = Integer.parseInt(sc.nextLine());
        arrInput = new int[nCnt][nCnt]; // input array
        arrResult = new int[nCnt][nCnt]; // result array
        List<Integer> lstResult = new ArrayList<Integer>(); // List : sorting Result 
        
        // init
        for (int i = 0; i < nCnt; i++){
            char[] arrBoard = sc.nextLine().toCharArray();
            for (int j = 0; j < arrBoard.length; j++){
                if (arrBoard[j] == '0') {
                    arrInput[i][j] = 0;
                } else {
                    arrInput[i][j] = 1;
                }

                arrResult[i][j] = 0; // 탐색 여부 0으로 초기화
            }
        }

        for (int i = 0; i < nCnt; i++) {
            for (int j = 0; j < nCnt; j++) {
                // 방해물이 있고 이미 탐색 완료 체크
                if (arrInput[i][j] == 0 || arrResult[i][j] == 1){
                    continue;
                }
                
                nRstCnt = 1; // 탐색 횟수 초기화 (초기 1회)
                fnDfs(i, j);
                lstResult.add(nRstCnt); // 블록 개수 결과 리스트에 추가
            }
        }

        Collections.sort(lstResult); // 오름차 순으로 정렬 후 출력
        System.out.println(lstResult.size());
        for (int i = 0; i < lstResult.size(); i++){
             System.out.println(lstResult.get(i));
        }
    }

    public static void fnDfs(int x, int y) {
        int[] arrX = {-1, 1, 0, 0};
        int[] arrY = {0, 0, -1, 1};
        
        arrResult[x][y] = 1; // 탐색 결과에 추가
        
        for (int i = 0; i < 4; i++) {
            int nX = x + arrX[i];
            int nY = y + arrY[i];

            // row, col range validation, 초기값과 탐색 결과 비교
            if(nX < 0 || nY < 0 || nX >= arrInput.length || nY >= arrInput.length || arrInput[nX][nY] == 0 || arrResult[nX][nY] == 1) {
                continue;
            }

            nRstCnt++; // 탐색 횟수 추가
            fnDfs(nX, nY);
        }
    }
}
