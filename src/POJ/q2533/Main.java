package POJ.q2533;

import java.util.Scanner;

public class Main {

	int[] numbers;
	int[] result;

	public int getLengthofMaxOrderedSequence(int[] numbers) {
		this.numbers = numbers;
		result = new int[numbers.length];
		int MAX = 1;
		for (int i = 0; i < numbers.length; i++) {
			result[i] = 1;
			if (i == 0) {
				continue;
			}
//			if (numbers[i] > numbers[i - 1]) {
				result[i] = Max(i) + 1;
				if (result[i] > MAX) {
					MAX = result[i];
				}
//			}
		}

		return MAX;
	}

	private int Max(int index) {
		// from 0 -- index both needed
		int MAX = 0;
		for (int i = 0; i < index; i++) {
			if (numbers[i] < numbers[index]) {
				if(result[i] > MAX){
					MAX = result[i];
				}
			}
		}
		return MAX;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] numbers = new int[length];
		for (int i = 0; i < length; i++) {
			numbers[i] = sc.nextInt();
		}
		Main m = new Main();
		System.out.print(m.getLengthofMaxOrderedSequence(numbers));  // this might be the reason why WA.
																	 // use print instead of println
//		for(int i = 0 ; i< length ;i++){
//			System.out.print(m.result[i]+" ");
//		}
	}

}
