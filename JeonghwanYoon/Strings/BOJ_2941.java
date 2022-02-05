import java.util.Scanner;


public class BOJ_2941 {

	public static void main(String[] args) {
		
		/*
		 * 문제 예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.
		 * 
		 * 크로아티아 알파벳 변경 č c= ć c- dž dz= đ d- lj lj nj nj š s= ž z= 예를 들어, ljes=njak은
		 * 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져
		 * 있는지 출력한다.
		 * 
		 * dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한
		 * 글자씩 센다.
		 * 
		 * 입력 첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
		 * 
		 * 단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.
		 * 
		 * 출력 입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
		 */
		
		//풀이 : 각 알파벳을 입력받을때 if문으로 뒷문자 체크하여 크로아티아 알파벳에 해당되면 i 카운트를 넘겨서 풀이
		
		Scanner sc = new Scanner(System.in);
		
		String st = sc.next();
		int cnt = 0;
		sc.close();
		
		for (int i=0; i<st.length(); i++) {
			
			if(i+1<st.length()){
				if(st.charAt(i+1) == '-' || st.charAt(i+1) == '=') {
					i++;
				}
			}
			
			if(st.charAt(i) == 'd') {
				if(i+1<st.length()) {
					if(st.charAt(i+1) == 'z') { 
						if(i+2<st.length()) {
							if(st.charAt(i+2) == '=') {
								i += 2;
							}
						}
					}
				}
				
			}
			
			else if (st.charAt(i) == 'l') {
				if(i+1<st.length()) {
					if(st.charAt(i+1) == 'j') {
						i ++;
					}
				}
			}
				
			else if (st.charAt(i) == 'n') {
				if(i+1<st.length()) {
					if(st.charAt(i+1) == 'j') {
						i ++;
					}
				}
			}
			
			cnt++;
		}
		System.out.println(cnt);
	}
}
