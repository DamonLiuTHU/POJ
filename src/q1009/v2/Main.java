package q1009.v2;

import java.awt.Dimension;
import java.util.Scanner;
import java.util.Vector;

import javax.naming.spi.DirectoryManager;

public class Main {
	
	
	class InnerContainer{
		private Vector<int[]> map;
		private int width;
		private int height;
		public InnerContainer(Vector<int[]> i_map,int width){
			map = i_map;
			this.width = width;
			this.height = i_map.size()/width;
		}
		
		public boolean isPositionValid(int index,int x_diff,int y_diff){
			int row = index / this.width;
			int colom = index % this.width;
			return row + y_diff >= 0 && row + y_diff < this.height && colom + x_diff	>=0 && colom + x_diff < this.height	;
		}
		
		public int getValue(int index){
			int counter = 0;
			while(true){
				int[] temp = this.map.elementAt(counter);
				int count = temp[1];
				if((index -= count) < 0){
					return temp[0];
				}else{
					counter++;
				}
			}
		}
	}

	private static Scanner sc;
	static int[][] CACHE;
	static int DIMENSION;
	
	public void initTable() {
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				CACHE[i][j] = -1;
				if(i == j ){
					CACHE[i][j] = 0;
				}
			}
		}
	}

	

//	public static int getMaxDiff(int old_index) {
//		// 1 check if the table has already got the value;
//		// 2 calculate
//		int MAX = -1;
//		for (int x = -1; x <= 1; x++) {
//			for (int y = -1; y <= 1; y ++) {
//				int index = old_index + x + y*WIDTH;
//				if (valid(old_index,x,y)) {
//					// calculate the diff
//					int cache = CACHE[index][old_index];
//					if (cache != -1) {
//						// already calculated
//						if(cache > MAX){
//							MAX = cache;
//						}
//					} else {
//						// calculate and set cache
//						int diff = Math.abs(getValue(index) - getValue(old_index));
//						CACHE[index][old_index] = diff;
//						CACHE[old_index][index] = diff;
//						if(diff > MAX){
//							MAX = diff;
//						}
//					}
//				}
//			}
//		}
//		return MAX;
//	}
	
	
	
	public Vector<Integer> getResult(Vector<int[]> temp, int width) {
		InnerContainer ic = new InnerContainer(temp, width);
		int temp_ic_height = ic.height;
		int counter = 0;
		Vector<int[]> tobeAdded = new Vector<>();
		for(int i =0 ; i< temp.size() ;i++){
			int[] input_item = temp.elementAt(i);
			
			if(input_item[1]/width >= 3){
//				if(temp.indexOf(input_item)==0 || temp.indexOf(input_item)==temp.size()-1){
//					//第一行或者最后一行。
//					
//				}else{
//					//中间
//				}
				int row_count = input_item[1]/width - 3;
				if(row_count == 0){
					continue;
				}
				int[] to_be_added = {counter/width +1 ,row_count*width};  //add it to result;
				tobeAdded.addElement(to_be_added);
				int[] new_temp_item = {input_item[0],input_item[1]-row_count*width};
				temp.setElementAt(new_temp_item, i);
			}
			counter += input_item[1];
		}
		
		
		
		DIMENSION = 0;
		for(int[] a:temp){
			int count = a[1];
			DIMENSION += count;
		}
		CACHE = new int[DIMENSION][DIMENSION];
		

		Vector<Integer> result = new Vector<Integer>();
		initTable();
		for (int index = 0; index < DIMENSION; index++) {
//			int max = getMaxDiff(index);
			int max = 0;
			result.add(max);
		}
		
		for(int[] tobeadded : tobeAdded){
			int row = tobeadded[0];   //the row to add zeros.
			int count = tobeadded[1]; //add how many zeros.
		}
		return result;
	}

	
	public static void main(String[] args) {
		Main m = new Main();
		sc = new Scanner(System.in);
		Vector<Vector<Integer>> result = new Vector<>();
		while (true) {

			int width = sc.nextInt();
			if (width == 0) {
				break;
			}
			Vector<Integer> input;
			Vector<int[]> userinput = new Vector<int[]>();
//			int INPUT_COUNT = 0;
			while (true) {
				int value = sc.nextInt();
				int count = sc.nextInt();
				if (value == 0 && count == 0) {
					break;
				}
				int[] temp = {value,count};
				userinput.add(temp);
			}

			input = m.getResult(userinput, width);
			input.add(0, width);
			result.add(input);

		}

		for (Vector<Integer> temp : result) {
//			Vector<int[]> a =  print(temp);
			
		}
	}

}
