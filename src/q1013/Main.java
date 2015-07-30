package q1013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	/*
	 * 1) 平衡状态，所有参与称重的硬币都是真的； 
	 * 2) 非平衡状态，所有没有参与称重的硬币都是真的； 
	 * 3) 若有一枚硬币既出现在重的一边，又出现在轻的一边，则这枚硬币是真的； 经过以上3重筛选，剩下的硬币恰好1枚，否则答案不唯一。
	 */
	enum state {
		up, down, even;
	}

	String[][] info;
	String result;
	HashMap<Character, Integer> suspect_level = new HashMap<Character, Integer>();

	public Main(String[][] single_case) {
		for (char i = 'A'; i < 'M'; i++)
			suspect_level.put(i, 0);
		info = single_case;
	}

	private void increaseBadDegree(char temp) {
		suspect_level.put(temp, suspect_level.get(temp) + 1);
	}

	private void removeBadDegree(char temp) {
		suspect_level.put(temp, Integer.MIN_VALUE);
	}

	private void calculate() {
		// get the result.
		// ArrayList<Character> badcoins = new ArrayList<Character>();
		for (String[] item : info) {
			if (item[2].compareToIgnoreCase("even") == 0) {
				for (char temp : item[0].toCharArray()) {
					removeBadDegree(temp);
				}
				for (char temp : item[1].toCharArray()) {
					removeBadDegree(temp);
				}
				continue;
			}
			if (item[2].compareToIgnoreCase("up") == 0) {
				for (char temp : item[0].toCharArray()) {
					increaseBadDegree(temp);
				}
				for (char temp : item[1].toCharArray()) {
					increaseBadDegree(temp);
				}
				for (String[] tmp : info) {
					if (tmp != item) {
						for (char temp : tmp[0].toCharArray()) {
							// list.replace(temp, list.get(temp)+1);
							removeBadDegree(temp);
						}
						for (char temp : tmp[1].toCharArray()) {
							// list.replace(temp, list.get(temp)+1);
							removeBadDegree(temp);
						}
					}
				}

				continue;
			}
			if (item[2].compareToIgnoreCase("down") == 0) {
				for (char temp : item[0].toCharArray()) {
					// list.replace(temp, list.get(temp)+1);
					increaseBadDegree(temp);
				}
				for (char temp : item[1].toCharArray()) {
					// list.replace(temp, list.get(temp)+1);
					increaseBadDegree(temp);
				}
				for (String[] tmp : info) {
					if (tmp != item) {
						for (char temp : tmp[0].toCharArray()) {
							// list.replace(temp, list.get(temp)+1);
							removeBadDegree(temp);
						}
						for (char temp : tmp[1].toCharArray()) {
							// list.replace(temp, list.get(temp)+1);
							removeBadDegree(temp);
						}
					}
				}
				continue;
			}

		}

	}

	public String getResult() {
		calculate();
		StringBuilder sb = null;
		int max = -1;
		for (Integer temp : suspect_level.values()) {
			if (temp > max) {
				max = temp;
			}
		}
		char bad = 'Z';
		for (char temp : suspect_level.keySet()) {
			if (suspect_level.get(temp) == max) {
				sb = new StringBuilder(temp + " is the counterfeit coin and it is ");
				result = sb.toString();
				bad = temp;
			}
		}
		String weight;

		for (int i = 0; i < 3; i++) {
			String[] a = info[i];
			String left = a[0];
			String right = a[1];
			if (contains(left, bad)) {
				boolean isUp = (a[2].compareToIgnoreCase("up") == 0);
				// isUp?(weight="heavy"):(weight="light");
				if (isUp) {
					weight = "heavy.";
				} else {
					weight = "light.";
				}
				return sb.append(weight).toString();
			} else if (contains(right, bad)) {
				boolean isUp = (a[2].compareToIgnoreCase("up") == 0);
				// isUp?(weight="heavy"):(weight="light");
				if (!isUp) {
					weight = "heavy.";
				} else {
					weight = "light.";
				}
				return sb.append(weight).toString();

			} else {
				continue;
			}

		}

		return result;
	}

	private boolean contains(String s, char c) {
		for (char temp : s.toCharArray()) {
			if (temp == c) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		Main[] case_result = new Main[cases];
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < cases; i++) {
			TreeSet<Character> upCoins = new TreeSet<Character>();
			TreeSet<Character> downCoins = new TreeSet<Character>();
			TreeSet<Character> goodCoins = new TreeSet<Character>();
			String[][] one_case = new String[3][3];
			for (int j = 0; j < 3; j++) {
				String left = sc.next();
				String right = sc.next();
				String state = sc.next();
				String[] temp = { left, right, state };
				one_case[j] = temp;
				if(state.compareTo("even")==0){
					for(char tmp : left.toCharArray()){
						goodCoins.add(tmp);
					}
					for(char tmp : right.toCharArray()){
						goodCoins.add(tmp);
					}
				}
				
				if(state.compareTo("up")==0){
					for(char tmp : left.toCharArray()){
						downCoins.add(tmp);
					}
					for(char tmp : right.toCharArray()){
						upCoins.add(tmp);
					}
				}
				
				if(state.compareTo("down")==0){
					for(char tmp : left.toCharArray()){
						upCoins.add(tmp);
					}
					for(char tmp : right.toCharArray()){
						downCoins.add(tmp);
					}
				}
			}
			
//			Main m = new Main(one_case);
			// String temp = m.getResult();
//			case_result[i] = m;
			for(char tmp : upCoins){
				if(downCoins.contains(tmp)){
					downCoins.remove(tmp);
					goodCoins.add(tmp);
				}
			}
			
			
			for(char tmp : downCoins){
				if(upCoins.contains(tmp)){
					upCoins.remove(tmp);
					goodCoins.add(tmp);
				}
			}
			
			for(char tmp : goodCoins){
				if(upCoins.contains(tmp)){
					upCoins.remove(tmp);
				}
				if(downCoins.contains(tmp)){
					downCoins.remove(tmp);
				}
			}
			
			if(upCoins.isEmpty()&&!downCoins.isEmpty()){
//				System.out.println(downCoins.first() + " is the counterfeit coin and it is heavy.");
//				result.add
				result.add(downCoins.first() + " is the counterfeit coin and it is heavy.");
				continue;
			} 
			
			if(downCoins.isEmpty()&&!upCoins.isEmpty()){
//				System.out.println(upCoins.first()+" is the counterfeit coin and it is light.");
				result.add(upCoins.first()+" is the counterfeit coin and it is light.");
			}
		}

//		for (Main temp : case_result) {
//			System.out.println(temp.getResult());
//		}
		for(String temp : result){
			System.out.println(temp);
		}
	}

}
