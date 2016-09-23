package hihocode.hiho1135;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		int[] xyz = { x, y, z };
		int[] diffs = { 0, 0, 0 };
		Arrays.sort(xyz);
		String s = sc.next();
		int Cr = 0, Cy = 0, Cb = 0;
		int length = 0;
		int Max_length = 0;
//		int last_vanish_length = 0;
		for (char c : s.toCharArray()) {
			length++;
			if(length>Max_length){
				Max_length = length;
			}
			switch (c) {
			case 'R':
				Cr++;
				break;
			case 'Y':
				Cy++;
				break;
			case 'B':
				Cb++;
				break;
			default:
				break;
			}
			diffs[0] = Math.abs(Cr - Cy);
			diffs[1] = Math.abs(Cr - Cb);
			diffs[2] = Math.abs(Cb - Cy);
			Arrays.sort(diffs);
			boolean vanish = true;
			for (int i = 0; i < 3; i++) {
				if (xyz[i] - diffs[i] != 0) {
					vanish = false;
					break;
				}
			}
			if (vanish) {
//				last_vanish_length = length;
				Cr = 0;
				Cb = 0;
				Cy = 0;
				length = 0;
			}
		}
		System.out.println(Max_length);

	}

}
