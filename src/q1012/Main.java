package q1012;

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

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vector<Integer> result = new Vector<Integer>();
		while (true) {
			int k = sc.nextInt(); // k is the number of good guys and bad
									// guys,so total number is 2*k
			if (k == 0) {
				break;
			} else {
				result.addElement(new Main().getMinInterval(k));
			}
		}
		for (Integer temp : result) {
			System.out.println(temp);
		}
	}

}
