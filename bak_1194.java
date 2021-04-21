import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bak_1194 {

	static int N,M;
	static char maps[][];
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	static int ans;
	static boolean visited[][][];
	static class Node implements Comparable<Node>{
		
		int x,y;
		int count;
		int bitcount;
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.count-o.count;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", count=" + count + ", bitcount=" + bitcount + "]";
		}

		public Node(int x, int y, int count, int bitcount) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
			this.bitcount = bitcount;
		}
	

		
		
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		maps = new char[N][M];
		visited= new boolean[N][M][1<<8];
		PriorityQueue<Node> pq =new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			String temp=sc.next();
			for(int j=0;j<temp.length();j++) {
				maps[i][j]=temp.charAt(j);
				if(maps[i][j]=='0') {
					visited[i][j][0]=true;
					pq.add(new Node(i,j,0,0));
					maps[i][j]='.';
				}
			}
		}
		
	bfs(pq);
	if(ans==0) {
		System.out.println(-1);
	}
	else {
		System.out.println(ans);
	}
		
		
	}

	private static void bfs(PriorityQueue<Node> pq) {
		
		while(!pq.isEmpty()) {
			Node temp=pq.poll();
		//	System.out.println(temp);
			if(maps[temp.x][temp.y]=='1') {
				ans=temp.count;
				break;
			}
			
			for(int i=0;i<dx.length;i++) {
				int nx=temp.x+dx[i];
				int ny=temp.y+dy[i];
				if(nx<0||nx>=N||ny<0||ny>=M)continue;
				if(maps[nx][ny]=='#')continue;
				if(visited[nx][ny][temp.bitcount])continue;
				if(maps[nx][ny]=='.') {
					pq.add(new Node(nx,ny,temp.count+1,temp.bitcount));
					visited[nx][ny][temp.bitcount]=true;
				}
				if(maps[nx][ny]>='a'&&maps[nx][ny]<='z') {
					int index=maps[nx][ny]-'a';
					visited[nx][ny][temp.bitcount|1<<index]=true;
					pq.add(new Node(nx,ny,temp.count+1,temp.bitcount|1<<index));
					
				}
				if(maps[nx][ny]>='A'&&maps[nx][ny]<='Z') {
					int index=maps[nx][ny]-'A';
					int bit=1<<index;
					if((bit&temp.bitcount)>0) {
						pq.add(new Node(nx,ny,temp.count+1,temp.bitcount));
						visited[nx][ny][temp.bitcount]=true;
					}
					
					
				}
				if(maps[nx][ny]=='1') {
					pq.add(new Node(nx,ny,temp.count+1,temp.bitcount));
					
				}
				
			}
			
			
		}
		
		
		
	}
}
