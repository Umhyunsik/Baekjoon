import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Algo1_대전_5반_엄현식 {

	
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		int M=sc.nextInt();//시작 수 
		int N=sc.nextInt();//끝 수 
		
		Map<Integer, String > dict= new HashMap<>(); // 숫자-> 영어 변환 Map
		Map<String,String> revdict= new HashMap<>();// 영어 -> 숫자  변환 Map
		dict.put(0,"zero");
		dict.put(1,"one");
		dict.put(2,"two");
		dict.put(3,"three");
		dict.put(4,"four");
		dict.put(5,"five");
		dict.put(6,"six");
		dict.put(7,"seven");
		dict.put(8,"eight");
		dict.put(9,"nine");
		revdict.put("zero","0");
		revdict.put("one","1");
		revdict.put("two","2");
		revdict.put("three","3");
		revdict.put("four","4");
		revdict.put("five","5");
		revdict.put("six","6");
		revdict.put("seven","7");
		revdict.put("eight","8");
		revdict.put("nine","9");
		String [] s=new String[N-M+1]; // 숫자 -> 영어 -> 사전순 숫자 배열 
		
		for(int i=0;i<s.length;i++) {
			String temp=String.valueOf(i+M);//M 부터 N까지의 숫자 String변환
			String numtoString="";
			for(int k=0;k<temp.length();k++) {
				numtoString+=dict.get(Integer.parseInt(Character.toString(temp.charAt(k))))+" ";//영어 변환 띄어쓰기 넣어주기  
				
			}
			s[i]=numtoString;//영어 변환 저장 
		}
		Arrays.sort(s);// 사전순 sorting
		
		for(int i=0;i<s.length;i++) {
			String[] temp=s[i].split(" ");//단어를 띄워서 split 
			String tempnum="";
			for(String string:temp) {
				tempnum+=revdict.get(string);//원래의 숫자 가져오기
			}
			s[i]=tempnum;//s배열 저장 
		}
		
		
		for(int i=0;i<s.length;i++) {//출력
			if(i!=0&&i%10==0)System.out.println();
			System.out.print(s[i]+" ");
		}
		
		
		
		
		
		
		
	}
}
