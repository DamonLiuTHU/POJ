package q2479;

import java.util.ArrayList;
import java.util.Date;
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
		array[0] = input[0];
		array[length - 1] = getMax(length-1);
		re_array[length-1] = 0;
		re_array[0] = getRigthMax(0);
		for (int i = 1; i < length-1; i++) {
			array[i] = getMax(i);
			int index = length - 1 - i;
			re_array[index] = getRigthMax(index);
		}
		for (int i = 0; i < length - 1; i++) {
			if (array[i] + re_array[i + 1] > max) {
				max = array[i] + re_array[i + 1];;
			}
		}
//		result = max;
		return max;
	}

	private static int getRigthMax(int index) {
		index += 1;
		return Math.max(input[index] + re_array[index], input[index]);
	}

	private static int getMax(int index) {
		return Math.max(array[index - 1] + input[index], input[index]);
	}

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
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

		long end = System.currentTimeMillis();
		long diff = end - begin;
		System.out.println("time " + diff);
	}

}
