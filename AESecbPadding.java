/*Name: John Ryan
Lab 4 - Question1(part 2)
I used java cryptography libraries to complete the lab tasks as they are very easy to use when they are learned compared to other languages.

*/
import javax.crypto.*;
import javax.crypto.spec.*;

public class AESecbPadding
{   
 
 public static void main(String[] argv) throws Exception
 {
  
   AECBpadding ecb=new AECBpadding();
   String plaintext = "AAAABBBBCCCCDDDDAA\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x0014";
   String ciphertext = "43D3215C92A75A1478FCF9CB950D20DB502A485FD5735486D57AEA9AA809E3DD";
   byte[] enc=ecb.doEncryption(plaintext);
   
   System.out.println("PlainText : "+ plaintext);
   System.out.println("Encrypted String : "+enc);
   System.out.println("Decrypted String : "+ecb.doDecryption(ciphertext));
     
 }
}

class AECBpadding   //used to handle the encryption and decryption
{
	Cipher cipher;

	//Make the key
	byte[] key = "1234567812345678".getBytes();
	SecretKey myKey = new SecretKeySpec(key,0,key.length,"AES");

	public AECBpadding() throws Exception
	{ 
		// Create the cipher and set the mode to AES"
		cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
  
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
