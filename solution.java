/**
* Driver that runs simple HackerRank program
*
*Sherlock Holmes is getting paranoid about Professor Moriarty, his archenemy.
*All his efforts to subdue Moriarty have been in vain. These days Sherlock is working
*on a problem with Dr. Watson. Watson mentioned that the CIA has been facing weird
*problems with their supercomputer, 'The Beast', recently.
*
*This afternoon, Sherlock received a note from Moriarty, saying that he has infected 'The Beast'
with a virus. Moreover, the note had the number N printed on it. After doing some calculations,
Sherlock figured out that the key to remove the virus is the largest 'Decent' Number having N digits.
A 'Decent' Number has -
3 or 5 or both as its digits. No other digit is allowed.
Number of times 3 appears is divisible by 5.
Number of times 5 appears is divisible by 3.
Meanwhile, the counter to destruction of 'The Beast' is running very fast.
Can you save 'The Beast', and find the key before Sherlock?
Input Format
The 1st line will contain an integer T, the number of test cases. This is followed by T lines, each containing an integer N i.e.
the number of digits in the number
Output Format
Largest Decent number having N digits. If no such number exists, tell Sherlock that he is wrong and print '-1'
Constraints
1<=T<=20
1<=N<=100000
*/
import java.util.*;

public class solution {
    static String result = "-1";
	static int numberOf3s = 0;
	static int numberOf5s = 0;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tests = input.nextInt();
		
		for (int x = 0; x < tests; x++){
			int N = input.nextInt();
			
			//reset all the variables
			result = "-1";
			numberOf3s = 0;
			numberOf5s = 0;
			
			if (N < 3){
				result = "-1";
			} else if(N == 3) {
				result = "555";
			} else if (N == 5){
				result = "33333";
			} else if (N > 5){
				result = subtractFromN(N);
			}
			
			if(result.length() != N){
				result = "-1";
			} 
			System.out.println(result);
		}
	}
		
		public static String subtractFromN(int N){
			
			if (N >= 5 && N % 3 != 0){
				N = N - 5;
				numberOf3s = numberOf3s + 5;
			} 
			
			while ( N != 0 && N >= 3){
				//check if result is divisible by 3
				if (N % 3 == 0){
					numberOf5s = numberOf5s + 3*N/3;
                    			N = N - 3*N/3;
				}
				//check if result is divisible by 5
				else if (N % 5 == 0){
			        	numberOf3s = numberOf3s + 5*N/5;
                    			N = N - 5*N/5;
				} else {
					String str = subtractFromN(N);
					return str;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			//generate the decent number
			for (int i = 0; i < numberOf5s; i++){
				sb.append("5");
			}
			for (int i = 0; i < numberOf3s; i++){
				sb.append("3");
			}
			
			return sb.toString();
		}
}
