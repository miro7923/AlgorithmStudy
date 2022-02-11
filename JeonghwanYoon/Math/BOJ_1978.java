import java.util.Scanner;

public class BOJ_1978 {

	public static void main(String[] args) {
		
		
		/*
		 * 문제 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
		 * 
		 * 입력 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
		 * 
		 * 출력 주어진 수들 중 소수의 개수를 출력한다.
		 * 
		 */
		
		//풀이 : 소수는 1과 그자신외에 나눌 수 없는 1보다 큰 자연수
		// 1000이하 자연수중 소수를 구하는문제
		// 탐색하며 찾는방법으로 구해보자
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] arr = new int[T];
		boolean chk = true;
		int cnt = 0; // 소수 갯수
		
		
		
		for(int i=0; i<T; i++) { // 입력값
			arr[i] = sc.nextInt();
			
			for(int j=2; j<arr[i]; j++) {
				if(arr[i] % j == 0) { // 2부터 본인값전까지 나눠서 나머지가 0이면 소수가 아님 
					chk = false; // 나머지가 있으면 소수아니므로 chk false
				}
			}
			if(chk && arr[i] != 1) { 
				cnt++;
			}
			
			chk = true; // 초기화
		}
		System.out.println(cnt);
	}

}









