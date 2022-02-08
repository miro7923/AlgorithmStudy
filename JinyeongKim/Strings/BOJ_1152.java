/*
* # 문제 주소
* https://www.acmicpc.net/problem/1152
*
* # 문제
* 영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오. 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.
*
* # 제한
* 시간 제한 : 2초 / 메모리 제한 / 128 MB
*
* # 입력
* 첫 줄에 영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열의 길이는 1,000,000을 넘지 않는다. 단어는 공백 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다.
* 또한 문자열은 공백으로 시작하거나 끝날 수 있다.
*
* # 출력
* 첫째 줄에 단어의 개수를 출력한다.
*
*/

/*
* # 풀이
* 원래는 String 타입으로 받고 trim()으로 앞뒤 공백 제거 후 split(" ")으로 잘라 배열에 넣어서 배열 길이를 출력하려고 했으나, 공백 하나만 입력받는 경우 1이 출력되서 실패.
* 그래서 StringTokenizer 타입으로, 입력받을 때부터 공백 기준으로 자른 뒤 토큰의 갯수를 출력.
*/

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");    //공백 기준으로 입력받은 문자열 자름
    	
    	bw.write(st.countTokens() + "\n");    //String 토큰 갯수 출력
        bw.flush();
    	bw.close();
	}
}
