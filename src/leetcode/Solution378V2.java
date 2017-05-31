package leetcode;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by DamonLiu on 16/9/23.
 */
public class Solution378V2 {
    public int kthSmallest(int[][] matrix, int k) {
        int totalNumCount = 0;
        int numRange = matrix.length-1;
        for (int i = 0; i < matrix.length * 2 - 1; i++) {
//            for (int j = 0; j < matrix.length; j++) {
            totalNumCount += numberOfNumbersForIndex(i,matrix.length);
            if (totalNumCount >= k){
                numRange = i;
                break;
            }
//            }
        }
        for (int i = 0; i < numRange ; i++) {
            k -= numberOfNumbersForIndex(i,matrix.length);
        }
        //k is the number of values to fetch from index:numRange

        ArrayList<Integer> nums = new ArrayList<>(numberOfNumbersForIndex(numRange,matrix.length));
        if(numRange >= matrix.length){
            int x = numRange - matrix.length +1;
//            int y = matrix.length+1;
            for (int i = 0; i < numberOfNumbersForIndex(numRange,matrix.length); i++) {
                int tmpX = x + i;
                int tmpY = numRange - tmpX;
                nums.add(matrix[tmpX][tmpY]);
            }

        }else{
            for (int i = 0; i < numberOfNumbersForIndex(numRange,matrix.length); i++) {
                int x = i;
                int y = numRange - i;
                nums.add(matrix[x][y]);
            }
        }

        nums.sort(new Comparator<Integer>() {
                      @Override
                      public int compare(Integer o1, Integer o2) {
                          return o1-o2;
                      }
                  }
        );



        return nums.get(k-1);
    }

//    public int getSmallest(int[][] matrix, int x, int y, int k) {
//
//    }


    public static int numberOfNumbersForIndex(int index,int matrixWidth){
        if (index >= matrixWidth){
            return 2*matrixWidth - index -1;
        } else {
            return index+1;
        }
    }

    public static void main(String args[]) {
        /*
        [[1,3,5],[6,7,12],[11,14,14]]
3
         */
        int[][] input = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int tmp = new Solution378V2().kthSmallest(input, 8);
        System.out.print(tmp);
    }
}
