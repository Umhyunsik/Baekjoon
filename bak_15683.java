import java.util.ArrayList;
import java.util.Scanner;

public class bak_15683 {
	
	static int N,M;
	static int [][]maps;
	static ArrayList<Point> arr;
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	static int min=Integer.MAX_VALUE;
	
	static class Point{
		int x,y;
		int style;

		public Point(int x, int y, int style) {
			super();
			this.x = x;
			this.y = y;
			this.style = style;
		}

		
	}
	
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		arr =new ArrayList<>();
		maps=new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				maps[i][j]=sc.nextInt();
				if(maps[i][j]!=6&&maps[i][j]!=0) {
					arr.add(new Point(i,j,maps[i][j]));
				}
			}
		}
		for(int i=0;i<arr.size();i++) {
			Point temp=arr.get(i);
			if(temp.style==5) {
				drawfive(temp.x,temp.y);
				arr.remove(i);
				i--;
				
			}
		}
		dfs(0);
		System.out.println(min);
		
		
	}


	private static void printmaps() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(maps[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}


	private static void drawfive(int x, int y) {
		
		for(int i=0;i<dx.length;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			while(true) {
				
				if(nx<0||nx>=N||ny<0||ny>=M)break;
				if(maps[nx][ny]==6)break;
				if(maps[nx][ny]==0) {
					maps[nx][ny]=10;
				}
				else if(maps[nx][ny]>=10) {
					maps[nx][ny]+=1;
				}
				
				nx=nx+dx[i];
				ny=ny+dy[i];
				
			}
			
		}
		
	}


	private static void dfs(int i) {
		
		if(i==arr.size()) {
			//printmaps();
			count();
			return;
		}
		
		Point now=arr.get(i);
		
		if(now.style==1) {
			
			for(int dir=0;dir<dx.length;dir++) {
				int nx=now.x+dx[dir];
				int ny=now.y+dy[dir];
				if(nx<0||nx>=N||ny<0||ny>=M)continue;
				if(maps[nx][ny]==6)continue;
				draw(nx,ny,dir);
				dfs(i+1);
				erase(nx,ny,dir);
			}
		}
		
		if(now.style==2) {
			
			int first=0;
			int second=2;
			for(int c=0;c<2;c++) {
				boolean flag=false;
				boolean flag1=false;
				
				int nx=now.x+dx[first];
				int ny=now.y+dy[first];
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&maps[nx][ny]!=6) {
					draw(nx,ny,first);
					flag=true;
				}
				int nnx=now.x+dx[second];
				int nny=now.y+dy[second];
				if(nnx>=0&&nnx<N&&nny>=0&&nny<M&&maps[nnx][nny]!=6) {
					draw(nnx,nny,second);
					flag1=true;
				}
				dfs(i+1);
				
				
				if(flag) {
					erase(nx,ny,first);
				}
				if(flag1) {
					erase(nnx,nny,second);
				}
				
				first=(first+1)%4;
				second=(second+1)%4;
				
			}
			
		}
		
		if(now.style==3) {
			
			int first=0;
			int second=1;
			for(int c=0;c<4;c++) {
				boolean flag=false;
				boolean flag1=false;
				
				int nx=now.x+dx[first];
				int ny=now.y+dy[first];
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&maps[nx][ny]!=6) {
					draw(nx,ny,first);
					flag=true;
				}
				int nnx=now.x+dx[second];
				int nny=now.y+dy[second];
				if(nnx>=0&&nnx<N&&nny>=0&&nny<M&&maps[nnx][nny]!=6) {
					draw(nnx,nny,second);
					flag1=true;
				}
				dfs(i+1);
				
				
				if(flag) {
					erase(nx,ny,first);
				}
				if(flag1) {
					erase(nnx,nny,second);
				}
	
		
				
				first=(first+1)%4;
				second=(second+1)%4;
				
			}
			
		}
		
		if(now.style==4) {
			
			int first=0;
			int second=1;
			int third=2;
			for(int c=0;c<4;c++) {
				boolean flag=false;
				boolean flag1=false;
				boolean flag2=false;
				
				int nx=now.x+dx[first];
				int ny=now.y+dy[first];
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&maps[nx][ny]!=6) {
					draw(nx,ny,first);
					flag=true;
				}
				int nnx=now.x+dx[second];
				int nny=now.y+dy[second];
				if(nnx>=0&&nnx<N&&nny>=0&&nny<M&&maps[nnx][nny]!=6) {
					draw(nnx,nny,second);
					flag1=true;
				}
				int nnnx=now.x+dx[third];
				int nnny=now.y+dy[third];
				if(nnnx>=0&&nnnx<N&&nnny>=0&&nnny<M&&maps[nnnx][nnny]!=6) {
					draw(nnnx,nnny,third);
					flag2=true;
				}
				dfs(i+1);
				
				
				if(flag) {
					erase(nx,ny,first);
				}
				if(flag1) {
					erase(nnx,nny,second);
				}
				if(flag2) {
					erase(nnnx,nnny,third);
				}
	
		
				
				first=(first+1)%4;
				second=(second+1)%4;
				third=(third+1)%4;
				
			}
			
		}
	
		
		
	}


	private static void count() {
		// TODO Auto-generated method stub
		
		int counts=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(maps[i][j]==0)counts+=1;
			}
		}
		if(counts<min)min=counts;
	}


	private static void erase(int nx, int ny, int dir) {
		
		
		while(true) {
			if(maps[nx][ny]==10) {
				maps[nx][ny]=0;
			}
			else if(maps[nx][ny]>=10) {
				maps[nx][ny]-=1;
			}
			nx=nx+dx[dir];
			ny=ny+dy[dir];
			
			if(nx<0||nx>=N||ny<0||ny>=M)break;
			if(maps[nx][ny]==6)break;
			
		}
	}
	
	


	private static void draw(int nx, int ny, int dir) {

		while(true) {

			if(maps[nx][ny]==0) {
				maps[nx][ny]=10;
			}
			else if(maps[nx][ny]>=10) {
				maps[nx][ny]+=1;
			}
			nx=nx+dx[dir];
			ny=ny+dy[dir];
			
			if(nx<0||nx>=N||ny<0||ny>=M)break;
			if(maps[nx][ny]==6)break;
			
		}
		
	}

}
