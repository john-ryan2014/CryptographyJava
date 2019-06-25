/*
 * Name: John Ryan
 * Lab 8 question 1
 * I used Java to implement the this algorithm as it had libraries which made it easy to implement.
 */
public class Diffie 
{

	public static void main(String[] args) 
	{
		//step 1
		int p = 23;
		int g = 5;
		//step 2
		int a = 6;
		int A = (g^a)%p;
		int b = 15;
		int B = (g^b)%p;
		//final step
		int s = (B^a)%p;
		int s1 = (A^b)%p;
		
		//if s and s1 are the same then there is a shared secret
		if(s==s1)
		{
			System.out.println("secret is: "+ s);
		}
		

	}

}
