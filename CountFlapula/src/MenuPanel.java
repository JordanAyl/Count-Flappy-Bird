
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class MenuPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	//bufferd image will be used to display the start menu
	private BufferedImage img=null;
	//StartingPoint variable will be used to determine if the game has started or not
	public boolean StartingPoint =false;
	
	public MenuPanel()
	{
		LoadImage();
		//handle a mouse click event
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				//calls constructor for mouse listener
				super.mouseClicked(e);
				//startingPoint is change to true to start the game
				StartingPoint=true;
			}
		});
		
	}
	
	private void LoadImage()
	{
		try
		{
			//reads an image from the file location provided and is referenced by img variable
			img = ImageIO.read(getClass().getResourceAsStream("/Image/IntroPicture.png"));
		}
		catch(Exception ex)
		{
			//prints the exception that was caught
			ex.printStackTrace();
		}
	}
	
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.drawImage(img, 0, 0, GamePanel.WIDTH, GamePanel.HEIGHT, null);
	}
}
