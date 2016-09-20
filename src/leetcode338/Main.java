package leetcode338;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.countBits(5));
	}
	
	

}

class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        
    	for (int i=0; i<=num ; i++){
    		result[i] = getOnesInNumber(i);
    		System.out.println(result[i]);
    	}
        
    	return result;
    }
    
    public static int getOnesInNumber(int number){
    	if (number == 0 || number ==1){
    		return number;
    	}
//    	if(number == 1){
//    		return 1;
//    	}
    	int counter = 0;
    	while(number!=0){
    		counter += number %2;
    		number /= 2;
    	}
//    	counter = counter+1;
    	return counter;
    }
}