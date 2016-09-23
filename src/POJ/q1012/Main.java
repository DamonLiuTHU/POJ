package POJ.q1012;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	/*
	 * the Joseph question.使用循环链表。
	 */
	LinkedList<Integer> list;
	int k;

	public int getMinInterval(int k) {
		assert(k>0 && k <14);
		this.k = k;
		list = new LinkedList<Integer>();
		int temp = 2*k;
		for (int i = 0; i < temp; i++) {
			list.add(0);
		}
		for (int interval = k + 1; interval < Integer.MAX_VALUE; interval++) {
			if (isIntervalValid(interval)) {
				return interval;
			}
		}
		return 0;
	}

	/*
	 * 走k次删除流程，若期间删除到了index < k的，则失败。
	 */
	@SuppressWarnings("unchecked")
	private boolean isIntervalValid(int interval) {
		int anchor = 0; // index 0 ,the first element in the list
		int tobedeleted = 0;
		LinkedList<Integer> templist = (LinkedList<Integer>) list.clone();
		for (int i = 0; i < k; i++) {
			tobedeleted = anchor + interval - 1;
			int listsize = templist.size();
			tobedeleted = tobedeleted%listsize;
			if(tobedeleted < k){
				return false;
			}
			templist.remove(tobedeleted);
			anchor = tobedeleted;
		}
		return true;
	}
//	static int Joseph[]={0,2,7,5,30,169,441,1872,7632,1740,93313,459901,1358657,2504881,1245064};
	static int Joseph[] = new int[14];
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vector<Integer> result = new Vector<Integer>();
		while (true) {
			int k = sc.nextInt(); // k is the number of good guys and bad
									// guys,so total number is 2*k
//			assertTrue(k>0&&k<14,"NUMBER ERROR");
//			assert(k<14);
			if(k>=14){
				continue;
			}
			if (k == 0) {
				break;
			} else {
				if(Joseph[k]!=0){
					System.out.println(Joseph[k]);
					continue;
				}
				int value = new Main().getMinInterval(k);
				System.out.println(value);
				Joseph[k] = value;
//				result.addElement(value);
			}
		}
		for (Integer temp : result) {
			System.out.println(temp);
		}
	}

}
