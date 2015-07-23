package q2479;

import java.util.Scanner;

public class Main {
	static int[] input;
	static int[] array;
	static int[] re_array;
	static int length;
	static int max = Integer.MIN_VALUE;
//	public static int result;
	

	public static int getdA(int[] i_input) {
		input = i_input;
		array = new int[input.length];
		re_array = new int[input.length];
		length = input.length;
		max = 0;
		if(length == 1){
			return input[0];
		}
		array[0] = input[0];
		re_array[length-1] = input[length-1];
		for (int i = 1; i < length-1; i++) {
			array[i] = getLeftMax(i);
			int index = length - 1 - i;
			re_array[index] = getRigthMax(index);
		}
		array[length - 1] = getLeftMax(length-1);
		re_array[0] = getRigthMax(0);
		for (int i = 0; i < length - 1; i++) {
			int temp =array[i] + getMaxValueFromIndex(i+1); 
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
			if(re_array[i]>max){
				max = re_array[i];
			}
		}
		return max;
	}

	private static int getRigthMax(int index) {
//		index += 1;
		return Math.max(input[index] + re_array[index+1], input[index]);
	}

	private static int getLeftMax(int index) {
		return Math.max(array[index - 1] + input[index], input[index]);
	}

	public static void main(String[] args) {
//		long begin = System.currentTimeMillis();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int casenumber = sc.nextInt();
		int[] list = new int[casenumber];
		int[] user_input;
		for (int tmp = 0; tmp < casenumber; tmp++) {
			int length = sc.nextInt();
			user_input = new int[length];
			for (int i = 0; i < length; i++) {
				user_input[i] = sc.nextInt();
			}
			list[tmp] = Main.getdA(user_input);
		}
		for (int m : list) {
			System.out.println(m);
		}

//		long end = System.currentTimeMillis();
//		long diff = end - begin;
//		System.out.println("time " + diff);
	}

}
