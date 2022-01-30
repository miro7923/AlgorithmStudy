/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1546
 * 
 * # 문제
 * 세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다. 
 * 일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
 * 예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
 * 세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.
 * 
 * # 제한
 * 시간 제한 : 2초, 메모리 제한 : 128 MB
 * 
 * # 입력
 * 첫째 줄에 시험 본 과목의 개수 N이 주어진다. 이 값은 1000보다 작거나 같다. 
 * 둘째 줄에 세준이의 현재 성적이 주어진다. 이 값은 100보다 작거나 같은 음이 아닌 정수이고, 적어도 하나의 값은 0보다 크다.
 * 
 * # 출력
 * 첫째 줄에 새로운 평균을 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10-2 이하이면 정답이다.
 * 
 */

/*
 * # 풀이
 * 1. 이 문제는 소수점까지 출력해야 하기 때문에 정답을 저장할 변수의 자료형은 double이나 float을 사용해야 한다.
 * 그래서 그냥 입력 받을 때부터 자료형을 모두 double로 맞춰주었다.
 * 
 * 2. 주어지는 시험 점수의 개수만큼의 크기를 가진 배열을 선언하고 시험 점수들을 저장해 주는데 시간 절약을 위해
 * 시험 점수들을 입력 받으면서 최대값도 함께 구한다.
 * 
 * 3. 시험 점수들을 새로운 계산법을 이용한 점수로 바꿔야 하기 때문에 시험 점수 배열을 순회하면서 문제에서 주어진 새 계산법으로 계산해서 바꾼다.
 * 
 * 4. 새 점수들의 평균을 구하기 위해 시험 점수 배열을 다시 순회하면서 모두 더한 다음 N으로 나눈 평균을 출력한다.
 *  
 */

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입출력 시간을 줄이기 위해 버퍼 입출력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(bf.readLine()); // 시험 본 과목의 개수
		double input[] = new double[N]; // 시험 점수들을 저장할 배열
		double maxVal = 0; // 시험 점수 중 최대값
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		// 1. 입력 받으면서 최대값도 구하기
		for (int i = 0; N > i; i++)
		{
			input[i] = Double.parseDouble(st.nextToken());
			if (maxVal < input[i]) maxVal = input[i];
		}
		
		// 2. 시험 점수 배열을 순회하면서 새 점수 계산법으로 바꾸기
		for (int i = 0; N > i; i++)
			input[i] = input[i] / maxVal * 100;
		
		// 3. 새로운 점수들의 평균 구하기
		double ans = 0;
		for (int i = 0; N > i; i++)
			ans += input[i];
		
		ans /= N;
		bw.write(Double.toString(ans));
		
		bw.close();
		
	}
	
}
