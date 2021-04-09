package study6weeks;

import java.util.Arrays;
import java.util.Scanner;

public class bak_1937 {
	static int N;
	static int maps[][];
	static int visited[][];
	static int[] dx= {-1,0,1,0};
	static int[] dy= { 0,1,0,-1};
	static int dfs(int x ,int y) {
		//System.out.println(x+" "+y);
		if(visited[x][y]!=-1) {
			
			return visited[x][y];
			
		}
		boolean flag=false;
		for(int i=0;i<dx.length;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0||nx>=maps.length||ny<0||ny>=maps.length)continue;
			if(maps[x][y]>maps[nx][ny]) {
				visited[x][y]=Math.max(dfs(nx,ny)+1,visited[x][y]);
				flag=true;
			}
		}
		if(visited[x][y]==-1)visited[x][y]=0;
		return visited[x][y];
		
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc =new Scanner(System.in);
		N=sc.nextInt();
		maps=new int[N][N];
		visited=new int[N][N]; 
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				maps[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<N;i++) {
			Arrays.fill(visited[i],-1);
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]==-1) {
					dfs(i,j);
				}
			}
		}
		int answer=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(answer<visited[i][j]+1)answer=visited[i][j]+1;
			}
			
		}
		System.out.println(answer);
		
		
		
	}

}
