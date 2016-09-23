package hihocode.hiho1044;

import java.util.Scanner;

public class Main {
	
	private static Scanner in;

//	private static int getLength(int i){
//		return (i+"").length();
//	}
//	private static int getCrossSum(int i){
//		String i_s = i+"";
//		int length = i_s.length();
//		int sum=0;
//		int offset = '0';
//		for(int tmp=0;tmp<length;tmp++){
//			char c = i_s.charAt(tmp);
//			int intvalue = c-offset;
//			sum+= (((tmp%2==0)?(+1):(-1))*intvalue);
//		}
//		return sum;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		in = new Scanner(System.in);
		while (in.hasNext()) {
			int l = in.nextInt();
//			int r = in.nextInt();
			int x = in.nextInt();
//			System.out.println(getCrossSum(l));
//			int begin_value = getCrossSum(l);
			for(int i=0;i<=x-l;i++){
//				int length = getLength(i);
				
			}
		}

	}

}
