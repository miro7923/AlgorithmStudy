/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2739
 * 
 * # 문제
 * N을 입력받은 뒤, 구구단 N단을 출력하는 프로그램을 작성하시오. 출력 형식에 맞춰서 출력하면 된다.
 * 
 * # 제한
 * 시간제한: 1초 / 메모리 제한: 128 MB
 * 
 * # 입력
 * 첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 9보다 작거나 같다.
 * 
 * # 출력
 * 출력형식과 같게 N*1부터 N*9까지 출력한다.
 * 
 */

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		
		for (int i = 1; 9 >= i; i++)
			System.out.println(N + " * " + i + " = " + N * i);

	}

}
