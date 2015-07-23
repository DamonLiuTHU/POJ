///**
// * 
// */
//package q1141;
//
//import java.util.Scanner;
//
///**
// * @author damonliu
// *
// */
//public class Main {
//	
//	//
////  main.c
////  POJ
////
////  Created by DamonLiu on 15/7/23.
////  Copyright (c) 2015年 DamonLiu. All rights reserved.
////
//
////#include <IOSurface/IOSurface.h>
////#include <cmath>
////using namespace std;
//	int maxn = 110;
//	char str[110];
//	int dp[maxn][maxn], path[maxn][maxn], len;
//
//
//
//
//
//static void output(int st, int ed)
//{
//    if(st > ed)
//        return;
//    else if(st == ed)
//    {
//        if(str[st] == '(' || str[ed] == ')')
//            printf("()");
//        else
//            printf("[]");
//    }
//    else if(path[st][ed] == -1)
//    {
//        printf("%c", str[st]);
//        output(st+1, ed - 1);
//        printf("%c", str[ed]);
//    }
//    else
//    {
//        output(st, path[st][ed]);
//        output(path[st][ed] + 1, ed);
//    }
//}
//
//
//
//	/**
//	 * @param args
//	 */
//		public static void main(String args[]) {
//		Scanner sc = new Scanner(System.in);
//		String input = sc.nextLine();
//		assert(input.length() <= 100);
//		System.out.println(Main.getPairedString(input));
//		// System.out.println((int)'['+" "+(int)']'+" "+(int)'('+" "+(int)')');
//		
//		
//		int main()
//		{
//		    
//		    memset(dp, 0, sizeof(dp));
//		    scanf("%s", str + 1);
//		    len = (int)strlen(str + 1);
//		    for(int i = 1; i <= len; i++)
//		        dp[i][i] = 1;
//		    for(int l = 2; l <= len; l++)
//		    {
//		        for(int i = 1; i <= len - l + 1; i++)
//		        {
//		            int j = i + l - 1;
//		            if((str[i] == '(' && str[j] == ')') || (str[i] == '[' && str[j] == ']'))
//		            {
//		                dp[i][j] = dp[i+1][j-1];
//		                path[i][j] = -1;
//		            }
//		            else
//		                dp[i][j] = 0x7fffffff;
//		            for(int k = i; k <= j - 1; k++)
//		            {
//		                if(dp[i][j] > dp[i][k] + dp[k+1][j])
//		                {
//		                    dp[i][j] = dp[i][k] + dp[k+1][j];
//		                    path[i][j] = k;
//		                }
//		            }
//		        }
//		    }
//		    output(1, len);
//		    printf("\n");
//		    
//		    return 0;
//	}
//
//}
