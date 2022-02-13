/*
* # 문제 주소
* https://www.acmicpc.net/problem/1259
*
* # 문제
* 어떤 단어를 뒤에서부터 읽어도 똑같다면 그 단어를 팰린드롬이라고 한다. 'radar', 'sees'는 팰린드롬이다.
* 수도 팰린드롬으로 취급할 수 있다. 수의 숫자들을 뒤에서부터 읽어도 같다면 그 수는 팰린드롬수다. 121, 12421 등은 팰린드롬수다. 123, 1231은 뒤에서부터 읽으면 다르므로 팰린드롬수가 아니다.
* 또한 10도 팰린드롬수가 아닌데, 앞에 무의미한 0이 올 수 있다면 010이 되어 팰린드롬수로 취급할 수도 있지만, 특별히 이번 문제에서는 무의미한 0이 앞에 올 수 없다고 하자.
*
* # 제한
* 시간 제한 : 1초 / 메모리 제한 : 128 MB
*
* # 입력
* 입력은 여러 개의 테스트 케이스로 이루어져 있으며, 각 줄마다 1 이상 99999 이하의 정수가 주어진다. 입력의 마지막 줄에는 0이 주어지며, 이 줄은 문제에 포함되지 않는다.
*
* # 출력
* 각 줄마다 주어진 수가 팰린드롬수면 'yes', 아니면 'no'를 출력한다.
*
*/

/*
* # 풀이
* 무한루프 while문을 만들어서 입력값을 계속 받고 입력값이 0일 때 break.
* 입력값(a)을 StringBuilder 타입으로 변환, reverse()로 문자열 뒤집고 다시 String 타입으로 변환하여 다른 변수(b)에 저장.
* 처음에는 a와 b를 string 타입 그대로 비교했으나 실패, 둘 다 int 타입으로 변환하여 비교함.
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	while(true) {
    	  StringTokenizer st = new StringTokenizer(br.readLine());
    	  String a = st.nextToken();
    	  String b = new StringBuilder(a).reverse().toString();    //a 문자열을 뒤집어서 초기화
    		
    	  if(Integer.parseInt(a)==0) {    //입력값이 0이면 무한루프 빠져나가고 종료
    	    break;
    	  }
    	  else if(Integer.parseInt(a)==Integer.parseInt(b)) {    //a와 b를 int 타입으로 변환해서 서로 같으면 yes 출력
    	    System.out.println("yes");
    	  }
    	  else {
    	    System.out.println("no");
    	  }
    	}
    }
}
