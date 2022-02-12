import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869 {

	public static void main(String[] args) throws IOException {

		/*
		 * 문제 땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
		 * 
		 * 달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
		 * 
		 * 달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
		 * 
		 * 입력 첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)
		 * 
		 * 출력 첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.
		 * 
		 */
		
		// 풀이 : A 올라가고 B 내려오는걸 반복하다 정상에 도착한 순간에는 올라가기만하고 내려갈필요없음 
		// 입력값이 10억이고 풀이시간이 0.15초내이므로 단순한 반복문으로는 시간초과될것
		// 하루에 올라가는 양은 A-B이고, 총 올라갈 거리 - 미끄러지는 거리를 하루에 올라가고 미끄러진거리의 나머지가
		// 나누어 떨어지는 경우 마지막날 올라가면 끝, 나누어떨어지지 않으면 좀 더 올라갈 거리가 남은것이므로
		// 하루 더해주고 출력
		// 딱 나누어 떨어지는 경우 
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String A = st.nextToken();
		String B = st.nextToken();
		String V = st.nextToken();
		
		int day_up = Integer.parseInt(A) - Integer.parseInt(B);
		int length = Integer.parseInt(V) - Integer.parseInt(B);
		int day =length/day_up;
		
		if(length%day_up != 0) { // 나누어 떨어지지 않는경우
			day++;
		}
		
		System.out.println(day);
		
	}
}
