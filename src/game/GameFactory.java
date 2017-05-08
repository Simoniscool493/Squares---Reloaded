package game;

import gameengine.CallBackToEngine;
import map.GridMap;
import utils.MiscUtils;

public class GameFactory 
{
	public static Game createDefaultGame(CallBackToEngine callBack)
	{
		return new Game(new GridMap(MiscUtils.defaultGridSize,MiscUtils.defaultGridSize),callBack);
	}
}
