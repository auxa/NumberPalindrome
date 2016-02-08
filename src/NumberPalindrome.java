import java.util.ArrayList;

/**
 * CS2010 (Hilary Term) - Assignment 2
 * 
 * Largest Palindrome as product of N-Digit numbers
 * 
 * A palindromic number reads the same both ways. The largest palindromic number made 
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Problem: Develop an algorithm, which will be able to calculate the largest palindromic number,
 * which is a product of two n-digit numbers. In order to achieve important optimisations, you can
 * assume that n is odd. 
 * 
 * 1) Implement reverse method. This method takes in an integer and returns its reverse representation
 *       reverse(12345) = 54321. You shouldn't convert the number into string and use String APIs.
 *  
 * 2) Implement the isPalindrome method.
 * 
 * 3) Look at the naive implementation of largestPalindromeThreeDigitNumberProduct method.
 *       This method calculates the largest palindrome number, which is a product of 3 digit numbers.
 * 
 * 4) Once you understand the largestPalindromeThreeDigitNumberProduct method, think of how you could
 *       generalise this approach so that it works for products of different number sizes.
 *       largestPalindromeNDigitProduct(3) should return largest palindrome which is a product of two, 3 digit numbers
 *       largestPalindromeNDigitProduct(5) should return largest palindrome which is a product of two, 5 digit numbers
 * 
 * 5) Optimise the method so that it runs in reasonable amount of time (~1s-2s) even for products of 7 digit numbers
 * 
 * 6) Test your code by providing additional tests in the NumberPalindromeTest class.
 * 
 * @author:
 * 
 */
public class NumberPalindrome {


	/**
	 * Method which takes in a number and returns its reverse. E.g. reverse(12345) = 54321
	 * 
	 * @param n - number to be reversed
	 * @return the reversed number n
	 */


	public static long reverse(long n) {
		long revNumber =0;
		while(n>0){
			revNumber=(revNumber*10) +(n %10);
			n/=10;
		}
		return revNumber;
	}

	/**
	 * Method to check if a number is palindromic. E.g. isPalindrome(123) = false, isPalindrome(101) = true
	 * 
	 * @param n - number to check
	 * @return boolean value representing whether n is a palindrome
	 */
	public static boolean isPalindrome(long n) {
		if(n == reverse(n)){
			return true;
		}
		return false;
	}

	/**
	 * Naive implementation of the method returning the largest palindrome, which is a product of
	 * two 3-digit numbers.
	 * 
	 * @return largest palindrome
	 */
	public static int largestPalindromeThreeDigitNumberProduct() {
		int max_prod = Integer.MIN_VALUE;
		for (int i = 999; i > 99; i--)
		{
			int j = 999;
			while (j >= i) {
				int prod = i * j;

				if (isPalindrome(prod)) {
					max_prod = Math.max(prod, max_prod);
				}
				j = j - 1;
			}
		}
		return max_prod;

	}

	/**
	 * Method, which takes in a number of digits. It then calculates the largest palindrome, which is
	 * a product of two numbers made up of that many digits.
	 * 
	 * In order to optimise the calculation, you can assume the digits is an odd number.
	 * 
	 * @param digits 
	 * @return largest palindrome which a product of two numbers having specified number of digits.
	 */
	public static long largestPalindromeNDigitProduct(int digits) {
		//TODO: Generalise the 3-digit product algorithm to work on products of odd-digit numbers
		//TODO: Optimise this algorithm so that even products of 7-digit numbers execute in the order of second
		int max=1;
		int min =1;

		for(int i =0; i<digits;i++){
			max*=10;
			min*=10;
		}
		min /=10;
		min--;
		max--;
		long prod=0;
		long j=max;
		long i =max;
		long max_prod = max * min;
		while(i > min)
		{
			j=i;
			while(j > min ) {
				if(i%11==0 || j%11==0){
					prod = i * j;
					if(prod>max_prod){
						if (prod == reverse(prod)) {
							System.out.println("here " + i + " " + j + " " + prod);
							max_prod=prod;
						}
					}
					else{
						break;
					}
				}
				j--;
			}

			i--;
		}
		return max_prod;			


	}
}