/*
* # 문제 주소
* https://www.acmicpc.net/problem/1065
*
* # 문제
* 어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
* N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 
*
* # 제한
* 시간 제한: 2초 / 메모리 제한: 128 MB
*
* # 입력
* 첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.
*
* # 출력
* 첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
*
*/

import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int n = Integer.parseInt(br.readLine());
        int result = 0;
		
        if(n<100) {     //두 자리 수(99)까지는 각 자리 숫자가 무조건 등차수열
          result = n;
        }
        else {
          result = 99;     //100 이상부터는 한수의 개수가 99 + a
          for(int i=100; i<=n; i++) {
            
            //조건이 1000 이하의 수이기 때문에 유일하게 네 자리 수인 1000은 한수가 아니므로 세 자리까지 계산
            if((i/100)-(i%100)/10 == (i%100)/10-i%10) {     //100의 자리 - 10의 자리 == 10의 자리 - 1의 자리
              result++;     //한수일 때마다 1씩 추가
            }
          }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
