package POJ.q1009;

import java.util.Scanner;
import java.util.Vector;

public class Main {

	private static Scanner sc;
	static int[][] CACHE;
	static int DIMENSION;
	static Vector<Integer> Map;
	static int WIDTH;
	static int HEIGHT;

	public static void initTable() {
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				CACHE[i][j] = -1;
			}
		}
	}

	public static boolean valid(int index,int x_diff , int y_diff) {
		int row = index / WIDTH;
		int colom = index % WIDTH;
		
		return row + y_diff >= 0 && row + y_diff < HEIGHT && colom + x_diff	>=0 && colom + x_diff < WIDTH	;
	}

	public static int getMaxDiff(int i) {
		// 1 check if the table has already got the value;
		// 2 calculate
		int MAX = -1;
		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 1; y ++) {
				int index = i + x + y*WIDTH;
				if (valid(i,x,y)) {
					// calculate the diff
					int cache = CACHE[index][i];
					if (cache != -1) {
						// already calculated
						if(cache > MAX){
							MAX = cache;
						}
					} else {
						// calculate and set cache
						int diff = Math.abs(Map.get(index) - Map.get(i));
						CACHE[index][i] = diff;
						CACHE[i][index] = diff;
						if(diff > MAX){
							MAX = diff;
						}
					}
				}
			}
		}
		return MAX;
	}

	public static Vector<Integer> getResult(Vector<Integer> temp, int width) {
		
		Map = temp;
		DIMENSION = Map.size();
		WIDTH = width;
		HEIGHT = DIMENSION / WIDTH;
		CACHE = new int[DIMENSION][DIMENSION];
		

		Vector<Integer> result = new Vector<Integer>();
		initTable();
		for (int index = 0; index < Map.size(); index++) {
			int max = getMaxDiff(index);
			result.add(max);
		}
		return result;
	}

	public static void print(Vector<Integer> input) {
		// begin from index 1
		// end with "0 0"
		int width = input.get(0);
		System.out.println(width);
		input.remove(0);
		int last_print = -1;
		int counter = 0;
		for (int temp : input) {
			if (last_print == -1) {
				last_print = temp;
				counter = 1;
				continue;
			}

			if (last_print == temp) {
				counter++;
			} else {
				System.out.println(last_print + " " + counter);
				counter = 1;
				last_print = temp;
			}
		}
		System.out.println(last_print + " "+counter);
		System.out.println("0 0");
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		Vector<Vector<Integer>> result = new Vector<Vector<Integer>>();
		while (true) {

			int width = sc.nextInt();
			if (width == 0) {
				break;
			}
			Vector<Integer> input = new Vector<Integer>();
//			int INPUT_COUNT = 0;
			while (true) {
				int value = sc.nextInt();
				int number = sc.nextInt();
				if (value == 0 && number == 0) {
					break;
				}
				for (int i = 0; i < number; i++) {
					input.addElement(value);
				}
			}

			input = Main.getResult(input, width);
			input.add(0, width);
			result.add(input);

		}

		for (Vector<Integer> temp : result) {
			print(temp);
		}
	}

}
