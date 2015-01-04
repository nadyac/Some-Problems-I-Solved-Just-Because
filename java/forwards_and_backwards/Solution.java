/**
* Backwards_and_Forward Solution.java
*
*/
import java.util.*;

public class Solution{

	/**
	* answer takes an int and changes its radix from 2 up to 10
	* and checks whether the converted value is a palindrome
	* 
	* @param int
	* @return int
	*/
	public static int answer(int n){

		for (int base = 2; base <= 10; base++){

			if (isPalindrome(Integer.toString(n,base))){
				System.out.println("base " + base + " yields a palindrome.");
				return base;
			}
		}
		return 2;
	}

	/**
	* isPalindrome determines whether a string is a palindrome
	* 
	* @param String
	* @return boolean
	*/
	public static boolean isPalindrome(String s){

		Stack<String> st = new Stack<String>();
		Queue<String> q = new LinkedList<String>();
		int length = s.length();
		String digit = "";

		for (int i = 0; i <= length - 1; i++){
			
			//add each digit to the stack and queue
			digit = String.valueOf(s.charAt(i));
			q.add(digit);
			st.push(digit);
		}

		while(!q.isEmpty() && !st.empty()){
			
			//compare elems in the queue and stack
			if (q.remove().equals(st.pop()) == false){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] argvs){

		answer(0);
		answer(11);
		answer(111);
		answer(1000);
	}
}
