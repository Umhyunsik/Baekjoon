import java.io.BufferedReader;
import java.util.Scanner;

public class bak_2239 {
	static int maps[][];
	static int N=9;
	static boolean block [][][];
	static boolean row[][];
	static boolean col[][];
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		maps=new int[9][9];
		for(int i=0;i<9;i++) {
			String temp=sc.next();
			for(int j=0;j<temp.length();j++) {
				maps[i][j]=temp.charAt(j)-'0';
			}
		}
		row= new boolean[9][9];
		col= new boolean[9][9];
		
		block=new boolean[3][3][9];
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(maps[i][j]!=0) {
					row[i][maps[i][j]-1]=true;
					
				}
			}
		}
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(maps[j][i]!=0) {
					col[i][maps[j][i]-1]=true;
					
				}
			}
		}
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(maps[i][j]!=0) {
					block[i/3][j/3][maps[i][j]-1]=true;
					
				}
			}
		}
		
		

		dfs(0,0);
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(maps[i][j]);
			}
			System.out.println();
		}

		
		
	}
	private static boolean dfs(int i, int j) {
		

		
		if(i==9) return true;
		if(j==9) {
			return dfs(i+1,0);
		
		}
		

		if(maps[i][j]!=0)return dfs(i,j+1);

		boolean flag=false;
		for(int num=1;num<=9;num++) {
			if(!row[i][num-1]&&!col[j][num-1]&&!block[i/3][j/3][num-1]&&maps[i][j]==0) {
				flag=true;
				row[i][num-1]=true;
				col[j][num-1]=true;
				block[i/3][j/3][num-1]=true;
				maps[i][j]=num;
				if(dfs(i,j+1))return true;
				row[i][num-1]=false;
				col[j][num-1]=false;
				block[i/3][j/3][num-1]=false;
				maps[i][j]=0;
			}
		}
		return false;
		
		
		
	}
}
