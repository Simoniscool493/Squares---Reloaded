package messages;

import menus.MainMenu.MainMenuSelection;

public class MainMenuMessage extends EngineMessage
{
	public MainMenuSelection selection;
	
	public MainMenuMessage(MainMenuSelection selection)
	{
		this.selection = selection;
	}
}
