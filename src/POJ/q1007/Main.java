package POJ.q1007;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	public static int length = 0;
	
	public static int measure(String input){
		/*
		 * calculate the unsortedness of input String
		 */
		int result = 0;
		for(int i = 0; i< length ;i++){
			char temp = input.charAt(i);
			for(char next : input.substring(i+1).toCharArray()){
				if(temp > next){
					result++;
				}
			}
		}
		return  result;
	}
	
	
	public static void mysort(Vector<String> input){
		Collections.sort(input,new Comparator<String>() {

			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return measure(o1)-measure(o2);
			}
			
		});
//		return input;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		Main.length = length;
		int input_count = sc.nextInt();
		Vector<String> input_list = new Vector<String>();
		for(int i = 0 ; i< input_count;i++){
			String input = sc.next();
			input_list.add(input);
		}
//		TreeMap<String, Integer> result = Main.mysort(input_list);
		Main.mysort(input_list);
		for(String temp : input_list){
			System.out.println(temp);
		}
		
	}

}
