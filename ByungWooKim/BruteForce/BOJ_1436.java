/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/1436
 *
 * # 문제
 * 666은 종말을 나타내는 숫자라고 한다. 따라서, 많은 블록버스터 영화에서는 666이 들어간 제목을 많이 사용한다.
 * 영화감독 숌은 세상의 종말 이라는 시리즈 영화의 감독이다. 조지 루카스는 스타워즈를 만들 때, 스타워즈 1, 스타워즈 2, 스타워즈 3, 스타워즈 4, 스타워즈 5, 스타워즈 6과 같이 이름을 지었고, 피터 잭슨은 반지의 제왕을 만들 때, 반지의 제왕 1, 반지의 제왕 2, 반지의 제왕 3과 같이 영화 제목을 지었다.
 * 하지만 숌은 자신이 조지 루카스와 피터 잭슨을 뛰어넘는다는 것을 보여주기 위해서 영화 제목을 좀 다르게 만들기로 했다.
 * 종말의 숫자란 어떤 수에 6이 적어도 3개이상 연속으로 들어가는 수를 말한다. 제일 작은 종말의 숫자는 666이고, 그 다음으로 큰 수는 1666, 2666, 3666, .... 과 같다.
 * 따라서, 숌은 첫 번째 영화의 제목은 세상의 종말 666, 두 번째 영화의 제목은 세상의 종말 1666 이렇게 이름을 지을 것이다. 일반화해서 생각하면, N번째 영화의 제목은 세상의 종말 (N번째로 작은 종말의 숫자) 와 같다.
 * 숌이 만든 N번째 영화의 제목에 들어간 숫자를 출력하는 프로그램을 작성하시오. 숌은 이 시리즈를 항상 차례대로 만들고, 다른 영화는 만들지 않는다.
 *
 * # 제한
 * 시간제한: 2 초 / 메모리 제한:  	128 MB
 *
 * # 입력
 * 첫째 줄에 숫자 N이 주어진다. N은 10,000보다 작거나 같은 자연수이다.
 *
 * # 출력
 * 첫째 줄에 N번째 영화의 제목에 들어간 수를 출력한다.
 *
 * # 풀이
 * 앞자리의 숫자 5까지는 1666 -> 2666 -> 3666 이런식으로 증가하다가 6부터는 6660 -> 6661 ~ 6669까지 증가한다
 * 그리고 앞자리의 숫자가 66일 때는 66600 ~ 66699 이런 식으로 증가한다.
 * 규칙을 잘 보면 앞자리의 숫자가 6으로 끝나는지, 66으로 끝나는지, 666으로 끝나는 지에 따라 6을 붙여줘야할 개수는 다르다.
 * 앞자리의 숫자가 6으로 끝나면 6을 2개 66으로 끝나면 6을 1개 666으로 끝나면 6을 0개 붙이면 된다. 
 * 
 * 뒷자리의 숫자는 6을 몇개 붙이냐에 따라 달라지는데 
 * 6을 붙이지 않을 경우에는 뒷자리의 숫자는 0 ~ 9까지 올 수 있고
 * 6을 1개 붙일 경우 뒷자리의 숫자는 0 ~ 999까지 올 수 있다.
 * 6을 2개 붙일 경우 뒷자리의 숫자는 0 ~ 99까지 올 수 있고
 * 6을 3개 붙일 경우 뒷자리의 숫자는 올 수 없다.
 * 
 * 위의 규칙을 이용하여
 * 영화제목이 들어갈 N개의 배열을 만들고 배열에 각각 0부터 N까지 영화제목을 계산하여 넣는다.
 *
 * # 개선해야할 점
 * 코드의 길이가 너무 길고 반복되는 부분이 있는 것 같다. 좀 더 최적화 시킬 방법을 생각해보아야 할 거 같다..
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436 {

    static int N;
    static String[] titles; // N개의 영화제목들이 들어갈 배열
    static StringBuilder sb = new StringBuilder();
    static String[] addSix = {"666", "66", "6", ""};    // 6을 몇 개 더해야 하는지 체크할 배열

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        titles = new String[N];
        titles[0] = "666";  // 1번째 영화제목은 666으로 시작한다.
    }

    static void pro() {
        int frontNum = 1;   // 앞자리의 숫자
        int rearNum = 0;    // 뒷자리의 숫자 
        int addIdx = 0;     // 6을 몇개를 더해야하는지
        int idx = 1;    // idx 번째 영화제목
        while (titles[N - 1] == null) { // N-1번째의 영화제목을 구할 떄 까지 반복.
            sb.append(frontNum);
            // 앞자리의 숫자가 6으로 끝나는지 66으로 끝나는지 666으로 끝나는지 체크할 반복문.
            for (int i = sb.length() - 1; i >= 0; i--) {    
                if (sb.charAt(i) == '6' && addIdx < 3) addIdx++;
                else break;
            }
            // 위의 반복문을 통과하면 몇개의 6을 붙여야 할지 알 수 있고 그 개수만큼 6을 붙여준다.
            sb.append(addSix[addIdx]);

            // 6을 몇개 붙이냐에 따라서 뒷자리의 숫자를 붙이는 방법이 다르다.
            if (addIdx == 0) {  // 6을 3개 붙여야 하면 뒷자리의 숫자는 붙이지 못하고 앞자리의 수를 증가
                frontNum++;
            } 
            else if (addIdx == 1) {   // 6을 2개 붙여야 할 경우
                if (rearNum > 9) {  // 뒷자리의 숫자는 9까지 올 수 있음.
                    // 뒷자리의 수가 9를 넘어가면 초기화와 앞자리의 수를 증가
                    frontNum++;     rearNum = 0;
                    sb.setLength(0);    addIdx = 0; 
                    continue;
                }
                
                sb.append(rearNum); // 뒷자리의 수 추가
                rearNum++;
            } 
            else if (addIdx == 2) {
                if (rearNum > 99) {
                    frontNum++;     rearNum = 0;
                    sb.setLength(0);    addIdx = 0;
                    continue;
                }
                
                // 66601이 경우 이 조건이 없으면 6661이 된다. 
                // 즉, 00, 01, 02 이런 경우들 때문에 0을 먼저 더해주고 뒷자리의 수를 더해줘야함. 
                if (rearNum < 10) sb.append(0); 
                    
                sb.append(rearNum);
                rearNum++;
            } 
            else if (addIdx == 3) {
                if (rearNum > 999) {
                    frontNum++;     rearNum = 0;
                    sb.setLength(0);    addIdx = 0;
                    continue;
                }
                
                if (rearNum < 10) sb.append("00");
                
                if (rearNum < 100) sb.append("0");
                
                sb.append(rearNum);
                rearNum++;
            }

            titles[idx] = sb.toString();
            idx++;
            sb.setLength(0);
            addIdx = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
        System.out.println(titles[N - 1]);  // 영화제목의 마지막 index에서 답을 구할 수 있다.
    }
}
