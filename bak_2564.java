import java.util.Scanner;

public class bak_2564 {

		static int N,M,K;
	
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		K=sc.nextInt();
	
		int [] arr=new int[2*N+2*M];
		for(int i=1;i<=K+1;i++) {
			int where=sc.nextInt();
			int far =sc.nextInt();
			
			if(where==1) {
				arr[far]=i;
	
			}
			else if(where==2) {
				arr[N+M+N-far]=i;

			}
			else if(where==3) {
				arr[N+N+M+M-far]=i;
	
			}
			else if (where==4) {
				arr[N+far]=i;
	
			}
		}
		int start=-1;
	
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==K+1) {
				start=i;
			}
		}

		int sum=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) {
				int temp=0;
				if(start>i) {
					int go=start-i;
					int rev=arr.length-start+i;
					temp=Math.min(rev, go);
					
				}
				else {
					
					int go=i-start;
					int rev=start+arr.length-i;
					temp=Math.min(rev, go);
					
					
				}
				sum+=temp;
				//System.out.println(temp);
				
			}
			
			
		}
		System.out.println(sum);
		
		
		
		
		
		
	}
}
