
package q1011;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Scanner;
//import java.util.Vector;
//
//public class Main {
//	
//	ArrayList<Integer> sticks;
//	int sum;
//	/*
//	 * @calculate the smallest possible original stick length given the input
//	 * sticks
//	 * 
//	 * @return the length
//	 */
//	public int getSmallestPossibleLength(ArrayList<Integer> i_sticks , int i_sum) {
//		this.sticks = i_sticks;
//		this.sum = i_sum;
//		assert(i_sticks.size() <= 64);
////		i_sticks.sort(new Comparator<Integer>() {
////
////			@Override
////			public int compare(Integer o1, Integer o2) {
////				// TODO Auto-generated method stub
////				return o2 - o1;
////			}
////		});
//		Collections.sort(i_sticks,new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return o2 - o1;
//			}
//			
//		});
//		// System.out.println(sticks.toString());
////		int MIN = sticks.get(0);
//		int MAX = i_sticks.get(0);
//		
//		
//		for (int length = MAX; length <= i_sum; length++) {
//			if(isLengthValid(length)){ // find the smallest length
//				return length;
//			}
//		}
//		return 0;
//	}
//	
//	
//	private boolean dfs(int restlength,ArrayList<Integer> left_sticks){
//		
//		
//		return false;
//	}
//	
//	private boolean isLengthValid(int length){
//
//		if(sum%length != 0){
//			//cannot divide the total stick length;
//			return false;
//		}
//		int cycletimes = sum/length;
//		@SuppressWarnings("unchecked")
//		ArrayList<Integer> sticks_copy = (ArrayList<Integer>) sticks.clone();//已经拍过序的棍子。
//		for(int i = 0 ; i < cycletimes ; i++){
//			int LENGTH = length;
////			for(Integer value : sticks){
////				if(LENGTH >= value){
////					LENGTH -= value;
////					sticks_copy.remove(value);
////				}else{
////					continue;
////				}
////			}
//			for(int j = 0 ; j < sticks_copy.size() ; j ++){
//				Integer value = sticks_copy.get(j);
//				if(LENGTH >= value){
//					LENGTH -= value;
//					sticks_copy.remove(j);
//					j--;
//				}else{
//					continue;
//				}
//			}
//			if(LENGTH != 0){
//				return false;
//			}
//			
//		}
//		if(!sticks_copy.isEmpty()){
//			return false;
//		}
//		return true;
//	}
//
//	public static void main(String[] args) {
//		Main m = new Main();
//		Scanner sc = new Scanner(System.in);
//		Vector<Integer> resultlist = new Vector<Integer>();
//		int stick_count;
//		do {
//			stick_count = sc.nextInt();
//			if (stick_count == 0) {
//				break;
//			}
//			// int[] stick_set = new int[stick_count];
//			ArrayList<Integer> stick_set = new ArrayList<Integer>(32);
//			int sum = 0;
//			for (int i = 0; i < stick_count; i++) {
//				// stick_set[0] = sc.nextInt();
//				int temp = sc.nextInt();
//				stick_set.add(temp);
//				sum += temp;
//			}
//			int result = m.getSmallestPossibleLength(stick_set,sum);
//			resultlist.add(result);
//		} while (stick_count != 0);
//
//		int counter = 0;
//		for (int a : resultlist) {
//			if(counter!=0){
//				System.out.println("");
//			}
//			System.out.print(a);
//			
//			counter ++;
//		}
//	}
//
//}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static boolean[] used; //哪些木棍已经被用过了。
	static int len;  //有多少个木棍
	static int[] s;  //所有木棍的长度
	static int sum;	 //木棍长度之和。
	static int max;	//最长那根木棍。
	static int parts;	//暂时存放，如果长度为max （改变过的）的木棍理论上可以分割sum，即能除尽，则会分为parts个不同的木棍。

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		while ((len = Integer.parseInt(read.readLine())) != 0) {
			s = new int[len];
			StringTokenizer take = new StringTokenizer(read.readLine());
			int index = 0;
			sum = 0;
			used = new boolean[len];
			while (take.hasMoreTokens()) {
				s[index] = Integer.parseInt(take.nextToken());
				sum += s[index++];
			}
			Arrays.sort(s);
			max = s[len - 1];
			for (; max <= sum; max++) {
				if (sum % max == 0) {
					parts = sum / max;
					if (search(0, len - 1, 0)) {
						System.out.println(max);
						break;
					}
				}
			}
		}
	}

	public static boolean search(int res, int next, int cpl) {
		if (res == max) {
			res = 0;
			next = len - 2;
			cpl++;
		}
		if (cpl == parts) {
			return true;
		}
		while (next >= 0) {
			if (used[next] == false) {
				if (res + s[next] <= max) {
					used[next] = true;
					if (search(res + s[next], next - 1, cpl)) {
						return true;
					}
					used[next] = false;
					if (res == 0) {
						break;
					}
					if (res + s[next] == max) {
						break;
					}
				}
				int i = next - 1;
				while (i >= 0 && s[i] == s[next]) {
					i--;
				}
				next = i;
				int l_s = 0;
				for (int j = next; j >= 0; j--) {
					if (!used[j]) {
						l_s += s[j];
					}
				}
				if (l_s < max - res) {
					break;
				}
				continue;
			}
			next--;
		}
		return false;
	}
}
