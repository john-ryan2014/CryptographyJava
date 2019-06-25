/*
 * Name: John Ryan
 * Lab 10 Question 1
 * The output of this program is the red,green and blue value at each pixel of the image that it reads from.
 * I used a nested loop to  cycle through each pixel of the image.
 */
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class GreyScaleImage
{
  public static void main(final String args[]) throws Exception
  {
	    BufferedImage image = ImageIO.read(new File("C:\\Users\\Sean  Fogarty\\Documents\\Year 4\\Advanced Security\\Labs\\greyscaleImage.jpg"));
	    
	    //loop through each pixel with 2 loops, one for the image width and one for the image height.
	    for (int x = 0; x < image.getWidth(); x++) 
	    {
	    	for (int y = 0; y < image.getHeight(); y++) 
	    	{
	    		int colour = image.getRGB(x, y);
	    		int red = (colour & 0x00ff0000) >> 16;
	        	int green = (colour & 0x0000ff00) >> 8;
	        	int blue = colour & 0x000000ff;
	
	        	//The value is printed of each x and y location which represents a single pixel location
	        	System.out.println("Red Color value at pixel:"+ x +","+y +"= " + red);
	        	System.out.println("Green Color value at pixel:"+ x +","+y +"= " + green);
	        	System.out.println("Blue Color value at pixel:"+ x + ","+y +"= " + blue);
	    	}
	    }
  }
}