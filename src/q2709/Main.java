package q2709;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	static int[] numbers;
	static int gray;
	static int MAX_INDEX;
	static Vector<Integer> result = new Vector<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int N = sc.nextInt();
			if (N == 0) {
				break;
			}
			numbers = new int[N];
			MAX_INDEX = 0;
			for (int i = 0; i < N; i++) {
				numbers[i] = sc.nextInt();
				if (numbers[i] > numbers[MAX_INDEX]) {
					MAX_INDEX = i;
				}
			}
			gray = sc.nextInt();
			int bottlesNeeded = numbers[MAX_INDEX] / 50;
			int left = numbers[MAX_INDEX] % 50;
			if (left > 0) {
				bottlesNeeded++;
			}
			int numberOfPaintsForEachColor = bottlesNeeded * 50;
			for (int i = 0; i < N; i++) {
				numbers[i] = numberOfPaintsForEachColor - numbers[i];
			}

			boolean tag = false;
			while (true) {
				if(gray<=0){
					break;
				}
				Arrays.sort(numbers);
				for (int i = N - 1; i >= N - 3; i--) {
					numbers[i]--;
					if (numbers[i] < 0) {
						tag = true;
						break;
					}
				}
				if (!tag) {
					gray--;
				} else {
					break;
				}
			}
			// System.out.println(bottlesNeeded);
			bottlesNeeded += gray*3/(N*50)+1;
			if(gray%50==0){
				bottlesNeeded--;
			}
			result.add(bottlesNeeded);
		}
		for (int tmp : result) {
			System.out.println(tmp);
		}
	}

}
