package firstProject;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bak_9205 {

	static class Pair {

		int x;
		int y;
		int count;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Pair(int x, int y, int count) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int Tc = sc.nextInt();
		for (int tc = 1; tc <= Tc; tc++) {
			int N = sc.nextInt();

			Pair start = new Pair(sc.nextInt(), sc.nextInt());

			Pair[] p = new Pair[N];
			for (int i = 0; i < N; i++) {
				p[i] = new Pair(sc.nextInt(), sc.nextInt());

			}
			Pair end = new Pair(sc.nextInt(), sc.nextInt());
			start.setCount(20);
			Queue<Pair> q = new LinkedList<>();
			q.add(start);
			boolean flag = false;
			boolean visited[] = new boolean[N];
			while (!q.isEmpty()) {

				Pair temp = q.poll();
				//System.out.println(temp.x + " " + temp.y);
				if (Math.abs(temp.x - end.x) + Math.abs(temp.y - end.y) <= temp.count * 50) {
					flag = true;
					break;
				}

				for (int i = 0; i < N; i++) {
					int walk = Math.abs(temp.x - p[i].x) + Math.abs(temp.y - p[i].y);
					// System.out.println(walk+" "+temp.count);
					if (temp.count * 50 >= walk && !visited[i]) {
						q.add(new Pair(p[i].x, p[i].y, 20));
						visited[i] = true;
					}
				}

			}
			if (flag) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
		}

	}
}
