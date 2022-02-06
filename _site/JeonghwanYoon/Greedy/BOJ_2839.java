import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839 {

	public static void main(String[] args) throws IOException{
		
		/*
		 * 
		 * 문제 
		 * 
		 * 상근이는 요즘 설탕공장에서 설탕을 배달하고 있다. 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다. 설탕공장에서
		 * 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
		 * 
		 * 상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다. 예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를
		 * 가져가도 되지만, 5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.
		 * 
		 * 상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
		 * 
		 * 입력 
		 * 
		 * 첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)
		 * 
		 * 출력 
		 * 
		 * 상근이가 배달하는 봉지의 최소 개수를 출력한다. 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.
		 * 
		 */

		// N킬로 설탕배달 , 봉지는 3 or 5kg단위 최대한 큰봉지위주로 , 
		// 5kg 먼저 채우고 나머지는 3kg으로 채워보자 , 나눠떨어지지않으면 -1 출력!
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N == 4 || N == 7) // 4와 7은 3또는 5로 나누어 지지않음
		{
			System.out.println(-1);
		}
		
		else if (N%5 == 0) // 5의 나머지값이 0일경우 5kg 봉지로 모두 담을 수 있다.
		{
			System.out.println(N/5);
		}
		
		else if (N%5 == 1 || N%5 ==3) // 경우의 수를 계산해보면 나머지가 1인경우와 3인경우 봉지의 수는 N/5+1
		{
			System.out.println(N/5+1);
		}
		
		else if (N%5 == 2 || N%5 == 4) // 위와 마찬가지로 계산시 N/5+2로 확인됨 else를 써도될것 같지만 입력이 3보다작을경우 오답처리 될것같아 else if로 처리 
		{
			System.out.println(N/5+2);
		}
	}
}
