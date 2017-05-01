package messages;

import menus.NewGameMenu.NewGameMenuSelection;

public class NewGameMenuMessage extends EngineMessage
{
	public NewGameMenuSelection selection;
	
	public NewGameMenuMessage(NewGameMenuSelection selection)
	{
		this.selection = selection;
	}
}
