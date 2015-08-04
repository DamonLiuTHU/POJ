package hiho1066;

import java.util.HashMap;
import java.util.Scanner;
/*
 * 并查集的使用。
 */

public class Main {

	static HashMap<String, String> info = new HashMap<String, String>();

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int tag = sc.nextInt();
			String name1 = sc.next();
			String name2 = sc.next();
//			switch (tag) {
//			case 0:
			if(tag==0){
				boolean havename1 = info.containsKey(name1);
				boolean havename2 = info.containsKey(name2);
				if (havename1 && havename2) {
					info.put(find(name2), find(name1));
					continue;
//					break;
				}
				if (havename1) {
					info.put(name2, find(name1));
//					break;
					continue;
				}
				if (havename2) {
					info.put(name1, find(name2));
					continue;
//					break;
				}
				info.put(name1, name1);
				info.put(name2, name1);
//				break;
			}
//			case 1:
			else{
				if (find(name1).compareTo(find(name2)) != 0) {
					System.out.println("no");
				} else {
					System.out.println("yes");
				}
//				break;
//			default:
//				System.exit(0);
//				break;
			}
		}
	}
	/*
	 * 100 0 A B 0 C D 0 E F 0 A C 0 D F 1 B E
	 */

	private static String find(String name1) {
		if(name1 == null){
			System.exit(0);
		}
		if (info.get(name1).compareTo(name1) == 0) {
			return name1;
		} else {
			String represeter = find(info.get(name1));
			info.put(name1, represeter);
			return represeter;
		}
	}

}
