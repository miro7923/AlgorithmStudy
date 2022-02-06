import java.util.Scanner;

public class BOJ_1094 {

	public static void main(String[] args) {
		
//		문제
//		지민이는 길이가 64cm인 막대를 가지고 있다. 어느 날, 그는 길이가 Xcm인 막대가 가지고 싶어졌다. 
//		지민이는 원래 가지고 있던 막대를 더 작은 막대로 자른다음에, 풀로 붙여서 길이가 Xcm인 막대를 만들려고 한다.
//
//		막대를 자르는 가장 쉬운 방법은 절반으로 자르는 것이다. 지민이는 아래와 같은 과정을 거쳐서 막대를 자르려고 한다.
//
//			1. 지민이가 가지고 있는 막대의 길이를 모두 더한다. 처음에는 64cm 막대 하나만 가지고 있다. 이때, 합이 X보다 크다면, 아래와 같은 과정을 반복한다.
//				1.가지고 있는 막대 중 길이가 가장 짧은 것을 절반으로 자른다.
//				2.만약, 위에서 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 X보다 크거나 같다면, 위에서 자른 막대의 절반 중 하나를 버린다.
//			2.이제, 남아있는 모든 막대를 풀로 붙여서 Xcm를 만든다.
//		X가 주어졌을 때, 위의 과정을 거친다면, 몇 개의 막대를 풀로 붙여서 Xcm를 만들 수 있는지 구하는 프로그램을 작성하시오. 
//
//		입력
//		첫째 줄에 X가 주어진다. X는 64보다 작거나 같은 자연수이다.
//
//		출력
//		문제의 과정을 거친다면, 몇 개의 막대를 풀로 붙여서 Xcm를 만들 수 있는지 출력한다.
		
		// 예상풀이 : 원하는 Xcm의 막대를 구하기위해 64cm의 막대를 반으로 자르고 자른값이 X보다 크면 자른값을 또 반으로 자르고 자른값이 X보다 작으면
		// X값에 자른값을 빼고 Count에 1을 더하여 X가 0이 될때까지 반복하여 Count값을 출력하면 풀칠한 횟수를 알 수 있음
		
		// 예상 필요 변수 : stick(풀칠하여 더할 막대기) , X(원하는 막대기값 입력으로 받을것) , 풀칠 횟수 cnt
		
		Scanner sc = new Scanner(System.in);
 		
		
		int stick = 64; // 초기 막대기값 64
		int X = sc.nextInt(); // 원하는 X값 입력
		int cnt = 0;
		
		while(X > 0) // X가 0이하가 되면 종료
		{
			if(stick > X) {
				stick /= 2; // 스틱 반으로 자르기
			}
			
			else {
				X -= stick;
				cnt++;
			}
		}
		System.out.println(cnt);
		
		sc.close();
	}
}
