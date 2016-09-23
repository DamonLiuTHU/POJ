package POJ.q3299;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	private static double getE(float d) {
		return 6.11 * Math.exp(5417.7530 * ((1 / 273.16) - (1 / (d + 273.16))));
	}

	private static double getH(double e) {
		return (0.5555) * (e - 10.0);
	}

	public static double getT(Float d, Float H) {
		double e = getE(d);
		double h = getH(e);
		return H - h;
	}

	public static double getD(Float T, Float H) {
		double h = H - T;
		double e = h / 0.5555 + 10.0;
		double x = e / 6.11;
		x = Math.log(x);
		x = 5417.7530 * (1 / 273.16) - x;
		return 1 / x - 273.16;
	}

	public static double getH(Float T, Float D) {
		double e = getE(D);
		double h = getH(e);
		return T + h;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (true) {
			String v = sc.next();
			String v2 = sc.next();
			HashMap<String, Float> user_input = new HashMap<String, Float>(2);
			boolean isT = false, isD = false, isH = false;
			if (v.compareToIgnoreCase("t") == 0) {
				user_input.put("T", sc.nextFloat());
				isT = true;
			}
			if (v.compareToIgnoreCase("D") == 0) {
				user_input.put("D", sc.nextFloat());
				isD = true;
			}
			if (v.compareToIgnoreCase("h") == 0) {
				user_input.put("H", sc.nextFloat());
				isH = true;
			}
			if (v2.compareToIgnoreCase("t") == 0) {
				user_input.put("T", sc.nextFloat());
				isT = true;
			}
			if (v2.compareToIgnoreCase("D") == 0) {
				user_input.put("D", sc.nextFloat());
				isD = true;
			}
			if (v2.compareToIgnoreCase("h") == 0) {
				user_input.put("H", sc.nextFloat());
				isH = true;
			}
			if (isT && isD) {
				System.out.println(Main.getH(user_input.get("T"), user_input.get("D")));
				return;
			}

			if (isD && isH) {
				System.out.println(Main.getT(user_input.get("D"), user_input.get("H")));
				return;
			}

			if (isT && isH) {
				System.out.println(Main.getD(user_input.get("T"), user_input.get("H")));
				return;
			}
		}
	}

}
