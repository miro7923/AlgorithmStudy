/*
 * # 문제 주소
 * https://www.acmicpc.net/problem/2108
 *
 * # 문제
 * 수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.
 * 1. 산술평균 : N개의 수들의 합을 N으로 나눈 값
 * 2. 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 * 3. 최빈값 : N개의 수들 중 가장 많이 나타나는 값
 * 4. 범위 : N개의 수들 중 최댓값과 최솟값의 차이
 * N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
 *
 * # 제한
 * 시간제한: 2 초 / 메모리 제한:  	256 MB
 *
 * # 입력
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다.
 * 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.
 *
 * # 출력
 * 첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
 * 둘째 줄에는 중앙값을 출력한다.
 * 셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
 * 넷째 줄에는 범위를 출력한다.
 *
 * # 풀이
 * 입력받은 숫자들을 따로 nums 배열에 저장한다. 그리고 이 배열을 정렬한다.
 * 산술평균, 중앙값, 범위는 이렇게 정렬한 배열들을 토대로 쉽게 구할 수 있다.
 *
 * 최빈값의 경우 어려워지는데 무작정 한개의 수를 다른 숫자들과 모두 비교해서 count를 올리면 안된다. (시간초과)
 * 수 정렬하기 3에서 했던 방법을 이용하면 시간을 확 줄일 수 있는데 정수의 절대값이 4000을 넘지 않는 제한을 이용하여
 * numsCount라는 8001개의 배열을 만든다. 0부터 양수 4001개와 -1부터 -4000까지 4000개기 때문에 8001개의 배열을 만든다.
 * 그리고 입력받은 수가 몇이냐에 따라 입력받은수에 4000을 더해준다. 배열의 index는 항상 0부터 시작하기 때문에 -4000은 0번 인덱스에 담는다.
 * 그리고 이 배열에서 최대의 값을 가지는 수를 구하고 다시 배열을 순회하면서 최대값을 가지는 수와 같은지 비교한다.
 * isSecond라는 boolean값을 이용하는데 이 값은 처음에 false로 해주고 배열을 순회하면서 최빈값이 나오면 true로 바꿔주고
 * 그 다음에는 isSecond도 true인 최빈값이 나오는데 이 때 최빈값을 바꿔주고 반복문은 종료한다.
 *
 * # 이해가 안되는 점..
 * 처음에는 8001개의 배열이 아닌 따로 양수 배열, 음수배열을 나눠서 했다.
 * 이때에도 문제의 입력값과 출력값은 다 맞았고 질문검색에서도 반례값이 다 맞았다. 그런데 제출하면 항상 61%에서 틀렸다.
 * 아무리 봐도 틀린 로직이 없어보이는데 틀렸다고 나와서 혹시 다른 평균값이나 중앙값이나 범위가 틀렸는지도 계속 봤다.
 * 그러다가 질문게시판을 참고해 최빈값을 구하는 로직을 양수와 음수를 모두 합친 배열로 그전에 이용했던 로직을 똑같이 하니 맞았다..
 * 뭐가 잘못된건지 1시간 30분 정도를 고민하고 바꾸려고 해봤지만 아무리 봐도 잘못된 게 없는 거 같고 반레도 못찾겠어서 포기했다.
 *
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] nums;
    static int[] numsCount;
    static int median, mode, range; // 중앙값, 최빈값, 범위
    static double mean; // 산술평균

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        numsCount = new int[8001];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());

            numsCount[nums[i] + 4000]++;    // 최빈값을 구하기 위해 입력받은 수들이 몇번 등장할지 count할 배열
        }
    }

    static void pro() {
        int maxCount = 0;
        int sum = 0;
        Arrays.sort(nums);  // 범위, 중앙값, 평균을 쉽게 구하기 위해
        median = nums[N / 2];
        range = nums[N - 1] - nums[0];

        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }
        mean = Math.round((double) sum / N);

        for (int i = 0; i < numsCount.length; i++) {
            maxCount = Math.max(maxCount, numsCount[i]);
        }

        boolean isSecond = false;   // 최빈값 중 2번째 값을 체크하기 위한 boolean
        for (int i = 0; i< numsCount.length; i++){
            if (numsCount[i] == maxCount && isSecond) {
                // 최빈값 중 2번째 값일 경우 반복문 종료
                mode = i - 4000;
                break;
            }

            if (numsCount[i] == maxCount){
                mode = i - 4000;
                isSecond = true;
            }
        }


    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
        System.out.println((int) mean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}

/**     아래 코드가 왜 틀렸는지 모르겠다. 로직은 아무리 봐도 다 맞고 질문게시판에 나오는 반례도 다 맞다..
 * for (int i = 1; i <= 4000; i++) {
 *         maxCount = Math.max(maxCount, negativeCount[i]);
 *         }
 *         for (int i = 0; i <= 4000; i++) {
 *         maxCount = Math.max(maxCount, positiveCount[i]);
 *         }
 *
 *         boolean isSecond = false;
 *         for (int i = 4000; i > 0; i--) {
 *         if (negativeCount[i] == maxCount && isSecond) {
 *         mode = -i;
 *         break;
 *         }
 *
 *         if (negativeCount[i] == maxCount) {
 *         mode = -i;
 *         isSecond = true;
 *         }
 *         }
 *
 *         for (int i = 0; i <= 4000; i++) {
 *         if (positiveCount[i] == maxCount && isSecond) {
 *         mode = i;
 *         break;
 *         }
 *
 *         if (positiveCount[i] == maxCount) {
 *         mode = i;
 *         isSecond = true;
 *         }
 *         }
 */
