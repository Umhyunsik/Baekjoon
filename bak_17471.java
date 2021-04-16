import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bak_17471 {
	static int N;
	static int people[];
	static boolean edge[][];
	static boolean check[];
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		N=sc.nextInt();
		people= new int[N];
		edge=new boolean[N][N];
		check=new boolean[N];
		for(int i=0;i<N;i++)people[i]=sc.nextInt();
		for(int i=0;i<N;i++) {
			int temp=sc.nextInt();
			for(int j=0;j<temp;j++) {
				int arrive=sc.nextInt()-1;
				edge[i][arrive]=true;
				edge[arrive][i]=true;
			}
		}
		
		for(int i=1;i<=N/2;i++) {
			combi(0,0,i);
		}
		if(min==Integer.MAX_VALUE)System.out.println(-1);
		else{
			System.out.println(min);
		}
		
		
		
	}
	static void combi (int target,int count,int K) {
		if(count==K) {
			ArrayList<Integer> arr = new ArrayList<>();
			ArrayList<Integer> opp_arr = new ArrayList<>();
			int arrSum=0;
			int opp_arrSum=0;
			for(int i=0;i<N;i++) {
			
				if(check[i]) {
					arr.add(i);
					arrSum+=people[i];
				}
				else {
					opp_arr.add(i);
					opp_arrSum+=people[i];
				}
			}
			if(bfs(arr)&&bfs(opp_arr))
			{
		
				min= Math.min(min, Math.abs(arrSum-opp_arrSum));
		
			}
			
			return;
		}
		if(target==N) {
			return;
		}
		
		check[target]=true;
		combi(target+1,count+1,K);
		check[target]=false;
		combi(target+1,count,K);
		
		
	}
	private static boolean bfs(ArrayList<Integer> arr) {
		
		if(arr.size()==1)return true;
		
		int start =arr.get(0);
		int end= arr.get(arr.size()-1);
		boolean visited[]= new boolean[N];
		visited[start]=true;
		Queue<Integer> q =new LinkedList<Integer>();
		q.add(start);
		while(!q.isEmpty()) {
			
			int temp=q.poll();
			//System.out.println(temp+" ");
			
			for(int i=0;i<N;i++) {
				if(edge[temp][i]&&!visited[i]&&arr.contains(i)) {
					visited[i]=true;
					q.add(i);
				}
			}
			
			
		}
		for(int i=0;i<arr.size();i++) {
			if(!visited[arr.get(i)])return false;
		}
		
		return true;
		
	}
}
