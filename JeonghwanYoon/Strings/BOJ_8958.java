import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_8958 {

	public static void main(String[] args) {

		/*
		 * 
		 * ���� 
		 * 
		 * "OOXXOXXOOO"�� ���� OX������ ����� �ִ�. O�� ������ ���� ���̰�, X�� ������ Ʋ�� ���̴�. ������ ���� ��� ��
		 * ������ ������ �� �������� ���ӵ� O�� ������ �ȴ�. ���� ���, 10�� ������ ������ 3�� �ȴ�.
		 * 
		 * "OOXXOXXOOO"�� ������ 1+2+0+0+1+0+0+1+2+3 = 10���̴�.
		 * 
		 * OX������ ����� �־����� ��, ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
		 *
		 *
		 * �Է� 
		 * 
		 * ù° �ٿ� �׽�Ʈ ���̽��� ������ �־�����. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ְ�, ���̰� 0���� ũ�� 80���� ���� ���ڿ���
		 * �־�����. ���ڿ��� O�� X������ �̷���� �ִ�.
		 * 
		 * 
		 * ��� 
		 * 
		 * �� �׽�Ʈ ���̽����� ������ ����Ѵ�.
		 * 
		 */
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		String[] OX = new String[N];
				
		for(int i=0; i<N; i++)
		{
			OX[i] = scanner.next(); // �� �ε����� OX�� �Է�
		}
		
		scanner.close();
		for(int i=0; i<N; i++) 
		{
			int count = 0;
			int score = 0;
			
			for(int j=0; j<OX[i].length(); j++) 
			{
				if((OX[i].charAt(j)) == 'O')
				{
					count++;
				}
				else
				{
					count = 0;
				}
				score += count;
			}
			System.out.println(score);
		}
	}
}
