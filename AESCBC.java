/*Name: John Ryan
I used java cryptography libraries to complete the lab tasks as they are very easy to use when they are learned compared to other languages.
I changed the mode from DES TO AES from lab 3 which was very easy to do using java libraries.
*/
import javax.crypto.*;
import javax.crypto.spec.*;

public class AESCBC
{   
 
 public static void main(String[] argv) throws Exception
 {
  
   ACBC cbc=new ACBC();
   String plaintext = "AAC823F6BBE58F9EAF1FE0EB9CA7EB08";
   String ciphertext = "AAAABBBBAAAABBBB";
   byte[] enc=cbc.doEncryption(plaintext);
   
   System.out.println("PlainText : "+ plaintext);
   System.out.println("Encrypted String : "+enc);
   System.out.println("Decrypted String : "+cbc.doDecryption(ciphertext));
     
 }
}

class ACBC   //used to handle the encryption and decryption
{
	Cipher cipher;

	//Make the key
	byte[] key = "12345678".getBytes();
	SecretKey myKey = new SecretKeySpec(key,0,key.length,"AES");
	
	// Make the initialisation vector
	byte[] IV = "00000000".getBytes();
	IvParameterSpec ivSpec = new IvParameterSpec(IV);
	
	public ACBC() throws Exception
	{ 
		// Create the cipher and set the mode to AES.
		cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
  
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
		cipher.init(Cipher.DECRYPT_MODE, myKey,ivSpec);
		
        byte[] text = s.getBytes();
		// Decrypt the text
		byte[] decrypted = cipher.doFinal(text);

		return(new String(decrypted));
	}
}

