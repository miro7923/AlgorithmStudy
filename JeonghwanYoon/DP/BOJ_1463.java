import java.util.Scanner;

public class BOJ_1463 {

	public static void main(String[] args) {

//		
//		문제  
//		정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
//
//		X가 3으로 나누어 떨어지면, 3으로 나눈다.
//		X가 2로 나누어 떨어지면, 2로 나눈다.
//		1을 뺀다.
//		정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
//
//		입력
//		첫째 줄에 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N이 주어진다.
//
//		출력
//		첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
		
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt(); // 10^6까지 이므로 int형 사용가능! 
		int[] arr = new int[N+1];
		scanner.close(); 
		arr[1] = 0;
		
		for(int i=2; i<=N; i++)
		{
			arr[i] = arr[i-1] + 1; 
			if(i%2 == 0) // 2로 나눠질경우 2로 먼저나눠서 비교
			{
				arr[i] = min(arr[i],arr[i/2]+1); 
			}
			if(i%3 == 0) // 3으로 나눠질경우 3과 나눠서 앞과 비교
			{
				arr[i] = min(arr[i],arr[i/3]+1); 
			}
		}
		System.out.println(arr[N]);
	}
	static int min(int a , int b)
	{
		return a > b ? b : a;
	}
}
