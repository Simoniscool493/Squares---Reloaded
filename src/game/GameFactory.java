package game;

import gameengine.CallBackToEngine;
import map.GridMap;
import utils.GameDrawing;
import utils.MiscUtils;

public class GameFactory 
{
	public static Game createDefaultGame(CallBackToEngine callBack)
	{
		GameDrawing.UpdateGridSize(MiscUtils.defaultGridSize, MiscUtils.defaultGridSize);
		return new Game(new GridMap(MiscUtils.defaultGridSize,MiscUtils.defaultGridSize),callBack);
	}
}
