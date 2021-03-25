package DP;

import java.util.Scanner;

public class Bak_1149 {

	static int N;
	static int maps[][];
//
//	public static void dfs(int now,int color,int value) {
//		if(min<value)return;
//		if(now==N) {
//			if(min>value)min=value;
//			return;
//		}
//		
//		if(color==0) {
//		
//			dfs(now+1,1,value+maps[now][1]);
//			dfs(now+1,2,value+maps[now][2]);
//			
//		}
//		if(color==1) {
//			dfs(now+1,0,value+maps[now][0]);
//			dfs(now+1,2,value+maps[now][2]);
//			
//		}
//		if(color==2) {
//			dfs(now+1,0,value+maps[now][0]);
//			dfs(now+1,1,value+maps[now][1]);
//			
//		}
//		
//		
//	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		N=sc.nextInt();
		maps=new int[N][3];		
		for(int i=0;i<N;i++) {
			for(int j=0;j<3;j++) {
				maps[i][j]=sc.nextInt();
			}
		}
		int [][] dp=new int[N][3];
//		dfs(0,0,0);
//		dfs(0,1,0);
//		dfs(0,2,0);
//		
		dp[0][0]=maps[0][0];
		dp[0][1]=maps[0][1];
		dp[0][2]=maps[0][2];
		
		for(int i=1;i<N;i++) {
			
			dp[i][0]=Math.min(dp[i-1][1], dp[i-1][2])+maps[i][0];
			dp[i][1]=Math.min(dp[i-1][0], dp[i-1][2])+maps[i][1];
			dp[i][2]=Math.min(dp[i-1][1], dp[i-1][0])+maps[i][2];
			
		}
		int min=0;
		min=Math.min(dp[N-1][0],dp[N-1][1]);
		min=Math.min(min,dp[N-1][2]);
		
		
		System.out.println(min);
	}
}
