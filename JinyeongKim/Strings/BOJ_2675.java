/*
* # 문제 주소
* https://www.acmicpc.net/problem/2675
*
* # 문제
* 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오. 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다.
* S에는 QR Code "alphanumeric" 문자만 들어있다. QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.
*
* # 제한
* 시간 제한 : 1초 / 메모리 제한 : 128 MB
*
* # 입력
* 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다. S의 길이는 적어도 1이며, 20글자를 넘지 않는다.
*
* # 출력
* 각 테스트 케이스에 대해 P를 출력한다.
*
*/

/*
* # 풀이
* 문자열(s)을 입력받으면 charAt()을 통해 한 글자씩 잘라 반복 횟수(b)만큼 반복[반복문]하여 String 타입 변수에 더한다.
* 중첩 for문으로 문자열 길이만큼 위 과정을 반복한다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int a = Integer.parseInt(br.readLine());
    	
    	for(int i=0; i<a; i++) {    //a개 만큼 테스트 케이스를 반복하여 입력받음
    	  String result = "";    //각 테스트 케이스 시작 전에 result를 빈 문자열로 초기화
    		
    	  StringTokenizer st = new StringTokenizer(br.readLine());
    	  int b = Integer.parseInt(st.nextToken());
    	  String s = st.nextToken();
    		
    	  for(int j=0; j<s.length(); j++) {    //문자열(s) 길이만큼 반복
    	    for(int k=0; k<b; k++) {
    	      result += s.charAt(j);    //charAt()으로 자른 한 글자씩 횟수(b)만큼 반복하여 result에 추가
    	    }
    	  }
    	  System.out.println(result);
    	}
    }
}
