import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2581 {

	public static void main(String[] args) throws IOException{
		
		/*
		 * 문제 자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
		 * 
		 * 예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총
		 * 8개가 있으므로, 이들 소수의 합은 620이고, 최솟값은 61이 된다.
		 * 
		 * 입력 입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다.
		 * 
		 * M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.
		 * 
		 * 출력 M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다.
		 * 
		 * 단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N-M+1];
		boolean chk = true; // 소수인지 체크 변수
		int sum = 0;
		int min = 0;
		
		
		for(int i=0; i<arr.length; i++) { 
			arr[i] = i+M; // M부터 N까지 소수인지 체크
			
			for(int j=2; j<M+i; j++) {
				if(arr[i] % j == 0) { // 2부터 본인값전까지 나눠서 나머지가 0이면 소수가 아님 
					chk = false; // 나머지가 있으면 소수아니므로 chk false
				}
			}
			
			if(chk && arr[i] != 1) { 
				if(sum == 0) {
					min = arr[i]; // 최소값 넣기
				}
				sum += arr[i]; // 소수값 더하기
			}
			chk = true; // 초기화
		}
		if(sum == 0) { // 소수 없으면 -1 출력
			System.out.println(-1);
			return;
		}
		System.out.println(sum);
		System.out.println(min);
	}
		
}
