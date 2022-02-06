import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_5430 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		/*
		 * 문제 
		 * 선영이는 주말에 할 일이 없어서 새로운 언어 AC를 만들었다. AC는 정수 배열에 연산을 하기 위해 만든 언어이다. 이 언어에는 두
		 * 가지 함수 R(뒤집기)과 D(버리기)가 있다.
		 * 
		 * 함수 R은 배열에 있는 수의 순서를 뒤집는 함수이고, D는 첫 번째 수를 버리는 함수이다. 배열이 비어있는데 D를 사용한 경우에는 에러가
		 * 발생한다.
		 * 
		 * 함수는 조합해서 한 번에 사용할 수 있다. 예를 들어, "AB"는 A를 수행한 다음에 바로 이어서 B를 수행하는 함수이다. 예를 들어,
		 * "RDD"는 배열을 뒤집은 다음 처음 두 수를 버리는 함수이다.
		 * 
		 * 배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성하시오.
		 * 
		 * 
		 * 입력 
		 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 최대 100이다.
		 * 
		 * 각 테스트 케이스의 첫째 줄에는 수행할 함수 p가 주어진다. p의 길이는 1보다 크거나 같고, 100,000보다 작거나 같다.
		 * 
		 * 다음 줄에는 배열에 들어있는 수의 개수 n이 주어진다. (0 ≤ n ≤ 100,000)
		 * 
		 * 다음 줄에는 [x1,...,xn]과 같은 형태로 배열에 들어있는 정수가 주어진다. (1 ≤ xi ≤ 100)
		 * 
		 * 전체 테스트 케이스에 주어지는 p의 길이의 합과 n의 합은 70만을 넘지 않는다.
		 * 
		 * 출력
		 * 각 테스트 케이스에 대해서, 입력으로 주어진 정수 배열에 함수를 수행한 결과를 출력한다. 만약, 에러가 발생한 경우에는 error를
		 * 출력한다.
		 */
		
		//풀이 : Deque를 사용하여 D를 구현, R은 굳이 구현하지 않아도 앞뒤 값을 꺼내면됨
		
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

		
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 갯수
		
		for(int i=0; i<T; i++) {
			
			String s1 = br.readLine(); // RD 입력
			int s2 = Integer.parseInt(br.readLine()); // 배열갯수
			
			String temp = br.readLine();
			String temp2 = temp.substring(1, temp.length()-1); // 배열 [ ] 제거
			String[] s3 = temp2.split(","); // 배열생성
			
			for(int j=0; j<s2; j++) {
				deque.add(Integer.parseInt(s3[j])); // 덱에 배열 넣기
			}
			AC(s1,deque); // R확인
		}
		
		System.out.println(sb);
		
	}
	
 	static void AC(String s1 , ArrayDeque<Integer> deque) { // R과 D구현
 		
 		boolean isRight = true; // 방향 상태 변수
 		
 	
 		
 		for (char cmd : s1.toCharArray()) {
 			if(cmd == 'R') {
 				isRight = !isRight; // R일때 방향 변경
 				continue; // R이므로 아래 D의경우는 진행안함
 			}
 		
 		// D의경우 (정방향일땐 첫부분부터 꺼내서 제거하므로 pollFirst사용 역방향은 반대로 꺼낼 원소 없으면 error출력
 			
 		if(isRight) {
 			
 			if(deque.pollFirst() == null) { //정방향일때 첫번째 원소 확인 후 null일 경우 에러출력
 				sb.append("error\n");
 				return;
 			}
 		}
 		
 		else {
 			
 			if(deque.pollLast() == null) { //역방향일때 마지막 원소 확인 후 null일 경우 에러출력
 				sb.append("error\n");
 				return;
 			}
 		}
 	}
 		
 		stringmaking(deque, isRight);
 		
}
 	
 	
 	static void stringmaking(ArrayDeque<Integer> deque , boolean isRight){
 		
 		sb.append("["); // 여는 대괄호 저장
 		
 		// 방향에따라 출력
 		
 		if(deque.size() > 0)
 		{
	 		if(isRight) {
	 			sb.append(deque.pollFirst()); // 첫원소 저장
	 			
	 			while(!deque.isEmpty()) { // 두번째 원소부터 "," 추가하여 저장, 더이상 원소 없을경우 종료 
	 				sb.append(",").append(deque.pollFirst());
	 			}
	 		}
	 		
	 		else { // 역방향의 경우
	 			sb.append(deque.pollLast());
	 			
	 			while(!deque.isEmpty()) {
	 				sb.append(",").append(deque.pollLast());
	 			}
	 		}
	 		
	 		}
 		sb.append("]\n"); // 닫는 대괄호 저장
 	}
}

