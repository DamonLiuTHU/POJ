package q1013;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	enum state {
		up, down, even;
	}

	String[][] info;
	String result;
	HashMap<Character, Integer> list = new HashMap<Character, Integer>();

	public Main(String[][] single_case) {
		for (char i = 'A'; i < 'M'; i++)
			list.put(i, 0);
		info = single_case;
	}
	
	
	private void increaseBadDegree(char temp){
		list.put(temp, list.get(temp)+1);
	}
	
	private void removeBadDegree(char temp){
		list.put(temp, Integer.MIN_VALUE);
	}

	private void calculate() {
		// get the result.
		// ArrayList<Character> badcoins = new ArrayList<Character>();
		for (String[] item : info) {
			if (item[2].compareToIgnoreCase("even") == 0) {
				for (char temp : item[0].toCharArray()) {
//					list.replace(temp, list.get(temp)+1);
					removeBadDegree(temp);
				}
				for (char temp : item[1].toCharArray()) {
//					list.replace(temp, list.get(temp)+1);
					removeBadDegree(temp);
				}
				continue;
			}
			if (item[2].compareToIgnoreCase("up") == 0) {
				for (char temp : item[0].toCharArray()) {
//					list.replace(temp, list.get(temp)+1);
					increaseBadDegree(temp);
				}
				for (char temp : item[1].toCharArray()) {
//					list.replace(temp, list.get(temp)+1);
					increaseBadDegree(temp);
				}
				continue;
			}
			if (item[2].compareToIgnoreCase("down") == 0) {
				for (char temp : item[0].toCharArray()) {
//					list.replace(temp, list.get(temp)+1);
					increaseBadDegree(temp);
				}
				for (char temp : item[1].toCharArray()) {
//					list.replace(temp, list.get(temp)+1);
					increaseBadDegree(temp);
				}
				continue;
			}

		}

	}

	public String getResult() {
		calculate();
		StringBuilder sb = null ;
		int max = -1;
		for(Integer temp : list.values()){
			if(temp > max){
				max =temp;
			}
		}
		char bad = 'Z';
		for(char temp : list.keySet()){
			if(list.get(temp) == max){
				sb = new StringBuilder(temp+" is the counterfeit coin and it is ");
				result = sb.toString();
				bad = temp;
			}
		}
		String weight;
		
		
		for(int i = 0 ; i< 3 ;i++){
			String[] a = info[i];
			String left = a[0];
			String right = a[1];
			if(contains(left, bad)){
				boolean isUp = (a[2].compareToIgnoreCase("up") == 0);
//				isUp?(weight="heavy"):(weight="light");
				if(isUp){
					weight = "heavy.";
				}else{
					weight = "light.";
				}
				return sb.append(weight).toString();
			}else if(contains(right,bad)){
				boolean isUp = (a[2].compareToIgnoreCase("up") == 0);
//				isUp?(weight="heavy"):(weight="light");
				if(!isUp){
					weight = "heavy.";
				}else{
					weight = "light.";
				}
				return sb.append(weight).toString();

			}else{
				continue;
			}
			
		}
		
		return result;
	}
	
	private boolean contains(String s,char c){
		for(char temp : s.toCharArray()){
			if(temp == c){
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
		for (int i = 0; i < cases; i++) {
			String[][] one_case = new String[3][3];
			for (int j = 0; j < 3; j++) {
				String left = sc.next();
				String right = sc.next();
				String state = sc.next();
				String[] temp = { left, right, state };
				one_case[j] = temp;
			}
			Main m = new Main(one_case);
			// String temp = m.getResult();
			case_result[i] = m;
		}

		for (Main temp : case_result) {
			System.out.println(temp.getResult());
		}
	}

}
