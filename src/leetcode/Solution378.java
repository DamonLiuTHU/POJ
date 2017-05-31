package leetcode;

/**
 * Created by DamonLiu on 16/9/23.
 */
public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        int length = matrix.length;
        //idea1 : merge sort then get the k's value;
        int [] possibleResultArray =  new int[k];
        for (int i = 0; i < possibleResultArray.length; i++) {
            possibleResultArray[i] = Integer.MAX_VALUE;
        }
//        int k2 = (int)Math.pow(k,0.5)+1;
        int checkRange = Math.min(k,length);
        for (int i = 0; i < checkRange; i++) {
            if (matrix[i][0] > possibleResultArray[possibleResultArray.length-1]) break;
            for (int j = 0; j < checkRange; j++) {
                if (matrix[i][j] > possibleResultArray[possibleResultArray.length-1]){
                    break;
                }
                putValueInPosition(matrix[i][j],possibleResultArray);
            }
        }
        return possibleResultArray[k-1];
    }
    // input is array sorted by ascend . put value in position.
    public static void putValueInPosition(int value,int [] input){
        int putIndex = -1;
        if (value >= input[input.length-1]) return;
        for (int i=0;i<input.length;i++){
            if (value < input[i]) {
                putIndex = i;
                break;
            }
        }
        if(putIndex<0){
            return;
        }
        for (int i = input.length -1; i > putIndex ; i--) {
            input[i] = input[i-1];
        }
        input[putIndex] = value;
    }
    public static  void main(String args[]){
        /*
        [[1,3,5],[6,7,12],[11,14,14]]
3
         */
        int[][] input = {{1,3,5},{4,7,12},{11,14,14}};
        int tmp = new Solution378().kthSmallest(input,3);
        System.out.print(tmp);
    }
}
