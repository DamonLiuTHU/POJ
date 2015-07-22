package q1008;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

/*
 * Maya Calendar
 */
public class Main {
	/*
	 *  pop, no, zip, zotz, tzec, xul, yoxkin, mol, chen, yax, zac, ceh, mac, kankin, muan, pax, koyab, cumhu.
	 */
	
	Map<String,Integer> m = new HashMap<String,Integer>();
	String[] religionDayNames = {"imix", "ik", "akbal", "kan", "chicchan", "cimi", "manik", "lamat", "muluk", "ok", "chuen", "eb", "ben", "ix", "mem", "cib", "caban", "eznab", "canac", "ahau"};
	
	public Main(){
		String[] monthNames = {"pop","no", "zip", "zotz", "tzec", "xul", "yoxkin", "mol", "chen", "yax", "zac", "ceh", "mac", "kankin", "muan", "pax", "koyab", "cumhu"};
		for(int i = 0 ; i < 18;i++){
			m.put(monthNames[i],i*20);
		}
		m.put("uayet", 360);
	}
	
	public int getDayofTheYear(String input){
		String[] temp = input.split(" ");
		String day = temp[0].replace(".", "");
		int day_int = Integer.parseInt(day)+1;
		String monthName = temp[1].trim(); 
		day_int+= m.get(monthName);
		day_int+= Integer.parseInt(temp[2])*365;
		return day_int;
	}
	public String transfer(String input){
		int day = getDayofTheYear(input);
		int year = day/260;
		int temp = day%260;
		int number =  temp%13;
		if(number == 0){
			number = 13;
		}
		String day_name = religionDayNames[day%20-1];
		StringBuilder sb = new StringBuilder(number+" "+day_name+" "+year);
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Main m = new Main();
		int input_number = Integer.parseInt(sc.nextLine());
		Vector<String>  output = new Vector<String>();
		while(input_number >0){
			input_number--;
			String input = sc.nextLine();
			String result = m.transfer(input);
			output.add(result);
		}
		System.out.println(output.size());
		for(String temp:output){
			System.out.println(temp);
		}
	}

}
