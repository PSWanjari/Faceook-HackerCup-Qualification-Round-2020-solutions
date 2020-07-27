package FaceBook;

import java.util.Scanner;

public class QualifingRoundB {

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int test_cases = sc.nextInt();
		for(int i=0;i<test_cases;i++)
		{
			int N = sc.nextInt();
			sc.nextLine();
			String input = sc.nextLine();
			int countA=0;
			int countB=0;
			for(int j=0;j<input.length();j++)
			{
				if(input.charAt(j)=='A')
				{
					countA++;
				}else {
					countB++;
				}
			}
			if(Math.abs(countA-countB)==1) {
				System.out.println("Case #"+(i+1)+": "+'Y');
			}else {
				System.out.println("Case #"+(i+1)+": "+'N');
			}
		}
		sc.close();
	}
}
