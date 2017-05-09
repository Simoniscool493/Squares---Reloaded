package map;

import entities.Entity;

public class GridMap implements IGameMap
{
	private int _width;
	private int _height;
	private Tile[][] _grid;
	
	public GridMap(int height,int width)
	{
		_width = width;
		_height = height;
	}
	
	public void initialize()
	{
		_grid = new Tile[_width][_height];
		
		for(int i=0;i<_height;i++)
		{
			for(int j=0;j<_width;j++)
			{
				_grid[i][j] = new Tile(i,j);
			}
		}
	}
	
	public Tile getFirstFreeTile()
	{
		for(int i=0;i<_height;i++)
		{
			for(int j=0;j<_width;j++)
			{
				if(_grid[i][j].isEmpty())
				{
					_grid[i][j]._contents.add(new Entity());
					return _grid[i][j];
				}
			}
		}
		
		throw new RuntimeException("Whole grid is full");
	}
}
