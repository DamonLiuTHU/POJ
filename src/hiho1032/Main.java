package hiho1032;

import java.util.Scanner;

public class Main {

	private static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 先从标准输入读取一个整数N（N<=30)，代表我给你的字符串的个数，然后接下来的就是我要给你的那N个字符串（字符串长度<=10^6)啦。
		 * 而你要告诉我你的答案的话，只要将你计算出的最长回文子串的长度按照我给你的顺序依次输出到标准输出就可以了！你看这就是一个例子。”
		 */
		
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		while(N>0){
			N--;
			String s = sc.next();
			System.out.println(getMaxLength(s));
		}
	}

	private static int getMaxLength(String string) {
		int MAX_LENGTH=0;
//		int MAX_RIGHT_EDGE_CENTER = 0; 
//		int MAX_RIGHT_EDGE = 0 ;
		for(int centerPos = 0;centerPos<string.length();centerPos++){
			
			for(int length = 0;length <=Math.min(string.length()-centerPos-1, centerPos);length++){
				String substring = string.substring(centerPos-length,centerPos+length+1);
				if(Main.isPlalindrome(substring)){
					MAX_LENGTH = 2*length+1 > MAX_LENGTH ? 2*length+1 : MAX_LENGTH;
//					int tmpRightEdge = centerPos + length; 
//					if(tmpRightEdge>MAX_RIGHT_EDGE){
//						MAX_RIGHT_EDGE = tmpRightEdge;
////						MAX_RIGHT_EDGE_CENTER = centerPos;
//					}
//					MAX_RIGHT_EDGE_CENTER = tmpRightEdge>MAX_RIGHT_EDGE_CENTER?tmpRightEdge:MAX_RIGHT_EDGE_CENTER;
				}
			}
		}
		return MAX_LENGTH;
	}

	private static boolean isPlalindrome(String substring) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(substring);
		String reversed = sb.reverse().toString();
		if(reversed.compareTo(substring)==0){
			return true;
		}
		return false;
	}

}
