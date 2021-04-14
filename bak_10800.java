import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bak_10800 {
	static int N;

	static class ball implements Comparable<ball> {
		int num;
		int color;
		int height;

		public ball(int num, int color, int height) {
			super();
			this.num = num;
			this.color = color;
			this.height = height;
		}

		@Override
		public int compareTo(ball o) {
			// TODO Auto-generated method stub
			int diff = this.height - o.height;
			if (diff == 0) {
				int colordiff = this.color - o.color;
				return colordiff;
			} else {
				return diff;
			}

		}

		@Override
		public String toString() {
			return "ball [num=" + num + ", color=" + color + ", height=" + height + "]";
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N=Integer.parseInt(br.readLine());
		ball[] balls=new ball[N]; 
		
		for(int i=0;i<N;i++) { 
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			balls[i]= new ball(i,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(balls);
		//System.out.println(Arrays.toString(balls));
		int [] color = new int[N+1];
		int heightsum=0;
		int [] save=new int[N];// number 매칭 weight 저장 
		
		int last_weight=0;
		int samecount=1;
		int last_color=0;
		int pre[] =new int[3];
		ball preball= new ball(-1,-1,-1);
		for(int i=0;i<N;i++) {
			
			
			if(preball.color==balls[i].color&&preball.height==balls[i].height) {//전과 아예일치 
				save[balls[i].num]=save[preball.num];
				samecount+=1;
		
			}
			else if(preball.height==balls[i].height) { // 높이만 일치  그전에 가서 color 빼주기
			
				save[balls[i].num]=heightsum-balls[i].height*samecount-color[balls[i].color];
				samecount+=1;
			}
			else { 
	
				save[balls[i].num]=heightsum-color[balls[i].color];
				samecount=1;
				
			}
			color[balls[i].color]+=balls[i].height;
			heightsum+=balls[i].height;

			preball.color=balls[i].color;
			preball.num=balls[i].num;
			preball.height=balls[i].height;
			
			
		}

		for(int i=0;i<N;i++) {
			System.out.println(save[i]);
		}
	}

}
