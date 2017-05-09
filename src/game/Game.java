package game;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Timer;
import java.util.TimerTask;

import entities.Entity;
import entities.Player;
import gameengine.CallBackToEngine;
import map.IGameMap;
import map.Tile;
import messages.RefreshScreenMessage;
import utils.MiscUtils;

public class Game
{	
	private GameState _state = GameState.Undefined;
	private IGameMap _map;
	
	private LinkedHashSet<Player> _players = new LinkedHashSet<Player>();
	private LinkedHashSet<Tile> _changedList = new LinkedHashSet<Tile>();

	private Timer gameTimer;
	private CallBackToEngine _callback;
	private HashMap<Integer,Control> _keyBuffer;
	
	public Game(IGameMap map,CallBackToEngine callBack)
	{
		_map = map;
		_callback = callBack;
		_state = GameState.NotStarted;
	}
	
	public void initialize()
	{
		_keyBuffer = new HashMap<Integer,Control>();
		_map.initialize();
		assignTimer();
	}
	
	public void start()
	{
		startTimer();
		_state = GameState.Running;
	}
	
	public int addClientAndReturnId()
	{
		int clientId = _players.size();
		createPlayer(clientId);
		
		return clientId;
	}
	
	public void sendToBuffer(int keyCode, int clientId)
	{
		_keyBuffer.put(clientId,Control.getByKeyCode(keyCode));
	}
	
	private void createPlayer(int clientId)
	{
		Player player = new Player(clientId);
		placeEntityAtPosition(player,_map.getFirstFreeTile());
		_players.add(player);
	}

	private void tick()
	{
		clearKeyBuffer();
		
		_changedList.add(_map.getFirstFreeTile());
		_callback.sendCallBack(new RefreshScreenMessage());
	}
	
	private void clearKeyBuffer()
	{
		for(Player p:_players)
		{
			if(_keyBuffer.containsKey(p.Id))
			{
				p.acceptKeyInput(_keyBuffer.get(p.Id));
			}
		}
		
		_keyBuffer.clear();
	}
	
	private void assignTimer()
	{
		gameTimer = new Timer("Game Timer");
	}
	
	private void startTimer()
	{
		TimerTask tick = new TimerTask()
		{
			public void run() { tick(); }
		};
		
		gameTimer.schedule(tick, 0, (1000/MiscUtils.frameRate));
	}
	
	private void placeEntityAtPosition(Entity entity,Tile tile)
	{
		entity.setLocation(tile);
		tile.addEntity(entity);
	}
	
	public void render(Graphics2D g2)
	{
		for(Tile t:_changedList)
		{
			t.render(g2);
		}
		
		_changedList.clear();
	}
}
