package initialisation;

import gameengine.GameEngine;
import windows.CustomInteractiveWindow;
import windows.WindowConfig;
import windows.WindowFactory;

public class Launcher 
{
	public static void main(String args[])
	{
		System.out.println("Squares: Reloaded");

		WindowConfig config = new WindowConfig(0.6,0.7);
		CustomInteractiveWindow gameWindow = WindowFactory.makeWindow(new GameEngine(config),config);
	}
}
