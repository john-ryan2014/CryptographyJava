/* Name: John Ryan
 * Lab 7 Question 2
 * I used Data Encryption Standard to implement this MAC program and imported javax.crypto.Mac 
 * HmacSHA1 was used for the MAC which was easily implemented in java.
 * The output was: [B@7a795d5f
 */
import javax.crypto.Mac;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


public class MAC 
{
	public static void main(String[] args) throws Exception
	{
		String text = "AAAABBBBCCCCD";
		
		// I used KeyGenerator class to create the secret key.
		KeyGenerator keyg = KeyGenerator.getInstance("DES");
		keyg.init(56); 
		SecretKey key = keyg.generateKey();

		//SHA1 was the hash algorithm that is used
		Mac mac = Mac.getInstance("HmacSHA1");
    	mac.init(key);
    	
    	byte[] output = text.getBytes();
    
    	output = mac.doFinal();
    	//Display the result to the console window.
    	System.out.println(output);
	}
}
