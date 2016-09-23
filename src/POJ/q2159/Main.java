package POJ.q2159;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static boolean isMatched(String coded,String orig){
		for(int offset = 1;offset <= 30; offset++){
			orig = subWithOffset(offset, orig);
			if(isNotOrderedMatched(orig, coded)){
				return true;
			}
		}
		return false;
	}
	
	
	private static String subWithOffset(int offset,String origs){
		StringBuilder sb = new StringBuilder();
		for(char temp : origs.toCharArray()){
			temp++;
			if(temp > 'Z'){
				temp -= 26;
			}
			sb.append(temp);
		}
		return sb.toString();
	}
	
	private static boolean isNotOrderedMatched(String s1,String s2){
		s1 = getOrdered(s1);
		s2 = getOrdered(s2);
		if(s1.compareToIgnoreCase(s2)==0){
			return true;
		}
		return false;
	}
	private static String getOrdered(String s){
		char[] temp = s.toCharArray();
		Arrays.sort(temp);
		s = new String(temp);
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String encrypedcode = sc.nextLine();
		String originalcode = sc.nextLine();
		boolean temp = Main.isMatched(encrypedcode, originalcode);
		System.out.print(temp?"YES":"NO");
	}

}
