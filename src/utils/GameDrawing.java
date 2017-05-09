package utils;

import java.awt.Color;
import java.awt.Graphics2D;

import map.Tile;

public class GameDrawing 
{
	private static double _gameScreenWidth = 1;
	private static double _gameScreenHeight = 1;
	
	private static int _gridWidth = 1;
	private static int _gridHeight = 1;

	private static int _incWidth = 1;
	private static int _incHeight = 1;
	
	public static void UpdateGameScreenSize(double width,double height)
	{
		_gameScreenWidth = width;
		_gameScreenHeight = height;
		RecalculateIncWidthAndHeight();
	}
	
	public static void UpdateGridSize(int gridWidth,int gridHeight)
	{
		_gridWidth = gridWidth;
		_gridHeight = gridHeight;
		RecalculateIncWidthAndHeight();
	}
	
	public static void RecalculateIncWidthAndHeight()
	{
		_incWidth = (int)(_gameScreenWidth/_gridWidth);
		_incHeight = (int)(_gameScreenHeight/_gridHeight);
	}
	
	public static void DrawTile(Tile t,Color color,Graphics2D g2)
	{
		g2.setColor(color);
		g2.fillRect(
				_incWidth * t.XPosition, 
				_incHeight * t.YPosition, 
				_incWidth, 
				_incHeight);
	}
}
