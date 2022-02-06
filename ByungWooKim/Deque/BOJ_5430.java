/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/5430
 *
 * # 문제
 * 선영이는 주말에 할 일이 없어서 새로운 언어 AC를 만들었다. AC는 정수 배열에 연산을 하기 위해 만든 언어이다. 이 언어에는 두 가지 함수 R(뒤집기)과 D(버리기)가 있다.
 * 함수 R은 배열에 있는 수의 순서를 뒤집는 함수이고, D는 첫 번째 수를 버리는 함수이다. 배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.
 * 함수는 조합해서 한 번에 사용할 수 있다. 예를 들어, "AB"는 A를 수행한 다음에 바로 이어서 B를 수행하는 함수이다. 예를 들어, "RDD"는 배열을 뒤집은 다음 처음 두 수를 버리는 함수이다.
 * 배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 1 초 / 메모리 제한: 	256 MB
 *
 * # 입력
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 최대 100이다.
 * 각 테스트 케이스의 첫째 줄에는 수행할 함수 p가 주어진다. p의 길이는 1보다 크거나 같고, 100,000보다 작거나 같다.
 * 다음 줄에는 배열에 들어있는 수의 개수 n이 주어진다. (0 ≤ n ≤ 100,000)
 * 다음 줄에는 [x1,...,xn]과 같은 형태로 배열에 들어있는 정수가 주어진다. (1 ≤ xi ≤ 100)
 * 전체 테스트 케이스에 주어지는 p의 길이의 합과 n의 합은 70만을 넘지 않는다.
 *
 *
 * # 출력
 * 각 테스트 케이스에 대해서, 입력으로 주어진 정수 배열에 함수를 수행한 결과를 출력한다. 만약, 에러가 발생한 경우에는 error를 출력한다.
 *
 *
 * # 풀이
 * 우선 입력받은 정수의 배열(inputIntArr)을 파싱( "[,]" 제거 )한 문자들을 deque에 넣는다. ex) [1,2,3,4] => (1) (2) (3) (4)
 *
 * 함수P(ex)RDD)를 순회하여 D의 개수를 센다. 만약 개수가 입력받는 정수의 배열(inputIntArr)의 크기 n을 넘어가면 error를 출력한다.
 *
 * 함수P에서 R이 나올때마다 boolean(isReverse)값을 바꿔준다. isReverse는 새로운 정수배열들을 입력받을때마다 false로 초기화 해놓는다.
 * 함수P에서 D가 나오면 isReverse인지를 체크하여
 * true이면 deque에 들어간 마지막 원소를 제거해준다. ex) (1) (2) (3) (4) => (1) (2) (3)
 * flase이면 deque에 들어간 첫번째 원소를 제거해준다. ex) (2) (3) (4) => (2) (3)
 * 이러한 작업을 함수P 문자열 끝까지 해준다.
 *
 * deque의 크기가 0이라는 것은 출력할 배열이 빈 배열이라는 것을 의미하고 따라서 "[]"를 출력한다.
 * deque의 크기가 0이 아닐 떄엔 isReverse가
 * true이면 deque의 원소들을 거꾸로 뽑아서 파싱( [ , ] 다시 추가 )하여 출력한다.
 * flase이면 deque의 원소들을 순서대로 뽑아서 파싱( [ , ] 다시 추가 )하여 출력한다.
 *
 *
 * # 배운 것과 놓쳤던 것들
 * 1. 처음에 아무생각 없이 StringBuilder를 썼고, StringBuilder의 reverse()메서드를 R함수가 나올때마다 마구잡이로 사용했다.
 * 그러나 reverse()메서드는 시간복잡도가 O(n)이었고 시간복잡도(컴퓨터는 1초에 1억번 연산가능)를 최대의 케이스로 계산을 해보면
 * P의 길이가 10만이고 배열의 길이가 10만이면 10만 * 10만 인 100억 => 100초라는 무시무시한 시간이 나온다..
 * 따라서 reverse()메서드를 남발해선 안됐고, 뒤집혀있는지 아닌지를 판별해줄 boolean값과 뒤에서 정수 하나를 제거하는 방법과 앞에서 정수 하나를 제거하는 방법을 같이 이용하면 된다는 걸 알았따.
 * 
 * 2. reverse()메서드를 남발하지 않았으나 "틀렸습니다"가 나왔다. 문제와 관련된 FAQ를 보니 두자리수에 대한 언급이 있었다.
 * StringBuilder로 이 문제를 풀려했을 때의 단점이 나왔다... StringBuildr로 자유롭게 앞에서 한개 뒤에서 한개를 제거하는 것은 한 자리 수 일 때만 가능했다.
 * 두 자리 수인 원소들도 한 자리 수만 제거되었기 때문에 틀렸던 것이었다.
 *
 * 3. deque를 안쓰고 StringBuilder로는 해결하지 못했기에 결국 deque를 처음 써보았고, 미리 StringBuilder로 구현된 로직들을 deque로 바꾸면 되었기에 간단히 해결되었다.
 * 그러나 백준에서 컴파일 에러가 났었는데 이건 deque를 java8 버전에서는 지원하지 않았기 때문이었다. 그래서 java11 버전으로 바꾸니 정답이 되었다.
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class BOJ_5430 {
    static int n;
    static String inputIntArr, functionP, answer;
    static StringBuilder sb = new StringBuilder();
    static Deque<String> deque = new ArrayDeque<>();

    private static String calculate() {
        boolean isReverse = false; // 뒤집혀 있는지 아닌지 체크해주는 boolean 값. 

        if (isError()) {
            return "error";
        }

        for(int j = 0; j< functionP.length(); j++){
            if(functionP.charAt(j) == 'R'){
                isReverse = !isReverse;
            }
            if(functionP.charAt(j) == 'D'){
                if(isReverse){
                    deque.removeLast(); // deque에서 마지막 원소 제거!
                }else{
                    deque.removeFirst(); // deque에서 첫번째 원소 제거!
                }
            }
        }

        if(deque.size() == 0){
            return "[]";
        }

        if(isReverse){
            sb.append("[");
            Iterator<String> reverseIter = deque.descendingIterator(); //deque를 거꾸로 순회하는 Iterator
            while (reverseIter.hasNext()){
                String elem = reverseIter.next();
                sb.append(elem).append(",");
            }

            sb.deleteCharAt(sb.length()-1).append("]");
        }

        if(!isReverse){
            sb.append("[");
            for(String elem : deque){
                sb.append(elem).append(",");
            }
            sb.deleteCharAt(sb.length()-1).append("]");
        }

        return sb.toString();
    }

    static boolean isError() {  // 에러를 출력해야하는지 아닌지를 판별해주는 함수
        int count = 0;
        for (int i = 0; i < functionP.length(); i++) { // D의 개수가 입력받은 정수배열 크기 보다 크다면 error이다.
            if (functionP.charAt(i) == 'D')
                count++;
            if (count > n)
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            functionP = br.readLine();
            n = Integer.parseInt(br.readLine());
            inputIntArr = br.readLine();

            // 입력받은 정수 배열들을 파싱하는 작업
            inputIntArr = inputIntArr.substring(1, inputIntArr.length() - 1);
            deque.addAll(List.of(inputIntArr.split(",")));

            // calculate()메서드를 이용해 정답 출력
            answer = calculate();
            System.out.println(answer);

            // 사용했던 deque와 StringBuilder를 초기화
            sb.setLength(0);
            deque.clear();
        }
    }
}
