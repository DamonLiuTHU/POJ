package POJ.q1015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	
	/*
	 * Best jury has value 6 for prosecution and value 4 for defence: 
 	 *	2 3 
	 */
	public int dp[][] = new int[21][801];   //dp[j][k]：取j个候选人，使其辩控差为k的所有方案中，辩控和最大的方案的辩控和  
	public int path[][]= new int[21][801];  //记录所选定的候选人的编号
	
//	public String[] deal(int[][] info,int n,int m){
////		int n;  //候选人数  
////		int m;  //当选人数  
//		
//		
//		
//		
//		
//		return null;
//	}
	
	boolean select(int j,int k,int i,int[] v)  
	{  
	    while(j>0 && path[j][k]!=i)  
	    {  
	        k-=v[ path[j][k] ];  
	        j--;  
	    }  
	    return j==0?false:true;  
	}  
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<String[]> result = new ArrayList<String[]>();
		while(true){
			int j,k,i;  
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n==m && n==0){
				break;
			}
//			int info[][] = new int[n][4];
			int p[] = new int[n+1];
			int d[] = new int[n+1];
			int s[] = new int[n+1];
			int v[] = new int[n+1];
			
			for(i = 1 ; i<= n;i++){
				int pi = sc.nextInt();
				int di = sc.nextInt();
				p[i] = pi;  //!important
				d[i] = di;  //!important
				
				int vi = di - pi;
				s[i] = vi;  //!important
				int si = di + pi;
				v[i] = si;  //!important
			}
//			String[] temp = new Main().deal(info, n, m);
//			result.add(temp);
			int fix=m*20;  //总修正值，修正极限为从[-400,400]映射到[0,800]
			/*DP*/  
			Main main = new Main();
	        main.dp[0][fix]=0;   //由于修正了数值，因此dp[0][fix]才是真正的dp[0][0]  
	        for(j=1;j<=m;j++)  
	            for(k=0;k<=2*fix;k++)  
	            {  
	                if(main.dp[j-1][k]>=0)   //区间已平移，dp[0][fix]才是真正的dp[0][0]  
	                {  
	                    for(i=1;i<=n;i++)  
	                        if(main.dp[j][ k+v[i] ] < main.dp[j-1][k]+s[i])  
	                        {  
	                            if(main.select(j-1,k,i,v))  
	                            {  
	                                main.dp[j][ k+v[i] ] = main.dp[j-1][k]+s[i];  
	                                main.path[j][ k+v[i] ] = i;  
	                            }  
	                        }  
	                }  
	            }  
	  
	  
	        /*Output*/  
	        
	        for(k=0;k<=fix;k++)  
	            if(main.dp[m][fix-k]>=0 || main.dp[m][fix+k]>=0)    //从中间向两边搜索最小辨控差的位置k  
	                break;  
	  
	        int div=main.dp[m][fix-k] > main.dp[m][fix+k] ? (fix-k):(fix+k);  //最小辨控差  
	        StringBuilder sb = new StringBuilder("Best jury has value ");
	        sb.append((main.dp[m][div]+div-fix)/2+" for prosecution and value "+(main.dp[m][div]-div+fix)/2+" for defence:");
	        String[] temp = new String[2];
	        temp[0] = sb.toString();
	        int[] id=new int[m];  
	        for(i=0,j=m,k=div;i<m;i++)  
	        {  
	            id[i]=main.path[j][k];  
	            k-=v[ id[i] ];  
	            j--;  
	        }  
//	        sort(id,id+m);   //升序输出候选人编号
	        Arrays.sort(id);
	        sb = new StringBuilder();
	        for(i=0;i<m;i++)  
	        	sb.append(' '+id[i]);
	        temp[1] = sb.toString();
	        result.add(temp);
		}
		int counter = 0;
		for(String[] a : result){
			counter++;
			System.out.println("Jury #"+counter);
			System.out.println(a[0]);
			System.out.println(a[1]);
			System.out.println();
		}
	}

}
