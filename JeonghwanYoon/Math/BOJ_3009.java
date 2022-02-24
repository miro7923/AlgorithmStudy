import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3009 {

	public static void main(String[] args) throws IOException {
		
		/*
		 * 
		 * 문제 세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.
		 * 
		 * 입력 세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.
		 * 
		 * 출력 직사각형의 네 번째 점의 좌표를 출력한다.
		 * 
		 */
		
		//풀이 : 직사각형의 경우 3점중 2점이 같은경우 나머지 한점이 4번째 점의 위치
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer input1 = new StringTokenizer(br.readLine());
		StringTokenizer input2 = new StringTokenizer(br.readLine());
		StringTokenizer input3 = new StringTokenizer(br.readLine());
		
		int x1 = Integer.parseInt(input1.nextToken());
		int y1 = Integer.parseInt(input1.nextToken());
		int x2 = Integer.parseInt(input2.nextToken());
		int y2 = Integer.parseInt(input2.nextToken());
		int x3 = Integer.parseInt(input3.nextToken());
		int y3 = Integer.parseInt(input3.nextToken());
		
		int x4 = x1 == x2 ? x3 : x1 == x3 ? x2 : x1;
		int y4 = y1 == y2 ? y3 : y1 == y3 ? y2 : y1;
		
		System.out.println(x4 + " " + y4);
		
		

	}

}
