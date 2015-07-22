package q1011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	ArrayList<Integer> sticks;
	int sum;
	/*
	 * @calculate the smallest possible original stick length given the input
	 * sticks
	 * 
	 * @return the length
	 */
	public int getSmallestPossibleLength(ArrayList<Integer> i_sticks , int i_sum) {
		this.sticks = i_sticks;
		this.sum = i_sum;
		assert(i_sticks.size() <= 64);
//		i_sticks.sort(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return o2 - o1;
//			}
//		});
		Collections.sort(i_sticks,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
			
		});
		// System.out.println(sticks.toString());
//		int MIN = sticks.get(0);
		int MAX = i_sticks.get(0);
		
		
		for (int length = MAX; length <= i_sum; length++) {
			if(isLengthValid(length)){ // find the smallest length
				return length;
			}
		}
		return 0;
	}
	
	private boolean isLengthValid(int length){

		if(sum%length != 0){
			//cannot divide the total stick length;
			return false;
		}
		int cycletimes = sum/length;
		ArrayList<Integer> sticks_copy = (ArrayList<Integer>) sticks.clone();
		for(int i = 0 ; i < cycletimes ; i++){
			int LENGTH = length;
//			for(Integer value : sticks){
//				if(LENGTH >= value){
//					LENGTH -= value;
//					sticks_copy.remove(value);
//				}else{
//					continue;
//				}
//			}
			for(int j = 0 ; j < sticks_copy.size() ; j ++){
				Integer value = sticks_copy.get(j);
				if(LENGTH >= value){
					LENGTH -= value;
					sticks_copy.remove(j);
					j--;
				}else{
					continue;
				}
			}
			if(LENGTH != 0){
				return false;
			}
			
		}
		if(!sticks_copy.isEmpty()){
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Main m = new Main();
		Scanner sc = new Scanner(System.in);
		Vector<Integer> resultlist = new Vector<Integer>();
		int stick_count;
		do {
			stick_count = sc.nextInt();
			if (stick_count == 0) {
				break;
			}
			// int[] stick_set = new int[stick_count];
			ArrayList<Integer> stick_set = new ArrayList<Integer>(32);
			int sum = 0;
			for (int i = 0; i < stick_count; i++) {
				// stick_set[0] = sc.nextInt();
				int temp = sc.nextInt();
				stick_set.add(temp);
				sum += temp;
			}
			int result = m.getSmallestPossibleLength(stick_set,sum);
			resultlist.add(result);
		} while (stick_count != 0);

		for (int a : resultlist) {
			System.out.println(a);
		}
	}

}
