package firstProject;

import java.util.ArrayList;
import java.util.Scanner;

public class bak_1799_2 {

	static int[][] maps;
	//static boolean[] rightDiag;
	static boolean[] leftDiag;
	static int max;
	static int N;

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static ArrayList<Pair> makepair(int row) {
		ArrayList<Pair> list = new ArrayList<>();
		int arraysize = row + 1;
		int diagrowlen = (2 * N) - 1;
		int x, y;
		if (row >= N) {// 대각선 배열 개수 1 2 3 4 5 4 3 2 1
			// 중간 대각선을 넘은경우
			arraysize = diagrowlen - row;

			y = N - 1;
			x = row - y;

		} else {
			x = 0;
			y = row;
		}

		for (int i = 0; i < arraysize; i++) {
			list.add(new Pair(x, y));
			x += 1;
			y -= 1;

		}

		return list;
	}

	static void dfs(int row) {

		if (row == (2 * N) - 1) {
			int check = 0;
			for (int i = 0; i < leftDiag.length; i++) {
				if (leftDiag[i]) {
					check++;
				}
			}
			if (max < check) {
				max = check;
			}
			return;
		}
		boolean flag=false;
		
		ArrayList<Pair> pairList = makepair(row);		
		for (int i = 0; i < pairList.size(); i++) {
		int x = pairList.get(i).x;
		int y = pairList.get(i).y;
		if (maps[x][y] == 1 && !leftDiag[(y - x) + (N - 1)]) {
			leftDiag[y - x + N - 1] = true;
			dfs(row + 1);
			leftDiag[y - x + N - 1] = false;
			flag=true;
		}

	}
	
		
		if(!flag) {
			dfs(row+1);
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		maps = new int[N][N];
		//rightDiag = new boolean[(2 * N) - 1];
		leftDiag = new boolean[(2 * N) - 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				maps[i][j] = sc.nextInt();
			}
		}
		
		dfs(0);
		System.out.println(max);

	}
}
