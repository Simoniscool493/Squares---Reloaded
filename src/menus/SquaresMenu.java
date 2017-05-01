package menus;

import java.awt.Graphics2D;

import drawing.DrawingUtils;
import engine.Focusable;
import gameengine.CallBackToEngine;
import messages.EngineMessage;
import windows.WindowConfig;

public abstract class SquaresMenu implements Focusable
{
	private CallBackToEngine _callBackToEngine;
	private MenuSettings _settings;
	
	private WindowConfig _windowConfig;

	public SquaresMenu(CallBackToEngine callBackToEngine,WindowConfig windowConfig,MenuSettings settings)
	{
		_callBackToEngine = callBackToEngine;
		_settings = settings;
		_windowConfig = windowConfig;
	}
	
	@Override
	public void render(Graphics2D g2)
	{
		MenuSelection[] headings = getHeadings();
		
		g2.setColor(_settings.backgroundColor);
		g2.fillRect(0,0,_windowConfig.Width,_windowConfig.Height);

		g2.setColor(_settings.lineColor);
		g2.setFont(_settings.headerFont);
		
		int menuItemHeight = _windowConfig.Height/headings.length;
		
		for(int i=0;i<headings.length;i++)
		{
			g2.drawLine(0, menuItemHeight*i, _windowConfig.Width, menuItemHeight*i);
			DrawingUtils.DrawCenteredString(headings[i].getName(), _windowConfig.Width/2, (menuItemHeight*i)+menuItemHeight/2, g2);
		}
	}

	public abstract MenuSelection[] getHeadings();

	public abstract EngineMessage constructMessage(int enumNumber);
	
	@Override
	public void OnClick(int x, int y)
	{
		this._callBackToEngine.sendCallBack(constructMessage(y/(_windowConfig.Height/getHeadings().length)));
	}

	@Override
	public void keyPressed(int keyCode) {}

	@Override
	public void keyTyped(int keyCode) {}
	
	@Override
	public void keyReleased(int keyCode) {}
}
