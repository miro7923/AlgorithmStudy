import java.util.Scanner;

public class BOJ_10809 {

	public static void main(String[] args) {
		
//		문제
//		알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
//
//		입력
//		첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
//
//		출력
//		각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.
//
//		만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다. 단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.
		
		// 풀이 : 아스키코드를 이용하여 풀이 단 처음 등장하는 위치이므로 중복된 단어는 넘어가게하고 배열을 이용하여 
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[26]; // 알파벳 갯수 26
		
		String st = sc.next();
		
		for(int i=0; i<arr.length; i++) // 배열값 모두 -1로 초기화
			arr[i] = -1; 
		
		for(int i=0; i<st.length(); i++) {
			int temp = (int) st.charAt(i); 
			
			if(arr[temp-'a'] == -1 ) // 중복방지
			arr[temp-'a'] = i; 
		}
		
		for(int e : arr)
		System.out.print(e + " ");
		
		sc.close();
	}
}
