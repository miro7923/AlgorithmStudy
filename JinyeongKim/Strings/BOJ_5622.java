/*
* # 문제 주소
* https://www.acmicpc.net/problem/5622
*
* # 문제
* 상근이의 할머니는 아래 그림과 같이 오래된 다이얼 전화기를 사용한다. 전화를 걸고 싶은 번호가 있다면, 숫자를 하나를 누른 다음에 금속 핀이 있는 곳 까지 시계방향으로 돌려야 한다.
* 숫자를 하나 누르면 다이얼이 처음 위치로 돌아가고, 다음 숫자를 누르려면 다이얼을 처음 위치에서 다시 돌려야 한다.
* 숫자 1을 걸려면 총 2초가 필요하다. 1보다 큰 수를 거는데 걸리는 시간은 이보다 더 걸리며, 한 칸 옆에 있는 숫자를 걸기 위해선 1초씩 더 걸린다.
* 상근이의 할머니는 전화 번호를 각 숫자에 해당하는 문자로 외운다. 즉, 어떤 단어를 걸 때, 각 알파벳에 해당하는 숫자를 걸면 된다. 예를 들어, UNUCIC는 868242와 같다.
* 할머니가 외운 단어가 주어졌을 때, 이 전화를 걸기 위해서 필요한 최소 시간을 구하는 프로그램을 작성하시오.
*
* # 제한
* 시간 제한 : 1초 / 메모리 제한 : 128 MB
*
* # 입력
* 첫째 줄에 알파벳 대문자로 이루어진 단어가 주어진다. 단어의 길이는 2보다 크거나 같고, 15보다 작거나 같다.
*
* # 출력
* 첫째 줄에 다이얼을 걸기 위해서 필요한 최소 시간을 출력한다.
*
*/

/*
* # 풀이
* 입력받은 알파벳을 아스키 코드(int)로 변환해서 65를 빼면 A는 0, B는 1, ... 이 나온다. 3개씩 묶어야 하므로 모두 3으로 나눠서 나머지에 따라 구분했다.
* 예를 들어 ABC의 경우 (아스키코드값-65)/3 은 0이고, 해당하는 숫자는 3이기 때문에 +3 해준다.
* PQRS는 3개가 아닌 4개라서 S부터 하나씩 밀리게 되어, PQRS / TUV / WXYZ 에서 S, V, Y, Z는 switch-case문을 사용하여 추가로 -1 해준다.
*/

import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String s = br.readLine();
    	char[] arr = new char[s.length()];    //아스키 코드로 바꾸기 위해 먼저 char타입으로 변환
    	
    	int result = 0;
      
    	for(int i=0; i<arr.length; i++) {
    	  arr[i] = s.charAt(i);    //입력받은 값을 한 글자씩 배열에 저장
    		
    	  result += ((int)(arr[i])-65)/3 + 3;    //(아스키코드값)/3 + 3 결과를 result 변수에 더함
    		
    	  switch(arr[i]) {
    	  case 'S':
    	  case 'V':
    	  case 'Y':
    	  case 'Z':
    	    result -= 1; break;    //예외인 4가지 경우에 대해 result 변수 값을 -1
    	  }
    	}
    	System.out.println(result);
    }
}
