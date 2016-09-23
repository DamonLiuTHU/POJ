package POJ.q2593;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int[] input;
	static int[] max_subsequence_from_left;
	static int[] max_subsequence_from_right;
	static int length;
	static int max = Integer.MIN_VALUE;
//	public static int result;
	

	public static int getdA(int[] i_input) {
		input = i_input;
		max_subsequence_from_left = new int[input.length];
		max_subsequence_from_right = new int[input.length];
		length = input.length;
		max = 0;
		if(length == 1){
			return input[0];
		}
		max_subsequence_from_left[0] = input[0];
		max_subsequence_from_right[length-1] = input[length-1];
		for (int i = 1; i < length-1; i++) {
			max_subsequence_from_left[i] = getLeftMax(i);
			int index = length - 1 - i;
			max_subsequence_from_right[index] = getRigthMax(index);
		}
		max_subsequence_from_left[length - 1] = getLeftMax(length-1);
		max_subsequence_from_right[0] = getRigthMax(0);
		for (int i = 0; i < length - 1; i++) {
			int temp =max_subsequence_from_left[i] + getMaxValueFromIndex(i+1); 
			if ( temp > max) {
				max = temp;
			}
		}
//		max -= input[anchor];
//		result = max;
		return max;
	}
	
	private static int getMaxValueFromIndex(int index){
		int max = Integer.MIN_VALUE;
		for(int i = index;i<length;i++){
			if(max_subsequence_from_right[i]>max){
				max = max_subsequence_from_right[i];
			}
		}
		return max;
	}

	private static int getRigthMax(int index) {
//		index += 1;
		return Math.max(input[index] + max_subsequence_from_right[index+1], input[index]);
	}

	private static int getLeftMax(int index) {
		return Math.max(max_subsequence_from_left[index - 1] + input[index], input[index]);
	}

	public static void main(String[] args) {
//		long begin = System.currentTimeMillis();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
//		int casenumber = sc.nextInt();
//		int[] list = new int[casenumber];
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] user_input;
		while(true) {
			
			int length = sc.nextInt();
			if(length == 0){
				break;
			}
			user_input = new int[length];
			for (int i = 0; i < length; i++) {
				user_input[i] = sc.nextInt();
			}
			list.add(Main.getdA(user_input));
		}
		for (int m : list) {
			System.out.println(m);
		}

//		long end = System.currentTimeMillis();
//		long diff = end - begin;
//		System.out.println("time " + diff);
	}

}
