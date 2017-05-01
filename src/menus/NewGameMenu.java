package menus;

import gameengine.CallBackToEngine;
import messages.EngineMessage;
import messages.NewGameMenuMessage;
import windows.WindowConfig;

public class NewGameMenu extends SquaresMenu
{	
	public enum NewGameMenuSelection implements MenuSelection
	{
		StartWithDefaultSettings("Start game with default settings");
		
		public final String _name;
		public String getName() { return _name; }
		
		private NewGameMenuSelection(String name) { _name = name; }
	}	
	public MenuSelection[] getHeadings() { return NewGameMenuSelection.values(); }
	
	public NewGameMenu(CallBackToEngine callBackToEngine,WindowConfig windowConfig,MenuSettings settings)
	{
		super(callBackToEngine,windowConfig,settings);
	}
	
	public EngineMessage constructMessage(int enumNumber) 
	{
		return new NewGameMenuMessage(NewGameMenuSelection.values()[enumNumber]);
	}
}
