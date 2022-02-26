import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2750 {

    static int N;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        for (int i=0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
    }
    static void sort(){
        Arrays.sort(nums);
        for (int i=0; i<N; i++){
            sb.append(nums[i]).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        sort();
        System.out.println(sb.toString());
    }
}
