/**
v * Lead Author(s):
 *
 * @author Jordan Ayling 5550188604
 *
 *         <<Add additional lead authors here>>
 *
 *         Other Contributors:
 *         Full name; student ID or contact information if not in class
 *         <<Add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 *
 * 	References:
 * 	Gaddis, T. (2021). Starting Out With Java Myprogramming Lab
 * 	From Control Structures Through Objects. (8th ed.). Addison-Wesley.
 *
 * Used a Flappy Bird Tutorial
 * https://www.youtube.com/watch?v=OuKV9F12kmc&list=PLEoFgAiu8P5jVaUDTT6aXJPBVTVrRltSr&index=3
 *
 *         Version: number or date
 *         2024-08-22
 *
 */
/**
 *
 */

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class FlappyGui
{
	private static JFrame window;
	public static Timer timer;
	
	public FlappyGui()
	{
		window = new JFrame();
		//terminates the program when you click the close button
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//sets window size
		window.setSize(GamePanel.WIDTH,GamePanel.HEIGHT);
		//centers window when opened
		window.setLocale(null);
		//sets window title as String
		window.setTitle("Dracula Flapula");
		//makes it so you cannot resize the window.
		window.setResizable(false);
		//Allows you to see the window
		window.setVisible(true);
		
		
		
	}
	
	private void rendering()
	{
		//Instantiates the Menu Panel
		MenuPanel mp = new MenuPanel();
		//Instantiates the Game Panel
		GamePanel gp = new GamePanel();
		
		//A timer is created to create the movements of the game set to update ever 2 ms
		timer = new Timer(20,new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						//GamePanel will repaint
						gp.repaint();
						//Game panel Move method will be called
						gp.Move();
						
					}
				
				});
		//Start menu Panel is added to the window 
		window.add(mp);
		//Menu panel is set to visible
		window.setVisible(true);
		
		//when menu's StartingPoint is change to false during a click
		while(mp.StartingPoint==false)
		{
			try
			{
				Thread.sleep(10);
			}
			catch(Exception e)
			{
				//prints the exception that was caught
				e.printStackTrace();
			}
		}
		//Start menuPanel is removed from window
		window.remove(mp);
		//Game Panel is added to window and game begins
		window.add(gp);
		//Game panel is set to visible
		gp.setVisible(true);
		//revalidate window
		window.revalidate();
		
		//Begin timer to start and update movements in game
		timer.start();
	}
	
	public static JFrame getWindow()
	{
		return window;
	}
	
	public static void main(String[] arg)
	{
	//Create window that has 0 components
	//1st Panel Will intro Game
	//2nd Panel Will be game after intor Panel
		FlappyGui view = new FlappyGui();
		view.rendering();
	}
}