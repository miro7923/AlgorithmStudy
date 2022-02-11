/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/4673
 *
 * # 문제
 *
 * 셀프 넘버는 1949년 인도 수학자 D.R. Kaprekar가 이름 붙였다. 양의 정수 n에 대해서 d(n)을 n과 n의 각 자리수를 더하는 함수라고 정의하자. 예를 들어, d(75) = 75+7+5 = 87이다.
 * 양의 정수 n이 주어졌을 때, 이 수를 시작해서 n, d(n), d(d(n)), d(d(d(n))), ...과 같은 무한 수열을 만들 수 있다.
 * 예를 들어, 33으로 시작한다면 다음 수는 33 + 3 + 3 = 39이고, 그 다음 수는 39 + 3 + 9 = 51, 다음 수는 51 + 5 + 1 = 57이다. 이런식으로 다음과 같은 수열을 만들 수 있다.
 * 33, 39, 51, 57, 69, 84, 96, 111, 114, 120, 123, 129, 141, ...
 * n을 d(n)의 생성자라고 한다. 위의 수열에서 33은 39의 생성자이고, 39는 51의 생성자, 51은 57의 생성자이다. 생성자가 한 개보다 많은 경우도 있다. 예를 들어, 101은 생성자가 2개(91과 100) 있다.
 * 생성자가 없는 숫자를 셀프 넘버라고 한다. 100보다 작은 셀프 넘버는 총 13개가 있다. 1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97
 * 10000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 1 초 / 메모리 제한: 	256 MB
 *
 * # 입력
 * 입력은 없다.
 *
 *
 * # 출력
 * 10,000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 증가하는 순서로 출력한다.
 *
 *
 * # 풀이
 * 1부터 10000까지 모두 탐색하며 새로운 수 newNum을 만들어 낸다.
 * 셀프넘버인지 체크하는 boolean 배열(isNotSelfNum) 10001의 크기로 만들어 생성자를 통해 만들어진 수 newNum 인덱스에는 true값을 넣어 셀프넘버가 아니라는 걸 체크 한다.
 * newNum을 만드는 로직은 한 정수와 그 정수의 각 자리수의 합이다.
 * ex) 13으로 만들 수 있는 newNum은
 * 13 + 1 + 3 = 17이다.
 * 즉 isNotSelfNum 배열의 17번째 인덱스는 true가 되며 즉 17은 셀프넘버가 아니라는 걸 확인 할 수 있다.
 * 10000보다 작은 셀프넘버를 구하라고 했기 때문에 불필요하게 newNum이 10000을 넘어가면 continue를 이용해 그 다음 수부터 탐색하게 한다.
 * 셀프넘버인지 체크하는 로직이 끝나면 isNotSelfNum배열을 탐색하면서 false인 index는 셀프넘버이고 따라서 그 수들을 모두 출력하면 된다.
 *
 */

import java.io.IOException;

public class BOJ_4673 {

    static boolean[] isNotSelfNum = new boolean[10001]; // 1부터 10000의 index값을 사용할 것이기 때문에 10001개의 배열을 만든다.

    static void checkSelfNum() {    // 셀프넘버인지 체크하는 메서드
        for (int i = 1; i <= 10000; i++) {
            int newNum = i;
            String num = String.valueOf(i);     // 각 자리의 숫자를 이용하기위해 String으로 변환해서 사용한다.
            for (int j = 0; j < num.length(); j++) {
                int charToInt = num.charAt(j) - 48; // char를 숫자로 표현하기 위해서는 48을 빼줘야 한다. ex) '5' - 48 = 5
                newNum += charToInt;    // newNum은 = i(양의 정수) + charToInt(각 자리수)
            }

            if (newNum > 10000)
                continue;

            isNotSelfNum[newNum] = true;    // 위의 로직을 통해 만들어진 newNum은 셀프넘버가 아니고 따라서 isNotSelfNum boolean 배열에 체크해준다.
        }

    }

    static void printAnswer() { // isNotSelfNum boolean배열을 순회하면서 false(셀프넘버)이면 출력한다.
        for (int i = 1; i <= 10000; i++) {
            if (!isNotSelfNum[i])
                System.out.println(i);
        }
    }

    public static void main(String[] args) throws IOException {
        checkSelfNum();
        printAnswer();
    }
}
