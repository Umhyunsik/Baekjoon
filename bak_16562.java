package firstProject;

import java.util.Arrays;
import java.util.Scanner;

public class bak_16562 {

	static int N, M;
	static int parent[];

	public static void set() {

		for (int i = 0; i < N; i++)
			parent[i] = i;
	}

	public static int findParent(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = findParent(parent[a]);
	}

	public static boolean check(int a, int b) {
		int aParent = findParent(a);
		int bParent = findParent(b);
		if (aParent == bParent)
			return true;
		else
			return false;
	}

	public static boolean union(int a, int b) {
		int aParent = findParent(a);
		int bParent = findParent(b);
		if (aParent == bParent)
			return true;

		if (aParent < bParent) {
			parent[bParent] = aParent;
		} else {
			parent[aParent] = bParent;
		}
		return false;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		parent = new int[N];
		M = sc.nextInt();
		int K = sc.nextInt();
		int[] money = new int[N];
		
		for (int i = 0; i < N; i++) {
			money[i] = sc.nextInt();
		}
		set();
		
		int[] smallmoney=new int [N];
		Arrays.fill(smallmoney,Integer.MAX_VALUE);
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			a -= 1;
			b -= 1;
			union(a, b);

		}
		
		for(int i=0;i<N;i++)findParent(i);
		
		for(int i=0;i<N;i++) {
			if(money[i]<smallmoney[parent[i]])smallmoney[parent[i]]=money[i];
		}
		int sum=0;
		for(int i=0;i<N;i++) {
			if(smallmoney[i]!=Integer.MAX_VALUE)sum+=smallmoney[i];
		}
		//System.out.println(sum);
		//System.out.println(K);
		if(K<sum)System.out.println("Oh no");
		else System.out.println(sum);

	}

}
