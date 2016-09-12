package hiho1366.v2;
//import java.lang.reflect.Array;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.Scanner;

public class Main {

	private static Scanner sc;

	public static void main(String[] args) { //version 1.0 TLE
		sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			ArrayList<String> list = new ArrayList<String>(n);
			ArrayList<String> revertList = new ArrayList<String>(n);
			for (int i = 0; i < n; i++) {
				String tmp = sc.next();
				String revertTmp = revert(tmp);
				list.add(tmp);
				revertList.add(revertTmp);
			}
			int count = 0;
			int length = n;
			for (int i = 0 ; i<length ; i++) {
				String string = list.get(i);
				if (string == null)
				{
					continue;
				}
				String revertString = revert(string);
				int indexOfRevertString = list.indexOf(revertString);
				if (indexOfRevertString > 0) {
					count ++;
					list.set(i,null);
					list.set(indexOfRevertString, null);
				}
//				if (string.compareTo(revertString)==0) {
//					length --;
//					list.remove(string);
//				} else {
//					length -= 1;
////					list.remove(string);
//					list.remove(revertString);
//				}
			}
			System.out.println(count);
		}
	}
	
	public static String revert(String s){
		StringBuilder sb = new StringBuilder(s.length());
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(s.length()-i-1));
		}
		return sb.toString();
	}

}
