/*Name: John Ryan
I used java cryptography libraries to complete the lab tasks as they are very easy to use when they are learned compared to other languages.
The java libraries also make it easy to use padding as part of question 3. I have included padding in the first question, without functions.
*/
import javax.crypto.*;
import javax.crypto.spec.*;

public class ECBmode
{   
 
 public static void main(String[] argv) throws Exception
 {
  
   ECB ecb=new ECB();
   String plaintext = "AAAABBBBAAAABBBB";
   String ciphertext = "19FF4637BB2FE77C19FF4637BB2FE77C";
   byte[] enc=ecb.doEncryption(plaintext);
   
   System.out.println("PlainText : "+ plaintext);
   System.out.println("Encrypted String : "+enc);
   System.out.println("Decrypted String : "+ecb.doDecryption(ciphertext));
     
 }
}

class ECB   //used to handle the encryption and decryption
{
	Cipher cipher;

	//Make the key
	byte[] key = "12345678".getBytes();
	SecretKey myKey = new SecretKeySpec(key,0,key.length,"DES");

	public ECB() throws Exception
	{ 
		// Create the cipher and set the mode ,  padding is also used here as part of question 3.
		cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
  
	}
 
	public byte[] doEncryption(String s) throws Exception
	{
		// Initialize the cipher for encryption
		cipher.init(Cipher.ENCRYPT_MODE, myKey);

      	byte[] text = s.getBytes();

      	// Encrypt the text
      	byte[] encrypted = cipher.doFinal(text);

      	return(encrypted);
	}
 
	public String doDecryption(String s)throws Exception
	{
	 
		// Initialize the same cipher for decryption
		cipher.init(Cipher.DECRYPT_MODE, myKey);
		
        byte[] text = s.getBytes();
		// Decrypt the text
		byte[] decrypted = cipher.doFinal(text);

		return(new String(decrypted));
	}
}

