package firstProject;

import java.util.Scanner;

public class junol_해밀턴순환회로 {
static int maps[][];
static int N;
static int min=Integer.MAX_VALUE;
static boolean [] check;

public static void permu(int target,int now,int sumvalue) {

	if(sumvalue>min)return;
	if(target==N-1) {
		if(maps[now][0]==0)return;
		if(min>maps[now][0]+sumvalue)min=maps[now][0]+sumvalue;
		return;
	}

	for(int i=1;i<N;i++) {
		if(!check[i]&&maps[now][i]!=0) {
			check[i]=true;
			//save[target]=i;

			permu(target+1,i,maps[now][i]+sumvalue);
			check[i]=false;
			
		}
	}
	
	
	
}

public static void main(String[] args) {
	
	Scanner sc =new Scanner(System.in);
	N=sc.nextInt();
	maps  = new int [N][N];
	check=new boolean[N];
	for(int i=0;i<N;i++) {
		for(int j=0;j<N;j++) {
			maps[i][j]=sc.nextInt();
		}
	}

	permu(0,0,0);
	System.out.println(min);
	
	
	
}
}
