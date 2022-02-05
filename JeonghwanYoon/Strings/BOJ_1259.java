import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1259 {

	public static void main(String[] args) throws IOException {
		
		
		/*
		 * 문제 어떤 단어를 뒤에서부터 읽어도 똑같다면 그 단어를 팰린드롬이라고 한다. 'radar', 'sees'는 팰린드롬이다.
		 * 
		 * 수도 팰린드롬으로 취급할 수 있다. 수의 숫자들을 뒤에서부터 읽어도 같다면 그 수는 팰린드롬수다. 121, 12421 등은 팰린드롬수다.
		 * 123, 1231은 뒤에서부터 읽으면 다르므로 팰린드롬수가 아니다. 또한 10도 팰린드롬수가 아닌데, 앞에 무의미한 0이 올 수 있다면
		 * 010이 되어 팰린드롬수로 취급할 수도 있지만, 특별히 이번 문제에서는 무의미한 0이 앞에 올 수 없다고 하자.
		 * 
		 * 입력 입력은 여러 개의 테스트 케이스로 이루어져 있으며, 각 줄마다 1 이상 99999 이하의 정수가 주어진다. 입력의 마지막 줄에는 0이
		 * 주어지며, 이 줄은 문제에 포함되지 않는다.
		 * 
		 * 출력 각 줄마다 주어진 수가 팰린드롬수면 'yes', 아니면 'no'를 출력한다.
		 * 
		 */	
		
		//풀이 : 역배열을 만들어서 값이 같으면 yes 다르면 no
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int num = 0;
		String reverseInput = "";
			
		while((num = Integer.parseInt(br.readLine())) != 0) { //입력 값이 0이면 종료
			
			String input = Integer.toString(num);
			
			for(int i=0; i<input.length(); i++) {
				reverseInput += Character.toString(input.charAt(input.length()-1-i)); // 거꾸로 값 넣고
			}
			
			if(reverseInput.equals(input)) {
				sb.append("yes\n");
			}
			
			else {
				sb.append("no\n");
			}
			
			reverseInput = ""; // 리버스 인풋 초기화
			
		}
		System.out.println(sb);
		
	}

}
