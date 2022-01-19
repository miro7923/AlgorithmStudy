/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/11720
 * 
 * # 문제
 * N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
 * 
 * # 제한
 * 시간제한: 1초 / 메모리 제한: 256 MB
 * 
 * # 입력
 * 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
 * 
 * # 출력
 * 입력으로 주어진 숫자 N개의 합을 출력한다.
 * 
 */

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
      	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
	int n = Integer.parseInt(br.readLine());
	String s = br.readLine();   //문자열을 입력받아서 charAt으로 한 글자씩 자르는 방식
	int sum = 0;
		
	for(int i=0; i<n; i++) {
		sum += (s.charAt(i) - '0');   //charAt은 아스키코드 값을 리턴하기 때문에 48 또는 '0'을 빼야 원래 값이 됨
	}
	bw.write(sum + "\n");
		
	bw.flush();
	bw.close();
    }
}
