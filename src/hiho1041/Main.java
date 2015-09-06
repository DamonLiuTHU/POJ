package hiho1041;

import java.util.Scanner;

public class Main {
	
	public class Node{
		public Node(int index){
			this.index = index;
		}
		public int index;
		public Node next;
		public Node son;
	}
	//深度优先搜索，可以对树进行左优先深度遍历，再进行右优先深度遍历。对于结果再做匹配。如果两个都不符合的话，则输出NO。
	//思路2：两个点之间的路径有且只有一条。  如果找到的路径中并不包含这个路径，
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int counter =0;counter<T;counter++){
			int n = sc.nextInt();//n is the number of cities;
			Node root = null;
			for(int i=1;i<n;i++){
				int start_p = sc.nextInt();
				int end_p = sc.nextInt();
				Node tmp;
				if((tmp = isTreeContainNode(root, start_p) )!= null){
					if(tmp.son==null){
//						tmp.son
					}
				}else{
					
				}
			}
		}
	}
	
	public static Node isTreeContainNode(Node root,int index){
//		if(root==null){
//			return false;
//		}
		if(root.index==index){
			return root;
		}
		
		if(root.next!=null){
			Node tmp = root.next; 
			while(tmp!=null){
				if(tmp.index == index){
					return tmp;
				}
				tmp = tmp.next;
			}
		}
		
		if(root.son!=null){
			return isTreeContainNode(root.son, index);
		}

		return null;
	}

}
