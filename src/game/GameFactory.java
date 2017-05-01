package game;

import gameengine.CallBackToEngine;

public class GameFactory 
{
	public static Game createDefaultGame(CallBackToEngine callBack)
	{
		return new Game(callBack);
	}
}
