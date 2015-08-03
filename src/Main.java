import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	static HashMap<String, Integer> months = new HashMap<String, Integer>();

	/*
	 * month为{"January", "February", "March", "April", "May", "June", "July",
	 * "August", "September", "October", "November" , "December"}中的一个字符串。
	 */
	static String[] months_array = {"January", "February", "March", "April", "May", "June", "July",
			 "August", "September", "October", "November" , "December"};
	public static void main(String args[]) {
//		months.put("January", 1);
		for(int i=0;i<months_array.length;i++){
			months.put(months_array[i], i+1);
		}
		Scanner sc = new Scanner(System.in);
//		int csnumber = Integer.parseInt(sc.nextLine());
		int csnumber = sc.nextInt();
		ArrayList<String> result = new ArrayList<String>(csnumber);
		for (int i = 0; i < csnumber; i++) {
//			String date01 = sc.nextLine().replace(",", "");
//			String date02 = sc.nextLine().replace(",", "");
//			String[] date01parts = date01.split(" ");
//			String[] date02parts = date02.split(" ");
//			int year01 =Integer.parseInt(date01parts[2]);
//			int year02 =  Integer.parseInt(date02parts[2]);
//			int month01 = months.get(date01parts[0]);
//			int month02 = months.get(date02parts[0]);
//			int day01 = Integer.parseInt(date01parts[1]);
//			int day02 = Integer.parseInt(date02parts[1]);
			String month_string = sc.next();
			int month01 =months.get(month_string);
			int day01 = Integer.parseInt(sc.next().replace(",", ""));
			int year01 = sc.nextInt();
			
			int month02 = months.get(sc.next());
//			int day02 = sc.nextInt();
			int day02 = Integer.parseInt(sc.next().replace(",", ""));
			int year02 = sc.nextInt();
			if(month01>2){
				year01++;
			}
			if(month02<2||month02==2&&day02<29){
				year02--;
			}
			int counter = 0;
			while(!isTrue(year01)){
				year01++;
			}
			while(!isTrue(year02)){
				year02--;
			}
//			for(int year=year01;year<=year02;year+=4){
//				if(year%400==0 || (year%100!=0&&year%4==0)){
////					year+=3;
//					counter++;
//				}
//			}
//			counter = (year02-year01)/4+year02==year01?1:2;
			counter = (year02-year01)/4+1;
			///考虑能被100整除，不能被400整除的情况。
			for(int j = year01/100;j<year02/100;j++){
				if(j%4!=0){
					counter--;
				}
			}
			if(counter<0){
				counter=0;
			}
//			StringBuilder sb = new StringBuilder("Case #"+(i+1)+": "+counter+"");
			System.out.print("Case #");System.out.print(i+1);System.out.print(": ");System.out.println(counter);
//			System.out.println(sb.toString());
//			result.add(sb.toString());
		}
		
//		for(String temp : result){
//			System.out.println(temp);
//		}

	}
	
	private static Vector<Integer> okyears = new Vector<Integer>();
	private static boolean isTrue(int year) {
		// TODO Auto-generated method stub
//		return false;
		/*
		 * . 年份能被4整除但不能被100整除

2. 年份能被400整除
		 */
		if(year%2!=0){
			return false;
		}
		
		return year%400==0 || (year%100!=0&&year%4==0);
		
		
	}
}