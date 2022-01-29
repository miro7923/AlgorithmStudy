/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/15596
 * 
 * # 문제
 * 정수 n개가 주어졌을 때, n개의 합을 구하는 함수를 작성하시오.
 * 
 * 작성해야 하는 함수는 다음과 같다.
 * 
 * Java: long sum(int[] a); (클래스 이름: Test)
 * 	a: 합을 구해야 하는 정수 n개가 저장되어 있는 배열 (0 ≤ a[i] ≤ 1,000,000, 1 ≤ n ≤ 3,000,000)
 * 	리턴값: a에 포함되어 있는 정수 n개의 합
 * 
 * # 제한
 * 시간 제한 : 0.1초, 메모리 제한 : 512 MB
 * 
 */

/*
 * # 풀이
 * 제출란에 만들어져 있는 함수 형태에서 누적합계 구하는 부분만 구현
 * 
 */

public class Test {
    long sum(int[] a) {
        long ans = 0;
		for (int i = 0; a.length > i; i++)
			ans += a[i];
        return ans;
    }
}