/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/8958
 * 
 * # 문제
 * "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 
 * 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.
 * "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
 * OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
 * 
 * # 제한
 * 시간제한: 1초 / 메모리 제한: 128 MB
 * 
 * # 입력
 * 첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 0보다 크고 80보다 작은 문자열이 주어진다. 문자열은 O와 X만으로 이루어져 있다.
 * 
 * # 출력
 * 각 테스트 케이스마다 점수를 출력한다.
 * 
 */

import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
      int n = Integer.parseInt(br.readLine());
		
      for(int i=0; i<n; i++) {
        String s = br.readLine();   //문자열로 입력받아서 charAt으로 한 글자씩 자르는 방식
        int sum = 0;
        int x = 0;   //'O'가 연속일 때 누적값
			
        for(int j=0; j<s.length(); j++) {
          if(s.charAt(j) == 'O') {
            x++;
          }
          else {
            x = 0;   //'X'를 만나면 누적값 0으로 초기화
          }
          sum += x;
        }
        bw.write(sum + "\n");
      }
      bw.flush();
      bw.close();
   }
}
