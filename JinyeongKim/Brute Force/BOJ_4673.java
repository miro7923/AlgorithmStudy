/*
* # 문제 주소
* https://www.acmicpc.net/problem/4673
*
* # 문제
* 셀프 넘버는 1949년 인도 수학자 D.R. Kaprekar가 이름 붙였다. 양의 정수 n에 대해서 d(n)을 n과 n의 각 자리수를 더하는 함수라고 정의하자. 예를 들어, d(75) = 75+7+5 = 87이다.
* 양의 정수 n이 주어졌을 때, 이 수를 시작해서 n, d(n), d(d(n)), d(d(d(n))), ...과 같은 무한 수열을 만들 수 있다. 
* 예를 들어, 33으로 시작한다면 다음 수는 33 + 3 + 3 = 39이고, 그 다음 수는 39 + 3 + 9 = 51, 다음 수는 51 + 5 + 1 = 57이다. 이런식으로 다음과 같은 수열을 만들 수 있다.
* 33, 39, 51, 57, 69, 84, 96, 111, 114, 120, 123, 129, 141, ...
* n을 d(n)의 생성자라고 한다. 위의 수열에서 33은 39의 생성자이고, 39는 51의 생성자, 51은 57의 생성자이다. 생성자가 한 개보다 많은 경우도 있다.
* 예를 들어, 101은 생성자가 2개(91과 100) 있다. 생성자가 없는 숫자를 셀프 넘버라고 한다. 100보다 작은 셀프 넘버는 총 13개가 있다. 1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97
* 10000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
*
* # 제한
* 시간 제한 : 1초 / 메모리 제한 : 256 MB
*
* # 입력
* 입력은 없다.
*
* # 출력
* 10,000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 증가하는 순서로 출력한다.
*
*/

public class Main{
    public static void main(String[] args){
    	boolean[] arr = new boolean[10001];     //생성자가 있으면 true, 없으면 false로 구분하기 위해 boolean 타입 배열 선언
    	
    	for(int i=1; i<10001; i++) {
    		int n = sum(i);     //sum(i)의 리턴값을 n에 저장
    			
    		if(n < 10001) {
    			arr[n] = true;     //10000이 넘는 수는 제외시키고 생성자가 있는 수의 인덱스를 true로 저장
    		}
    	}
    	for(int i=1; i<10001; i++) {
    		if(arr[i] == false) {
    			System.out.println(i);     //생성자가 없는 인덱스(false)만 출력
    		}
    	}
    	
    }
    
    public static int sum(int a) {     //함수를 사용하여 생성자가 없는 숫자들을 sum으로 return
		int sum = a;     //sum에 생성자가 되는 a를 대입
		
		while(a>0) {     //a의 1의 자리를 뽑아 sum에 더하고 a를 10으로 나눈 뒤 1의 자리를 뽑음(반복)
			sum = sum + a%10;
			a /= 10;
		}
		return sum;
	}
}