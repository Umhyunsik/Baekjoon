import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Bak_1726 {

	static int N, M;
	static int[][] maps;
	static int start_x, start_y, start_rotate;
	static int end_x, end_y, end_rotate;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	static boolean check[][][];

	static class Point implements Comparable<Point> {
		int x;
		int y;
		int rotate;
		int count;

		public Point(int x, int y, int rotate, int count) {
			super();
			this.x = x;
			this.y = y;
			this.rotate = rotate;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", rotate=" + rotate + ", count=" + count + "]";
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.count - o.count;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		maps = new int[N][M];
		check = new boolean[N][M][4];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				maps[i][j] = sc.nextInt();
			}
		}
		start_x = sc.nextInt() - 1;
		start_y = sc.nextInt() - 1;
		start_rotate = sc.nextInt() - 1;

		end_x = sc.nextInt() - 1;
		end_y = sc.nextInt() - 1;
		end_rotate = sc.nextInt() - 1;

		System.out.println(bfs());

	}

	private static int bfs() {
		int ans = Integer.MAX_VALUE;
		
		PriorityQueue<Point> q = new PriorityQueue<>();
		// Queue<Point> q = new LinkedList<>();
		q.add(new Point(start_x, start_y, start_rotate, 0));
		check[start_x][start_y][start_rotate] = true;

		// 1번이면 2,3번가능 
		// 0번이면 2,3번가능
		// 2번이면 0,1번가능

		while (!q.isEmpty()) {
			Point temp = q.poll();
			// System.out.println(temp);
			if (temp.x == end_x && temp.y == end_y && temp.rotate == end_rotate) {
				if(ans>temp.count) {
					ans = temp.count;
				}
				continue;
			}

			int samedirection_x = temp.x;
			int samedirection_y = temp.y;

			for (int i = 0; i <= 2; i++) {

				samedirection_x += dx[temp.rotate];
				samedirection_y += dy[temp.rotate];
				if(samedirection_x < 0 || samedirection_x >= N || samedirection_y < 0 || samedirection_y >= M)break;
				
				if(check[samedirection_x][samedirection_y][temp.rotate])continue;
				
				if( maps[samedirection_x][samedirection_y] == 0) {
					check[samedirection_x][samedirection_y][temp.rotate] = true;
					q.add(new Point(samedirection_x, samedirection_y, temp.rotate, temp.count + 1));
				}
				else {
					break;
				}
			}

			// 나머지

			if (temp.rotate == 0 || temp.rotate == 1) {
				for (int i : new int[] { 2, 3 }) {
					if (!check[temp.x][temp.y][i]) {
						check[temp.x][temp.y][i] = true;
						q.add(new Point(temp.x, temp.y, i, temp.count + 1));
					}

				}

			}

			else {

				for (int i : new int[] { 0, 1 }) {

					if (!check[temp.x][temp.y][i]) {
						check[temp.x][temp.y][i] = true;
						q.add(new Point(temp.x, temp.y, i, temp.count + 1));
					}

				}

			}

		}
		return ans;

	}
}
