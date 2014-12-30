import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

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
