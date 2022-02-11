/*
* # 문제 주소
* https://www.acmicpc.net/problem/10809
*
* # 문제
* 알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
*
* # 제한
* 시간 제한 : 1초 / 메모리 제한 : 256 MB
*
* # 입력
* 첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
*
* # 출력
* 각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.
* 만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다. 단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.
*
*/

/*
* # 풀이
* 알파벳 26자를 담는 배열을 먼저 생성하고, 반복문(0 ~ 25)을 돌리면서 입력받은 문자열 내에 알파벳들(a ~ z)이 있는지 확인.
* indexOf()는 해당 문자가 존재하는 첫 번째 위치만 반환하므로, 만약 결과가 0 이상이라면 알파벳 배열에 위치값 초기화.
* (a는 배열 0번 인덱스, b는 1번 인덱스, ... z는 25번 인덱스에 각 위치값 초기화하고 위치값 없으면 -1 초기화)
*/

import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
      String s = br.readLine();
      int[] alp = new int[26];    //출력을 위해 알파벳 갯수만큼 배열 생성
    	
      for(int i=0; i<alp.length; i++) {
    		
        alp[i] = -1;    //기본적으로 모든 배열 인덱스에 -1 초기화
    		
        if(s.indexOf((char)(i+97)) >= 0) {
          alp[i] = s.indexOf((char)(i+97));    //a ~ z는 아스키 코드로 97 ~ 122 이므로, indexOf(알파벳)이 0 이상이면 해당 알파벳의 배열 인덱스에 위치값으로 다시 초기화
        }
      }
    	
      for(int i=0; i<alp.length; i++) {
        System.out.print(alp[i] + " ");    //모든 배열 인덱스를 공백으로 구분해서 출력
      }
    }
}
