import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.management.Query;

public class Bak_2660 {
	static int N;
	static boolean[][] maps;
	static boolean  [] check;
	static int [] dist;
	static class Pair{
		
		int x;
		int count;
		public Pair(int x, int count) {
			super();
			this.x = x;
			this.count = count;
		}
	}
	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		
		maps=new boolean[N][N];
		while (true) {
			
			int a=sc.nextInt()-1;
			int b=sc.nextInt()-1;
			
			if(a==-2&&b==-2)break;
			maps[a][b]=true;
			maps[b][a]=true;
		}
		int save[]=new int[N];
		int ans=0;
		for(int i=0;i<N;i++) {
			int count=0;
			for(int j=0;j<N;j++) {
				if(maps[i][j])count+=1;
			}
			save[i]=count;
			if(ans<count)ans=count;
		}
		check=new boolean[N];
		int sum=0;
		dist=new int[N];
		//Arrays.fill(dist, Integer.MAX_VALUE);
		
		int min=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			//System.out.println(i+"번째");
			check=new boolean[N];
			dist[i]=(bfs(i));
			if(min>dist[i])min=dist[i];
		}
		int count=0;
		for(int i=0;i<N;i++) {
			if(dist[i]==min)++count;
		}
		System.out.println(min+" "+count);
		//System.out.println();
		
		for(int i=0;i<N;i++) {
			if(dist[i]==min) {
				System.out.print(i+1+" ");
			}
		}
		
//		System.out.println(N-ans+" "+sum);
//		for(int i=0;i<N;i++) {
//			if(check[i])System.out.print((i+1)+" ");
//		}
		
		
		
	}
	
	
	
	
	private static int bfs(int i) {
		// TODO Auto-generated method stub
		Queue<Pair> q= new LinkedList<>();
		int ans=0;
		q.add(new Pair(i,0));
		check[i]=true;
		while(!q.isEmpty()) {
			
			Pair temp=q.poll();
			if(temp.count>ans)ans=temp.count;
			for(int j=0;j<N;j++) {
				if(maps[temp.x][j]&&!check[j]) {
					q.add(new Pair(j,temp.count+1));
					check[j]=true;
				}
			}
			
		}
		return ans;
		
		
	}



//
//	private static int dfs(int i,int count) {
//		boolean flag=false;
//		check[i]=true;
//		System.out.println(i+"노드"+count);
//		 for(int j=0;j<N;j++) {
//			if(maps[i][j]&&!check[j]) {
//				return dfs(j,count+1);
//			}
//		}
//		return count;
//	
//		
//	}
}
