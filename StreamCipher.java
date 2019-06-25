/* Name: John Ryan
 * Lab 6
 * For this lab I used RC4 to generate the pseudorandom keystream in Java.
 * OutPut: Plaintext : This is the plaintext
		   Key: thisIsMyKey
		   Cipher text: 5õo√Çr~G+LÄjnZ≥<âb&ñ
 */

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class StreamCipher
{
  public static void main(String[] args) throws Exception 
  {

	  String plain = "This is the plaintext";
	  String KEY = "thisIsMyKey";

    byte[] input = plain.getBytes();
    byte[] keyBytes = KEY.getBytes();
    System.out.println("Plaintext : "+plain);
    System.out.println("Key: "+KEY);

    //Set keystream to RC4
    SecretKeySpec key = new SecretKeySpec(keyBytes, "RC4"); 

    Cipher cipher = Cipher.getInstance("RC4");

    //set up byte array to hold the ciphertext
    byte[] cipherText = new byte[input.length];

    cipher.init(Cipher.ENCRYPT_MODE, key); // begin cipher

    //cycle through the stream
    int cipherLength = cipher.update(input, 0, input.length, cipherText, 0);

    cipherLength += cipher.doFinal(cipherText, cipherLength);

    //Output the result
    System.out.println("Cipher text: " + new String(cipherText));


  }
}