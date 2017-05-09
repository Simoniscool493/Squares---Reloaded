package game;

public enum Control
{
	Undefined(0),
	Up('W'),
	Down('S'),
	Left('A'),
	Right('D'),
	NUp(-'W'),
	NDown(-'S'),
	NLeft(-'A'),
	NRight(-'D');
	
	public int KeyCode;
	
	Control(int keyCode)
	{
		KeyCode = keyCode;
	}
	
	public static Control getByKeyCode(int keyCode)
	{
		for(Control c : Control.values())
		{
			if(c.KeyCode==keyCode)
			{
				return c;
			}
		}
		
		return Control.Undefined;
	}
}
