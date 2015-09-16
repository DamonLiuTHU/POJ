package hiho1014;

//import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static Scanner sc;

	class Node
	{
		char value;
		public Node son = null;
		public Node next = null;
		int count = 1;
		public boolean isRoot = false;
		public Node(char value){
			this.value = value;
		}
		
		public Node(){
			this.isRoot = true;
		}
		
		public int match(Node root,String query){
			
//			for(char c:query.toCharArray()){
//				if(isRoot){// make it sure that you can only call this method from root
//					
//				}
//			}
//			Node pointer = null;
//			if(root.isRoot){
//				pointer = root.son;
//			}else{
//				pointer = root;
//			}
			Node son = root.getSon(query.charAt(0));
			if(son == null){
				return 0;
			}
			if(query.length()==1 && son!=null){
				return son.count;
			}
			
			if(query.length()>=2 && son!=null){
				return match(son,query.substring(1));
			}
			
			return 0;
		}
		
		public Node addSon(char tmp){
			if(son == null){
				son = new Node(tmp);
				return son;
			}else{
				return son.addSiblin(tmp);
			}
		}
		
		public Node addSiblin(char tmp){
			if(next == null){
				next = new Node(tmp);
				return next;
			}else{
				return next.addSiblin(tmp);
			}
		}
		public Node hasSon(char tmp){
			if(son==null){
				return null;
			}
			if(son!=null&&son.value==tmp){
				son.count++;
				return son;
			}
			Node current = son.next;
			if(current==null){
				return null;
			}
			boolean result = current.value==tmp;
			while(current!=null && current.value!=tmp){
				current = current.next;
			}
			
			if(current==null){
				return null;
			}
			result = current.value==tmp;
			
			if(result){
				current.count++;
			}
			
			return current;
		}
		
		
		public Node getSon(char tmp){
			if(son==null){
				return null;
			}
			if(son!=null&&son.value==tmp){
//				son.count++;
				return son;
			}
			Node current = son.next;
			if(current==null){
				return null;
			}
//			boolean result = current.value==tmp;
			while(current!=null && current.value!=tmp){
				current = current.next;
			}
			
			if(current == null){
				return null;
			}
//			result = current.value==tmp;
			return current;
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		String first = sc.next();
		Main main = new Main();
		final Node root = main.new Node();
		Node current = root;
		for(char temp : first.toCharArray()){
			current.addSon(temp);
			current = current.son;
		}
//		ArrayList<String> input = new ArrayList<String>(n);
		for(int i=1;i<n;i++){
			String tmp = sc.next();
			current = root;
			for(char c : tmp.toCharArray()){
				Node pointer = current.hasSon(c);
				if(pointer==null){
					Node new_son = current.addSon(c);
					current = new_son;
				}else{
					current = pointer;
				}
			}
//			input.add(tmp);
		}
		int m = sc.nextInt();
//		ArrayList<String> query = new ArrayList<String>(m);
		for(int i=0;i<m;i++){
			String query_item = sc.next();
			System.out.println(root.match(root,query_item));
//			query.add(query_item);
		}
		
	}

}
