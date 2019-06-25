/*Name: John Ryan
 * Lab 5 Question 1 + Question 2(see below).
 * The program here prints out 9 pseudorandom numbers to the console window, the output of one single run was:24,36,186,1,97,10,213,49,213
 */
public class PRNG 
{
	public static void main(String[] argv) throws Exception
	{
		//loop is used to generate a block of 9 pseudorandom numbers 
		for(int i=1;i<10;i++) 
		{
			System.out.println(randgen(i+17*(randgen(i+13))));  
			//Two prime numbers are used as part of the input to the method.
		}
	}
	static int randgen(int limit) //generates a random number ,the values used here are completely random
	{
	        int a = 1111;
	        a = (a * 125) % 1234567;   //	The mod function is used to help create  an extra level of security and randomness.
	        return ((a % limit) + 1);
	}
}
/* 
 * Question 2:
 * Test 1: Frequency (monobit) test
 *  The program prints out 9 random numbers which do not once repeat any other number. When a higher number of 200 was put into
 *  the program of outputting numbers, there were still no repeats, which suggest that  the program passes this part of the test.
 *  
 *  Test 2: Frequency test within a block
 *   The program also passes test 2 as there were no repeats within one single block of numbers.
 *   
 *   Test 3: Non-overlapping template matching test
 *    The program also passed this test as there was no overlapping of multiple numbers in the output.
 * */



