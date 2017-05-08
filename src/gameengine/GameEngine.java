package gameengine;

import engine.Engine;
import engine.Focusable;
import game.Game;
import game.GameClient;
import game.GameFactory;
import game.GameView;
import menus.MainMenu;
import menus.MenuSettings;
import menus.NewGameMenu;
import messages.EngineMessage;
import messages.MainMenuMessage;
import messages.NewGameMenuMessage;
import messages.RefreshScreenMessage;
import windows.WindowConfig;

public class GameEngine extends Engine
{
	private WindowConfig _windowConfig;
	
	private Game _currentlyHostedGame;
	private GameClient _gameClient;
	private MainMenu _mainMenu;
	private NewGameMenu _newGameMenu;
	
	private CallBackToEngine _callBack;
	
	public GameEngine(WindowConfig windowConfig)
	{
		this._windowConfig = windowConfig;
		
		_callBack = new CallBackToEngine()
		{
			public void sendCallBack(EngineMessage m)
			{
				  recieveCallBack(m);
			}
		};
		
		_mainMenu = new MainMenu(_callBack, windowConfig, new MenuSettings());
		_newGameMenu = new NewGameMenu(_callBack, windowConfig, new MenuSettings());
		_gameClient = new GameClient(_callBack,windowConfig);
		
		this.currentFocus = _mainMenu;
	}

	public void recieveCallBack(EngineMessage m)
	{
		if(m instanceof RefreshScreenMessage)
		{
			this.painter.refresh();
		}
		else if(m instanceof MainMenuMessage)
		{
			switch(((MainMenuMessage)m).selection)
			{
				case HostGame:
					break;
				case JoinHostedGame:
					break;
				case StartLocalGame:
					changeFocus(_newGameMenu);
					break;
			}
		}
		else if(m instanceof NewGameMenuMessage)
		{
			switch(((NewGameMenuMessage)m).selection)
			{
				case StartWithDefaultSettings:
					initializeDefaultLocalGame();
					break;
			}
		}
	}
	
	public void initializeDefaultLocalGame()
	{
		Game newGame = GameFactory.createDefaultGame(_callBack);
		newGame.initialize();

		_currentlyHostedGame = newGame;
		_gameClient.setGame(newGame);
		
		newGame.start();
		changeFocus(_gameClient);
	}
}
