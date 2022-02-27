import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_4153 {

	public static void main(String[] args) throws IOException {
		
		
		/*
		 * 
		 * 문제 과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 주어진 세변의 길이로 삼각형이 직각인지
		 * 아닌지 구분하시오.
		 * 
		 * 입력 입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다. 각 테스트케이스는 모두 30,000보다 작은 양의 정수로
		 * 주어지며, 각 입력은 변의 길이를 의미한다.
		 * 
		 * 출력 각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.
		 * 
		 */
		
		//풀이 : 직각삼각형 조건은 가장 큰수의 제곱 = 나머지 두수의 각 제곱의 합 일때 right
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input;
		
		while(!(input = br.readLine()).equals("0 0 0")) {
			
			String[] st = input.split(" ");
			
			int[] arr = {Integer.parseInt(st[0]) , Integer.parseInt(st[1]) , Integer.parseInt(st[2])};
			
			Arrays.sort(arr); 
			
			if(Math.pow(arr[2],2) == Math.pow(arr[0], 2) + Math.pow(arr[1], 2)) {
				sb.append("right\n");
			}
			else {
				sb.append("wrong\n");
			}
			
		}
		System.out.println(sb);
	}
}
