package game;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Dictionary;
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
	
	private ArrayList<Player> players = new ArrayList<Player>();
	
	private Timer gameTimer;
	private CallBackToEngine _callback;
	private Dictionary<Integer,Integer> _keyBuffer;
	
	public Game(IGameMap map,CallBackToEngine callBack)
	{
		_map = map;
		_callback = callBack;
		_state = GameState.NotStarted;
	}
	
	public void initialize()
	{
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
		int clientId = players.size();
		createPlayer(clientId);
		
		return clientId;
	}
	
	public void sendToBuffer(int keyCode, int clientId)
	{
		_keyBuffer.put(clientId, keyCode);
	}
	
	private void createPlayer(int clientId)
	{
		Player player = new Player(clientId);
		placeEntityAtPosition(player,_map.getFirstFreeTile());
		players.add(player);
	}

	private void tick()
	{
		_callback.sendCallBack(new RefreshScreenMessage());
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
		g2.fillRect(0, 0, 300, 300);
	}
}
