package game;

import java.awt.Graphics2D;

import engine.Focusable;
import gameengine.CallBackToEngine;
import windows.WindowConfig;

public class GameClient implements Focusable
{
	public int clientId;
	
	private Game _currentConnectedGame;
	private GameView _view;
	private CallBackToEngine _callBackToEngine;
	
	public GameClient(CallBackToEngine callBackToEngine,WindowConfig windowConfig)
	{
		_view = new GameView(windowConfig);
		_callBackToEngine = callBackToEngine;
	}
	
	public void setGame(Game g)
	{
		_currentConnectedGame = g;
		clientId = g.addClientAndReturnId();
	}
	
	@Override
	public void render(Graphics2D g2) 
	{
		_view.render(g2,_currentConnectedGame);
	}

	@Override
	public void OnClick(int x, int y) 
	{
		
	}

	@Override
	public void keyPressed(int keyCode)
	{
		_currentConnectedGame.sendToBuffer(keyCode,clientId);
	}

	@Override
	public void keyTyped(int keyCode) 
	{
		
	}

	@Override
	public void keyReleased(int keyCode)
	{
		_currentConnectedGame.sendToBuffer(-keyCode,clientId);
	}
}
