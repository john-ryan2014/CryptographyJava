/*
 * Name: John Ryan
 * Lab 8 question 2
 * I used Java to implement the RSA algorithm as it had libraries which made it easy to implement.
 * The encrypted text from the string: "This is the plaintext message" was : [B@54405a01.
 */
import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.PrivateKey;

public class RSA
{

	private KeyPair keyPair;
	public RSA() throws Exception
	{
		KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");  //Set it to RSA mode
		keygen.initialize(512);
		keyPair = keygen.generateKeyPair();
	}
	
	//Encryption method
	public byte[] encrypt(byte[] plaintext)  throws Exception
	{
		PublicKey key = keyPair.getPublic();
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
	
		byte[] ciphertext = cipher.doFinal(plaintext);
		return ciphertext;
	}
	 
	//Decryption method
	public byte[] decrypt(String ciphertext)  throws Exception
	{
		PrivateKey key = keyPair.getPrivate();
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.DECRYPT_MODE, key);
		 
		byte[] plaintext = cipher.doFinal(ciphertext.getBytes());
		return plaintext;
	}	
	
	public static void main(String[] args) throws Exception
	{
		RSA rsa = new RSA();
		String input = "This is the plaintext message";
		byte[] input2 =input.getBytes();
		 
		System.out.println("Plaintext = " + input);
		
		byte[] ciphertext = rsa.encrypt(input2);
		//The decryption wasn't working properly so i left it out and put it in comments
		//byte[] decryptedtext = rsa.decrypt(ciphertext.toString());
		//String dtext = decryptedtext.toString();
		
		System.out.println("Encryption Ciphertext = " + ciphertext.toString());
		//System.out.println("Decryption Plaintext = " + dtext);	
	}
}