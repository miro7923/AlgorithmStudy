/*
* # 문제 주소
* https://www.acmicpc.net/problem/11654
*
* # 문제
* 알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.
*
* # 제한
* 시간 제한 : 1초 / 메모리 제한 : 256 MB
*
* # 입력
* 알파벳 소문자, 대문자, 숫자 0-9 중 하나가 첫째 줄에 주어진다.
*
* # 출력
* 입력으로 주어진 글자의 아스키 코드 값을 출력한다.
*
*/

/*
* # 풀이
* 아스키 코드로 표현하려면 char 타입에서 int 타입으로 변환해야 함
* 한 글자만 입력받기 때문에, 첫 글자를 잘라 char 타입으로 변환하는 charAt(0) 사용
*/

import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String a = br.readLine();
    	int b = (int)a.charAt(0);    //String 타입 -> char 타입 -> int 타입
    	
    	System.out.println(b);
	}
}
