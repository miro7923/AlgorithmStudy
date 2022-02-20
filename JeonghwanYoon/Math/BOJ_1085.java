import java.util.Scanner;

public class BOJ_1085 {

	
	public static void main(String[] args) {
		
		/*
		 * 문제 한수는 지금 (x, y)에 있다. 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w,
		 * h)에 있다. 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
		 * 
		 * 입력 첫째 줄에 x, y, w, h가 주어진다.
		 * 
		 * 출력 첫째 줄에 문제의 정답을 출력한다.
		 */
		
		//풀이 : 가는거리의 최소값은 (x-0,y-0) 혹은 (w-x,h-y)기준으로 가장 작은 수가 정답
		
		Scanner scanner = new Scanner(System.in);
		String[] st = {};
		int num1 = 0;
		int num2 = 0;
		
		String input = scanner.nextLine();
		st = input.split(" ");
		
		num1 = Integer.parseInt(st[0]) > Integer.parseInt(st[1]) ? Integer.parseInt(st[1]) : Integer.parseInt(st[0]);
		num2 =  Integer.parseInt(st[2]) - Integer.parseInt(st[0]) > Integer.parseInt(st[3]) - Integer.parseInt(st[1]) ? Integer.parseInt(st[3]) - Integer.parseInt(st[1]) : Integer.parseInt(st[2]) - Integer.parseInt(st[0]);
		
		if (num1 > num2) {
			System.out.println(num2);
		}
		else {
			System.out.println(num1);
		}
	}
}
