package map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import entities.Entity;
import utils.GameDrawing;

public class Tile
{
	public int XPosition;
	public int YPosition;
	
	public ArrayList<Entity> _contents = new ArrayList<Entity>();
	
	public Tile(int xPosition,int yPosition)
	{
		XPosition = xPosition;
		YPosition = yPosition;
	}
	
	public void addEntity(Entity entity)
	{
		_contents.add(entity);
	}
	
	public boolean isEmpty()
	{
		return _contents.isEmpty();
	}
	
	public void render(Graphics2D g2)
	{
		GameDrawing.DrawTile(this,Color.red,g2);
	}
}
