package firstProject;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class bak_17472 {
	static int maps[][];
	static int N, M;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static boolean visited[][];
	static int edge[][];
	static int parent[];
	static PriorityQueue<Pair> pq;

	public static class Pair implements Comparable<Pair> {
		int x, y, count;

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + ", count=" + count + "]";
		}

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Pair(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.count - o.count;
		}

	}

	public static void bfs(int count, int x, int y) {
		int from = maps[x][y];
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		visited[x][y] = true;
		while (!q.isEmpty()) {

			Pair temp = q.poll();
			maps[temp.x][temp.y] = count;
			for (int i = 0; i < dx.length; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;

				if (maps[nx][ny] == from && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new Pair(nx, ny));
				}

			}

		}

	}

	public static void straight(int x, int y, int rotate) {
		int from = maps[x][y];
		int count = 0;
		while (true) {
			int nx = x + dx[rotate];
			int ny = y + dy[rotate];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
				break;
			}
			if (maps[nx][ny] == from)
				break;

			if (maps[nx][ny] == 0) {
				count += 1;
				x = nx;
				y = ny;
			}
			if (maps[nx][ny] != 0 && maps[nx][ny] != from) {
				pq.add(new Pair(from, maps[nx][ny], count));
				break;
			}

		}

	}

	public static void calculate() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (maps[i][j] != 0) {
					for (int rotate = 0; rotate < dx.length; rotate++) {
						straight(i, j, rotate);
					}

				}
			}
		}

	}

	public static int findParent(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = findParent(parent[x]);

	}

	public static boolean unionParent(int x, int y) {
		int apar = findParent(x);
		int bpar = findParent(y);

		if (apar == bpar)
			return false;
		if (apar < bpar) {
			parent[bpar] = apar;
		} else {
			parent[apar] = bpar;
		}
		return true;
	}
	public static boolean connectcheck() {
		int p=findParent(1);
		for(int i=1;i<parent.length;i++) {
			if(p!=findParent(i)) {
				return false;
			}
		}
		return true;
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		maps = new int[N][M];
		visited = new boolean[N][M];
		Pair start;
		pq = new PriorityQueue<>();
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				maps[i][j] = sc.nextInt();
				if (maps[i][j] == 0 && !flag) {
					start = new Pair(i, j);
					flag = true;
				}
			}
		}

		int islandnum = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && maps[i][j] != 0)
					bfs(islandnum++, i, j);
			}
		}
		

		calculate();

		
		parent = new int[islandnum ];
	
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}

		edge = new int[islandnum][islandnum];
		int sum = 0;
		int count = 0;
		while (!pq.isEmpty()) {

			Pair temp = pq.poll();
			
			if (temp.count != 1 && unionParent(temp.x, temp.y)) {
				sum += temp.count;
				if(connectcheck())break;
			}

		}
		if(connectcheck()) {
			System.out.println(sum);
		}
		else {
			System.out.println(-1);
		}
	

	}
}
