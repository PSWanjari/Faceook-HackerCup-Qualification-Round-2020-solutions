package FaceBook;

import java.util.Scanner;

public class QualifingRoundA {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int totalAirlines = sc.nextInt();
		for(int i=0;i<totalAirlines;i++) {
			int N = sc.nextInt();
			char mat[][] =new char[800000][800000]; 
			sc.nextLine();
			String Incoming = sc.nextLine();
			String Outgoing = sc.nextLine();
			
			for(int j=0;j<N;j++)
			{
				int destination = j-1;
				int source =j;
				while(destination>=0){
					if(Incoming.charAt(destination)=='Y' && Outgoing.charAt(source)=='Y')
					{
						mat[j][destination]='Y';
					}else {
						break;
					}
					destination--;
					source--;
				}
				destination = j+1;
				source =j;
				while(destination<N){
					if(Incoming.charAt(destination)=='Y' && Outgoing.charAt(source)=='Y')
					{
						mat[j][destination]='Y';
					}else {
						break;
					}
					destination++;
					source++;
				}
			}
			System.out.print("Case #"+(i+1)+": \n");
			for(int j=0;j<N;j++)
			{
				for(int k=0;k<N;k++)
				{
					if(j==k)
						mat[j][k]='Y';
					if(mat[j][k]!='Y')
					{
						System.out.print("N");
					}else {
					System.out.print(mat[j][k]);
					}
				}
				System.out.println("");
			}
			
		}
		
	}
	
}
