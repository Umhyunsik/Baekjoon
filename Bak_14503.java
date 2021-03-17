package firstProject;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bak_14503 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] maps;
	static boolean[][] check;
	static int count;

	static void dfs(int r, int c, int rotate) {
		if (maps[r][c] == 0) {
			count++;
			maps[r][c] = 2;
		}

		boolean flag = false;
		int k = rotate;
		for (int i = 0; i < dx.length; i++) {
			if (k == 0)
				k = 3;
			else
				k--;
			// 위 왼 아래 오른
			int nx = r + dx[k];
			int ny = c + dy[k];
			if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length)
				continue;
			if (maps[nx][ny] == 2 || maps[nx][ny] == 1)// 벽이거나 청소한곳이면 pass
				continue;

			if (maps[nx][ny] == 0) {// 청소공간 있으면
				flag = true;
				dfs(nx, ny, k);// rotate 각도 1 증가시켜서 보내주
				return;

			}

		}
		if (flag == false) {
			// int back=(rotate+2)%4;//현재위치 반대방
			int bx = r + dx[rotate] * (-1);
			int by = c + dy[rotate] * (-1);
			if (bx >= 0 && bx < maps.length && by >= 0 && by < maps[0].length) {// 범위 만
				if (maps[bx][by] == 1) {// 뒤가
					//System.out.println(count + "count��");
					return;
				} else {
					dfs(bx, by, rotate);
					return;
				}
			}

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		maps = new int[N][M];
		check = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				maps[i][j] = sc.nextInt();
			}
		}

		dfs(r, c, d);
		System.out.println(count);


	}
}
