/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/4344
 * 
 * # 문제
 * 대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
 * 
 * # 제한
 * 시간 제한 : 1초, 메모리 제한 : 256 MB
 * 
 * # 입력
 * 첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
 * 둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 
 * 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
 * 
 * # 출력
 * 각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
 * 
 */

/*
 * # 풀이
 * 문제에서 주어진대로 각 테스트 케이스별로 학생들의 점수를 배열에 저장한 뒤 그 점수들의 평균을 구한 다음 평균을 초과하는 학생의 비율을 구하면 된다.
 * 처음엔 평균을 넘는다는 의미가 이상이라고 생각했지만 결과를 보니까 초과였음...
 * 평균을 넘는 학생들의 비율은 
 * 평균을 넘는 학생 수 / 전체 학생 수 * 100 으로 구할 수 있는데,
 * 이 문제는 소수점 셋째자리까지 출력해야 하기 때문에 정답을 저장할 변수의 자료형은 double로 사용한다. 
 * 그래서 (평균을 넘는 학생 수 / 전체 학생 수 * 100.0) 을 해줘야 자바가 보다 정확한 결과를 계산한다. 
 * 입출력 시간 단축을 위해 버퍼 입출력을 사용하고 있기 때문에 출력할 땐 String.format("%.3f", ans) 를 통해 셋째자리까지만 출력하도록 했다.
 * 
 */

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입출력 시간을 줄이기 위해 버퍼 입출력 사용
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int C = Integer.parseInt(bf.readLine()); // 테스트 케이스의 개수
		for (int i = 0; C > i; i++)
		{
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 학생의 수
			int input[] = new int[N]; // 학생들의 점수를 저장할 배열
			double avg = 0; // 학생들의 점수 평균
			for (int j = 0; N > j; j++)
			{
				input[j] = Integer.parseInt(st.nextToken());
				avg += input[j];
			}
			
			avg /= N;
			
			int cnt = 0; // 평균을 넘는 학생들의 수
			for (int j = 0; N > j; j++)
			{
				if (avg < input[j]) cnt++;
			}
			
			double ans = (double)cnt / N * 100.0; // 평균을 넘는 학생들의 비율
			
			bw.write(String.format("%.3f", ans) + "%\n");
			
			bw.flush();
		}
		
		bw.close();
		
	}
	
}
