package game;

import java.awt.Color;
import java.awt.Graphics2D;

import drawing.DrawingUtils;
import windows.WindowConfig;

public class GameView
{
	private WindowConfig _windowConfig;
	
	public GameView(WindowConfig windowConfig)
	{
		this._windowConfig = windowConfig;
	}
	
	public void render(Graphics2D g2,Game game)
	{
		if(game==null)
		{
			g2.setColor(Color.blue);
			g2.fillRect(0, 0, _windowConfig.Width, _windowConfig.Height);
			g2.setColor(Color.red);
			DrawingUtils.DrawCenteredString("No Game Has Been Set", _windowConfig.Width/2, _windowConfig.Height/2, g2);
		}
		else
		{
			g2.setColor(Color.white);
			g2.fillRect(0, 0, _windowConfig.Width, _windowConfig.Height);
			g2.setColor(Color.black);
		}
	}
}
