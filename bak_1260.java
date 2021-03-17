package firstProject;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bak_1260 {
	static boolean[] visited;
	static boolean[][] map;
	static int cnt;
	static int [] dfsarr;
	static int [] bfsarr;

	public static void Dfs(int start) {
		
		if(visited[start])return;
		visited[start]=true;
		dfsarr[cnt++]=start;
		for(int i=0;i<map[start].length;i++) {
			if(map[start][i]&&!visited[i])Dfs(i);
		}
		
	}
	
	public static void bfs(int start) {
		Queue<Integer> q= new LinkedList<>();
		int idx=0;
		q.add(start);
		
		while(!q.isEmpty()) {
			int now=q.poll();
			if(visited[now])continue;
			
			visited[now]=true;
			bfsarr[idx++]=now;
			for(int i=0;i<map[start].length;i++) {
				if(map[now][i]&&!visited[i])q.add(i);
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int V=sc.nextInt();
		visited=new boolean[N];
		map=new boolean[N][N];
		dfsarr=new int[N];
		bfsarr=new int[N];
		Arrays.fill(dfsarr, -1);
		Arrays.fill(bfsarr, -1);
		for(int i=0;i<M;i++) {
			int s=sc.nextInt();
			int e=sc.nextInt();
			s-=1;
			e-=1;
			map[s][e]=true;
			map[e][s]=true;
			
		}
		Dfs(V-1);
		for(int i=0;i<dfsarr.length;i++) {
			if(dfsarr[i]==-1)break;
			System.out.print(dfsarr[i]+1+" ");
		}
		System.out.println();
		
		visited=new boolean[N];
		bfs(V-1);
		for(int i=0;i<bfsarr.length;i++) {
			if(dfsarr[i]==-1)break;
			System.out.print(bfsarr[i]+1+" ");
		}
		
		
		
		
	}
}
