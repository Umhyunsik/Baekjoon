package DP;

import java.util.Arrays;
import java.util.Scanner;

public class Bak_1463 {
	static int N;
	static int[]dp;
	public static int  dfs(int N) {
		if(N==1) {
			return 0;
			
		}
		if(dp[N]!=0) {
			return dp[N];
		}
		int temp=Integer.MAX_VALUE;
		
		if(N%3==0) {
			temp=Math.min(temp,dfs(N/3)+1);
		}
		if(N%2==0) {
			temp=Math.min(temp,dfs(N/2)+1);
		}
		if(N>1) {
			temp=Math.min(temp,dfs(N-1)+1);
		}
		dp[N]=temp;
		return temp;
		
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		N=sc.nextInt();
		dp=new int[N+1];
		dp[1]=0;
		dfs(N);
		System.out.println(Arrays.toString(dp));
	}
	
	
}
