package hiho1370;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Boolean> list = new ArrayList<Boolean>();
		while(sc.hasNext()){
			String num = sc.nextLine();
			if (num.compareTo("-1")==0) {
				break;
			}
			while (true) {
				num = happyTransform(num);
				int number = Integer.parseInt(num);
				if (number < 10 && (number != 1&&number!=7)) {
					list.add(false);
					break;
				}
				if (num .compareTo("1")==0) {
					list.add(true);
					break;
				}
			}	
		}
		for (Boolean boolean1 : list) {
			System.out.println(boolean1);	
		}
	}
	
	public static String happyTransform(String num){
		int n = Integer.parseInt(num);
		int new_num = 0;
		while(n >0){
			int tmp = n %10;
			n = n / 10;
			new_num += tmp * tmp;
		}
//		System.out.println(new_num);
		return new_num + "";
	}
	
	
	/*
	 * 2
	 * 4
	16
	37
	58
	89
	145
	42
	20
	 * 
	*/
}
