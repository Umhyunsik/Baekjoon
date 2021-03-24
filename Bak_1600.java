package DP;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bak_1600 {
	static int K, W, H;
	static int[][] maps;
	static int[] nightx = { -2, -1, -2, -1, 1, 2, 1, 2 };
	static int[] nighty = { -1, -2, 1, 2, -2, -1, 2, 1 };
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][][] memo;
	static int min = Integer.MAX_VALUE;

	public static class Pair {
		int x, y, count, step;

		public Pair(int x, int y, int count, int step) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.step = step;

		}

	}

	public static void bfs() {
		Queue<Pair> q = new LinkedList<>();

		q.add(new Pair(0, 0, K, 0));
		while (!q.isEmpty()) {

			Pair temp = q.poll();
			if (memo[temp.x][temp.y][temp.count])
				continue;
			memo[temp.x][temp.y][temp.count] = true;
			if (temp.x == H - 1 && temp.y == W - 1) {
				if (min > temp.step)
					min = temp.step;
				continue;
			}
			if (temp.count > 0) {
				for (int i = 0; i < nightx.length; i++) {
					int nix = temp.x + nightx[i];
					int niy = temp.y + nighty[i];
					if (nix < 0 || nix >= H || niy < 0 || niy >= W)
						continue;
					if (maps[nix][niy] != 1 && !memo[nix][niy][temp.count - 1]) {
						q.add(new Pair(nix, niy, temp.count - 1, temp.step + 1));
					}
				}

			}

			for (int i = 0; i < dx.length; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if (nx < 0 || nx >= H || ny < 0 || ny >= W)
					continue;
				if (maps[nx][ny] != 1) {
					if (!memo[nx][ny][temp.count])
						q.add(new Pair(nx, ny, temp.count, temp.step + 1));
				}
			}

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		maps = new int[H][W];
		memo = new boolean[H][W][K + 1];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				maps[i][j] = sc.nextInt();
			}
		}
		bfs();
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}
}
