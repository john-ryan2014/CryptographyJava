/* Name: John Ryan
 * Lab 7 Question 1
 * I created a simple hashing function for a string which contains the text: "AAAABBBBCCCCD".
 * The output result was the hash value : 1880545356 which is printed to the console window.
 */

public class HashFunction 
{

	public static void main(String[] args)
	{
		String text = "AAAABBBBCCCCD";
		int result = hashingFunction(text);
		
		System.out.println(result);
		
	}
	public static int hashingFunction(String text) 
	{
		String text1 = text;
		int hash = 0;
		
		for (int i = 0; i < text1.length(); i++)
	    {
			//create the hashing functionality
		    hash = hash * 21 + text1.charAt(i);
		}
		return hash;
	}

}
