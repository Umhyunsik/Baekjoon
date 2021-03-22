import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bak_1753_우선순위 {

	public static class Node {

		Node nextnode;
		int vertex;
		int weight;

		public Node(Node nextnode, int vertex, int weight) {
			this.nextnode = nextnode;
			this.vertex = vertex;
			this.weight = weight;
		}

	}

	public static class Pair implements Comparable<Pair> {

		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.y-o.y;
		}
	}

	public static void dikstra(int start, Node[] maps) {

		PriorityQueue<Pair> q=new PriorityQueue<>();
		int[] dist = new int[maps.length];
		StringBuilder s =new StringBuilder();
		q.add(new Pair(start, 0));
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		while (!q.isEmpty()) {

			Pair temp = q.poll();
			if (temp.y > dist[temp.x]) {
				continue;
			}

			for (Node nodetemp = maps[temp.x]; nodetemp != null; nodetemp = nodetemp.nextnode) {
				if (nodetemp.weight + temp.y < dist[nodetemp.vertex]) {
					dist[nodetemp.vertex] = nodetemp.weight + temp.y;
					q.add(new Pair(nodetemp.vertex, nodetemp.weight + temp.y));
				}

			}

		}
		for (int i = 0; i < maps.length; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				s.append("INF");
		
			} else {
				s.append(dist[i]);
			}
			s.append("\n");
		}
		System.out.println(s);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		int K = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(br.readLine());
		Node[] maps = new Node[K];
		
		for (int i = 0; i < V; i++) {
			 String[] strs = br.readLine().split("\\s");
			 
            int start = Integer.parseInt(strs[0]);
            int end = Integer.parseInt(strs[1]);
            int w = Integer.parseInt(strs[2]);
            start-=1;
            end-=1;
			maps[start] = new Node(maps[start], end, w);
		}

		dikstra(S - 1, maps);

	}
}
