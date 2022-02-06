import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1157 {

	public static void main(String[] args) {
		
//		문제
//		알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
//		단, 대문자와 소문자를 구분하지 않는다.
//
//		입력
//		첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
//
//		출력
//		첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 
//		단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
		
		//풀이 : 대소문자 구분없이 가장 많이 사용된 알파벳 찾는 문제이므로, 입력받은 값을 알파벳을 카운트할 배열만들어서
		// 대소문자 구분없이 배열인덱스에 카운팅하고 비교해서 같으면 '?' 다르면 가장큰 값 대문자로 출력
		
		Scanner sc = new Scanner(System.in);
		
		String st = sc.nextLine(); // 문자열 입력
		int alph[] = new int[26]; // 알파벳 갯수 26
		sc.close();
		
		for(int i=0; i<st.length(); i++) {
			
			int temp = st.charAt(i);
			
			if(temp >= 'a' && temp <='z') { // 소문자일때 카운트
				alph[temp - 'a']++;
			}
			else if(temp >= 'A' && temp <='Z') { // 대문자일때 카운트
				alph[temp - 'A']++;
			}
		}
		
		int temp = alph[0]; // 알파벳 카운팅 비교 변수 초기값은 인덱스0번으로 지정함
		char ch = 'A'; // 출력할 변수
		
		for(int i=1; i<alph.length; i++)
		{
			if(temp == alph[i]) { 
				ch = '?';
			}
				
			else if(temp < alph[i]) {
				temp = alph[i]; // alph[i]값이 더크므로 temp에 alph[i]값 입력
				ch = (char) (i + 'A');
			}
		}
			System.out.println(ch);
	}
}
