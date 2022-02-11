/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/4949
 *
 * 문제
 * 세계는 균형이 잘 잡혀있어야 한다. 양과 음, 빛과 어둠 그리고 왼쪽 괄호와 오른쪽 괄호처럼 말이다.
 * 정민이의 임무는 어떤 문자열이 주어졌을 때, 괄호들의 균형이 잘 맞춰져 있는지 판단하는 프로그램을 짜는 것이다.
 * 문자열에 포함되는 괄호는 소괄호("()") 와 대괄호("[]")로 2종류이고, 문자열이 균형을 이루는 조건은 아래와 같다.
 * - 모든 왼쪽 소괄호("(")는 오른쪽 소괄호(")")와만 짝을 이뤄야 한다.
 * - 모든 왼쪽 대괄호("[")는 오른쪽 대괄호("]")와만 짝을 이뤄야 한다.
 * - 모든 오른쪽 괄호들은 자신과 짝을 이룰 수 있는 왼쪽 괄호가 존재한다.
 * - 모든 괄호들의 짝은 1:1 매칭만 가능하다. 즉, 괄호 하나가 둘 이상의 괄호와 짝지어지지 않는다.
 * - 짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야 한다.
 * 정민이를 도와 문자열이 주어졌을 때 균형잡힌 문자열인지 아닌지를 판단해보자.
 *
 *
 * # 제한
 * 시간제한: 1 초 / 메모리 제한: 128 MB
 *
 * # 입력
 * 하나 또는 여러줄에 걸쳐서 문자열이 주어진다. 각 문자열은 영문 알파벳, 공백, 소괄호("( )") 대괄호("[ ]")등으로 이루어져 있으며, 길이는 100글자보다 작거나 같다.
 * 입력의 종료조건으로 맨 마지막에 점 하나(".")가 들어온다.
 *
 *
 * # 출력
 * 각 줄마다 해당 문자열이 균형을 이루고 있으면 "yes"를, 아니면 "no"를 출력한다.
 *
 * # 풀이
 * stack 자료구조를 이용하여 문장들을 탐색하여 '('나 '['가 나오면 stack에 넣는다.
 * ')'나 ']'가 나오면 stack에서 빼야하는데 이 때 ')'가 나오면 stack의 제일 위에 있는 문자가 '(' 일경우에는 꺼내고 그렇지 않으면 "no"를 출력한다.
 * ']'가 나오면 stack의 제일 위에 있는 문자가 '['일 경우에는 꺼내고 그렇지 않으면 "no"를 출력한다.
 * 위의 작업을 다 한 뒤에 또 stack을 검사해주어야 한다. stack이 아직 남아있는 경우라면 '('나 '['가 ')',']'보다 더 많다는 것이기 때문에 "no"를 출력한다.
 * stack이 비어있다면 균형잡힌 문자열이므로 "yes"를 출력한다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class BOJ_4949 {

    static String sentence;
    static char ch;
    static Stack<Character> stack = new Stack<>();
    static String balanceCheck() { // 균형잡힌 문자열인지 체크하는 메서드
        for (int i = 0; i < sentence.length(); i++) {   // 문장을 순회하면서 괄호가 나오는지 체크한다.
            ch = sentence.charAt(i);

            //여는 괄호들은 스택에 넣어준다.
            if (ch == '(')
                stack.push('(');
            else if (ch == '[')
                stack.push('[');
            //닫는 괄호들은 스택위의 괄호가 소괄호인지 대괄호인지를 체크하여 꺼낼지 그리고 no를 출력할지를 결정한다.
            else if (ch == ']') {
                if (!stack.empty()) {
                    if (stack.peek() == '[') {
                        stack.pop();
                        continue;
                    } else {
                        return "no";
                    }
                } else {
                    return "no";
                }
            }
            else if (ch == ')') {
                if (!stack.empty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return "no";
                    }
                } else {
                    return "no";
                }
            }
        }

        // 여는괄호들이 더 많으면 stack에는 아직 데이터가 남아있을 것이다. 따라서 stack이 비어야 yes를 출력하고 비어있지 않으면 no를 출력한다.
        if (stack.empty()) {
            return "yes";
        } else {
            return "no";
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sentence = br.readLine();
        while (!sentence.equals(".")) { // 문장이 "."이 나오면 입력받는 것을 종료해준다.
            System.out.println(balanceCheck());
            stack.clear(); // 한 문장씩 검사할 때마다 stack 초기화
            sentence = br.readLine();
        }
    }
}
