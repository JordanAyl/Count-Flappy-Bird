package packaging;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class BirdImage
{
	private BufferedImage img = null; //Buffered image will be used to place images for the bird
	private static int bird_dia = 36; //The diameter of the bird
	public static int x = (GamePanel.WIDTH/2)-bird_dia/2; //the x intercept of the bird in the window
	public static int y = GamePanel.HEIGHT/2; //the y intercept of the bird in the window
	public boolean wingsUp=true; //this boolean will help determine if the wing up bird image is true or false
	
	private static int speed=2; //the speed of the bird
	private int acce = 1; //the accelertation of the bird
	
	public BirdImage()
	{
		//calls the LoadImage() method
		LoadImage();
	}

	private void LoadImage()
	{
		try
		{
			//reads an image from the file location provided and is referenced by img variable
			img = ImageIO.read(new File("/Users/jordan/eclipse-workspace/CountFlapula/Image/FlapUp.png"));
		}
		catch(Exception e)
		{
			//prints the exception that was caught
			e.printStackTrace();
		}
		
	}
	
	public void birdImageDown()
	{
		try
		{
			//reads an image from the file location provided and is referenced by img variable
			img= ImageIO.read(new File("/Users/jordan/eclipse-workspace/CountFlapula/Image/FlapDown.png"));
		}
		catch(Exception ex)
		{
			//prints the exception that was caught
			ex.printStackTrace();
		}
		//when this method is called wingsUp = false
		wingsUp = false;
	}
	
	public void birdImageUp()
	{
		try
		{
			//reads an image from the file location provided and is referenced by img variable
			img= ImageIO.read(new File("/Users/jordan/eclipse-workspace/CountFlapula/Image/FlapUp.png"));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		//when this method is called wings up = true
		wingsUp = true;
	}
	
	//Getter for if the birds wings are up true or false
	public boolean getWingPos()
	{
		//returns boolean wingsUp;
		return wingsUp;
	}
	
	public void drawBird(Graphics g)
	{
		g.drawImage(img, x, y, null);
	}
	
	public void birdMovement()
	{
		if(y>=0 && y<=GamePanel.HEIGHT)
		{
			speed+=acce; 
			y+=speed;
		}
		else
		{
			boolean option = GamePanel.popUpMessage();
			if(option)
			{
				
				try
				{
					Thread.sleep(500);
				}
				catch(Exception ex)
				{
					//prints the exception that was caught
					ex.printStackTrace();
				}
				reset();
			}
			else
			{
				JFrame frame = FlappyGui.getWindow();
				frame.dispose();
				FlappyGui.timer.stop();
			}
			
		}
	}
	
	public void goUpwards()
	{
		speed = -17;
	}

	public static void reset()
	{
		speed = 2;
		y = GamePanel.HEIGHT/2;
		GamePanel.GameOver = true;
		GamePanel.score=0;
	}
	
	//this will method is used to determine the birds hit box
	public static Rectangle getBirdRect()
	{
		//this rectangle will be used to determine the birds hit box
		Rectangle birdRect = new Rectangle(x,y,bird_dia,35);
		return birdRect;
		
	}
}
