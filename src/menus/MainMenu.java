package menus;

import gameengine.CallBackToEngine;
import messages.EngineMessage;
import messages.MainMenuMessage;
import windows.WindowConfig;

public class MainMenu extends SquaresMenu
{	
	public enum MainMenuSelection implements MenuSelection
	{
		StartLocalGame("Local Game"),
		HostGame("Host Game"),
		JoinHostedGame("Join Game");
		
		public final String _name;
		public String getName() { return _name; }
		
		private MainMenuSelection(String name) { _name = name; }
	}	
	public MenuSelection[] getHeadings() { return MainMenuSelection.values(); }
	
	public MainMenu(CallBackToEngine callBackToEngine,WindowConfig windowConfig,MenuSettings settings)
	{
		super(callBackToEngine,windowConfig,settings);
	}
	
	public EngineMessage constructMessage(int enumNumber) 
	{
		return new MainMenuMessage(MainMenuSelection.values()[enumNumber]);
	}	
}
