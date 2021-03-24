package firstProject;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bak_2636 {
	static int[][] maps;
	static int[][] outer;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int bfs() {
		
		Queue<Pair> q= new LinkedList<>();
		q.add(new Pair(0,0) );
		int count=0;
		while(!q.isEmpty()) {
			
			Pair temp=q.poll();
			//System.out.println(temp.x+" "+temp.y);
			if(visited[temp.x][temp.y])continue;
			visited[temp.x][temp.y]=true;
			
			
			
			
			for(int i=0;i<dx.length;i++) {
				int nx=temp.x+dx[i];
				int ny=temp.y+dy[i];
				if(nx<0||nx>=maps.length||ny<0||ny>=maps[0].length) {
					continue;
				}
				if(maps[nx][ny]==0&&!visited[nx][ny]) {
					
					q.add(new Pair(nx,ny));
				}
				if(maps[nx][ny]==1) {
					//System.out.println("옆에있음 ");
					if(outer[nx][ny]!=2) {
						count+=1;
						outer[nx][ny]=2;
					}
					
				
					
				}
					
			}
			
			
			
		}
		return count;
		
		
	}
	public static void erase() {
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[0].length; j++) {
				if(outer[i][j]==2)maps[i][j]=0;
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		maps = new int[N][M];
		

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				maps[i][j] = sc.nextInt();
			}
		}
		int temp = 1;
		int count=-1;
		int save=0;
		while (temp != 0) {
			outer = new int[N][M];
			visited = new boolean[N][M];
			temp = bfs();
			if(temp!=0)save=temp;
			//System.out.println(temp);
			erase();
			count+=1;
		}
		System.out.println(count);
		System.out.println(save);
		

	}
}
