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
		// 找到最长回文串 version01 使用stack  //fail
//		Stack<Character> stack = new Stack<Character>();
//		for(int i=0;i<string.length()/2+1;i++){
//			char tmp = string.charAt(i);
//			if(stack.isEmpty()){
//				stack.push(tmp);
//			}else{
//				char top = stack.peek();
//				if(top!=)
//			}
//		}
		
		
		return MAX_LENGTH;
	}

}
