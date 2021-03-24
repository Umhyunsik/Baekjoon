package DP;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bak_1463_1 {
	
	static int N;
	static int min=Integer.MAX_VALUE;
	static int[]memo;
	static class Pair{
		int x;
		int count;
		
		public Pair(int x,int count) {
			this.x=x;
			this.count=count;
		}
		
	}
	public static void  bfs(int N) {
		Queue<Pair> q=new LinkedList<>();
		q.add(new Pair(N,0));
		
		
		while(!q.isEmpty()) {
			
			Pair temp=q.poll();
			
			if(memo[temp.x]<temp.count)continue;
			
			if(temp.x==1) {
				if(min>temp.count) {
					min=temp.count;
				}
				continue;
			}
			
			if(temp.x%3==0) {
				if(memo[temp.x/3]>temp.count+1) {
					memo[temp.x/3]=temp.count+1;
					q.add(new Pair(temp.x/3,temp.count+1));
				}
				
			}
			if(temp.x%2==0) {
				
				if(memo[temp.x/2]>temp.count+1) {
					memo[temp.x/2]=temp.count+1;
					q.add(new Pair(temp.x/2,temp.count+1));
				}
			
			}
			if(temp.x>1) {

				if(memo[temp.x-1]>temp.count+1) {
					memo[temp.x-1]=temp.count+1;
					q.add(new Pair(temp.x-1,temp.count+1));
				}
			
			}
			
			
			
			
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		N=sc.nextInt();
		memo=new int[N+1];
		Arrays.fill(memo, Integer.MAX_VALUE);
		//memo[1]=0;
		//dp[1]=0;
		bfs(N);
		//System.out.println(Arrays.toString(memo));
		System.out.println(min);
	}
	
	
}
