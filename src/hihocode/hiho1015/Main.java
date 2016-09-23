package hihocode.hiho1015;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	/*
	 * KMP算法 http://kb.cnblogs.com/page/176818/
	 */

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for (int index = 0; index < cases; index++) {
			String pattern = sc.next();
			String origin_info = sc.next();
			int[] next = Main.getNext(pattern);
			if (!origin_info.contains(pattern)) {
				// return 0;
				System.out.println(0);
			} else {
				int n, m;
				int i, q;
				n = origin_info.length();
				m = pattern.length();
				int counter = 0;
				for (i = 0, q = 0; i < n; ++i) {
					while (q > 0 && q< m && pattern.charAt(q) != origin_info.charAt(i))
						q = next[q - 1];
					if (pattern.charAt(q) == origin_info.charAt(i)) {
						q++;
					}
					if (q == m) {
						q = 0;
//						System.out.println("Pattern occurs with shift:"+ (i - m + 1));
						counter++;
					}
				}
				System.out.println(counter);
			}
		}
	}

	public static int[] getNext(String pattern) {
		int[] result = new int[pattern.length()];
		for (int i = 0; i < pattern.length(); i++) {
			String tmp = pattern.substring(0, i + 1);
			if (tmp.length() == 1) {
				result[i] = 0;
				continue;
			}
			String[] prefix = new String[tmp.length() - 1];
			String[] suffix = new String[tmp.length() - 1];
			for (int j = 1; j < tmp.length(); j++) {
				prefix[j - 1] = tmp.substring(0, j);
				suffix[j - 1] = tmp.substring(tmp.length() - j);
			}
			//
			List<String> suffix_array = Arrays.asList(suffix);
			int MAX = 0;
			for (String s : prefix) {
				if (suffix_array.contains(s)) {
					if (s.length() > MAX) {
						MAX = s.length();
					}
				}
			}
			result[i] = MAX;
		}
		return result;
	}

}
