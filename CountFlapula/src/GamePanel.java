
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	//Boolean will determine if GameOver is true or false.
	public static  boolean GameOver = false;
	//score will be used to keep track of the score.
	public static int score=0;
	//The width of the panel will be 600
	public static final int WIDTH=600;
	//The height of the panel is 800;
	public static final int HEIGHT=800;
	
	//The GamePanesl xCoordinate is 0;
	private int xCoor=0;
	//BuffedImage is referenced by img and = null until changed
	private BufferedImage img;
	
	//Instantiates BirdImage to be used in GamePanel
	BirdImage bi = new BirdImage();
	
	//Instantiates CaveSpikesImage to be used in GamePanel
	CaveSpikeImage csi = new CaveSpikeImage(GamePanel.WIDTH);
	//Instantiates CaveSpikesImage to be used in GamePanel as the bottom spike in game
	CaveSpikeImage csi2 = new CaveSpikeImage(GamePanel.WIDTH+(GamePanel.WIDTH/2));
	
	
	public GamePanel()
	{
		//Calls the LoadImage() method.
		LoadImage();
		//A mouse clicker is created 
		this.addMouseListener(new MouseAdapter()
			{
			public void mousePressed(MouseEvent e)
			{
				super.mousePressed(e);
				//when mouse is clicked bird goes up words per the method called
				bi.goUpwards();
				
				//if bird wings are up they will be changed to down when clicked
				if(bi.getWingPos())
				{
					bi.birdImageDown();
				}
				//if bird wings are down they will be changed to up
				else
				{
					bi.birdImageUp();
				}
			}
		});
	}

	private void LoadImage()
	{
		try
		{
			//reads an image from the file location provided and is referenced by img variable
			img = ImageIO.read(getClass().getResourceAsStream("/Image/NewBackDrop.png"));
		}
		catch(Exception e)
		{
			//prints the exception that was caught
			e.printStackTrace();
		}
		
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(img, xCoor, 0, null);
		g.drawImage(img, xCoor+2400, 0, null);
		bi.drawBird(g);
		csi.drawCaveSpike(g);
		csi2.drawCaveSpike(g);
		
		//this sets the font for g
		g.setFont(new Font("Tahoma",Font.BOLD,40));
		//draws a string of score on g where x=width/2 and y=100
		g.drawString(String.valueOf(score), WIDTH/2, 100);
	}
	
	public void Move()
	{
		bi.birdMovement();
		csi.wallMovement();
		csi2.wallMovement();
		
		if(GameOver)
		{
			csi.X=GamePanel.WIDTH;
			csi2.X=GamePanel.WIDTH+(GamePanel.WIDTH/2);
			GameOver = false;
		}
		
		
		xCoor+= CaveSpikeImage.speed;
		
		
		if(xCoor==-2400)
		{
			xCoor=0;
		}
		
		//System.out.print(score);
		
		//when birds x is at the walls x score will go up one 
		if(csi.X==BirdImage.x || csi2.X==BirdImage.x)
		{
			//score increments
			score++;
		}
	}
	
	
	//When called methode will create a yes or no pop up message.
	//If yes then method will equal true and if no method will equal false
	public static boolean popUpMessage()
	{
		int result = JOptionPane.showConfirmDialog(null, "Game Over, Your score is: "+score+"\nTry Again?", "Game Over", JOptionPane.YES_NO_OPTION);
		if(result==JOptionPane.YES_OPTION)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}


