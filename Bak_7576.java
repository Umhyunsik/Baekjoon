import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bak_7576 {
	static class Pair{
		int x;
		int y;
		int count;
		public Pair(int x, int y, int count) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	static int N,M;
	static int maps[][];
	static int dx[] = {-1,0,1,0};
	static int dy[]= {0,1,0,-1};
	public static void main(String[] args) {
		
		
		Scanner sc =new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		maps=new int[M][N];
		ArrayList<Pair> arr =new ArrayList<>();
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				maps[i][j]=sc.nextInt();
				if(maps[i][j]==1)arr.add(new Pair(i,j,0));
			}
		}
		
		System.out.println(bfs(arr));
		
		
	}
	private static int bfs(ArrayList<Pair> arr) {
		// TODO Auto-generated method stub
		Queue<Pair> q =new LinkedList<>();
		boolean[][] visited = new boolean[M][N]; 
		for(int i=0;i<arr.size();i++) {
			q.add(arr.get(i));
			visited[arr.get(i).x][arr.get(i).y]=true;
		}
		int ans=-1;
		while(!q.isEmpty()) {
			
			Pair temp=q.poll();
			if(ans<temp.count)ans=temp.count;
			for(int i=0;i<dx.length;i++) {
				int nx=temp.x+dx[i];
				int ny=temp.y+dy[i];
				if(nx<0||nx>=M||ny<0||ny>=N)continue;
				if(maps[nx][ny]==0&&!visited[nx][ny]) {
					visited[nx][ny]=true;
					q.add(new Pair(nx,ny,temp.count+1));
				}
			}
			
			
			
		}
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]&&maps[i][j]==0)ans=-1;
			}
		}
		
		return ans;
	}

}
