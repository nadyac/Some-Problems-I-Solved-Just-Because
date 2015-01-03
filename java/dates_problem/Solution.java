/**
*	Solution.java
*	
*	Problem statement:
*
*	Write a method called answer(x,y,z) that takes as input the 3 numbers. There will
*	always be at least one valid representation of a date using the three numbers. If there
*	is only one valid representation, the function should return it as a string, MM/DD/YY
*	If there are multiple representations, the function should return the string "Ambiguous"
*	each of x, y, z will be between 1 and 99 inclusive. Assume there are no leap years. 
*/
import java.util.Arrays;
import java.util.List;

public class Solution{

	public static List longMonths;
	public static List shortMonths;

	/**
	* answer() Takes three ints and returns a date in MM/DD/YY format
	*	if there's only one valid representation of the date. Otherwise
	*	it returns 'Ambiguous'
	*
	* @param int x
	* @param int y
	* @param int z
	* @return String solution
	*/
	public static String answer(int x, int y, int z){

		int[] ints = {x, y, z};
		Arrays.sort(ints);
		longMonths = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
		shortMonths = Arrays.asList(4, 6, 9, 11);
		int month = 0;
		int day = 0;
		int year = 0;
		String solution = "";

		if (isValidMonth(ints[0]) && isValidDay(ints[0], ints[1], ints[2]) && isValidYear(ints[0], ints[1], ints[2])){
			month = ints[0];
			day = ints[1];
			year = ints[2];

			solution = formatDate(month, day, year);
		} else {
			solution = "Ambiguous";
		}

		System.out.println(solution);
		return solution;
	}

	/**
	* isValidMonth() 
	*
	* @param int m
	* @return boolean
	*/
	public static boolean isValidMonth(int m){

		if (m <= 12){
			return true;
		} else{
			return false;
		}
	}

	/**
	* answer()
	*
	* @param int m
	* @param int d
	* @param int y
	* @return boolean
	*/
	public static boolean isValidDay(int m, int d, int y){

		if (d <= 31){
			
			if (d == m || d == y){
				return true;
			}

			if (d <= 12){
				return false;
			}

			//check if d is within the 30 days in the short months
			if (shortMonths.contains(m) == true && d <= 30){
				return true;
			}

			//check if d is within the 28 days in Feb.
			if (m == 2 && d <= 28){
				return true;
			}
		}

		return false;
	}

	/**
	* isValidYear()
	*
	* @param int m
	* @param int d
	* @param int y
	* @return boolean
	*/
	public static boolean isValidYear(int m, int d, int y){

		if (y <= 99){
			
			if (y == m || y == d){
				return true;
			}

			if (y <= 12){
				return false;
			}

			if (shortMonths.contains(m) == true && y > 30){
				return true;
			}

			if(longMonths.contains(m) == true && y > 31){
				return true;
			}

			if (m == 2 && y > 28){
				return true;
			}
		}
		return false;
	}

	/**
	* formatDate() formats the month, day, and year to MM/DD/YY
	*
	* @param int m
	* @param int d
	* @param int y
	* @return String
	*/
	public static String formatDate(int m, int d, int y){

		String result = "";

		if (m < 10){
			result += "0" + m + "/";
		} else {
			result += m + "/";
		}

		if (d < 10){
			result += "0" + d + "/";
		} else {
			result += d + "/";
		}

		if (y < 10){
			result += "0" + y;
		} else {
			result += y;
		}
		return result;
	}

	public static void main(String[] argsv){
		answer(20,20,11);
	}
}