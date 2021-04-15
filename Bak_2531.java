import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bak_2531 {

	static int N,d,k,c;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		int array[] = new int [N];
		for(int i=0;i<N;i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		int max=0;
		for(int i=0;i<N;i++) {
			int[] food =new int[d+1];
			food[c]+=1;
			int count=1;
			for(int j=i;j<i+k;j++) {
				int idx=j%N;
				if(food[array[idx]]==0) {
					count+=1;
				}
				food[array[idx]]+=1;
				//System.out.println(idx);
			}
			if(max<count)max=count;
			
		}
		System.out.println(max);
	}
}
