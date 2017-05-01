package game;

import java.awt.List;
import java.io.Console;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Timer;
import java.util.TimerTask;

import entities.Player;
import gameengine.CallBackToEngine;
import messages.RefreshScreenMessage;
import utils.MiscUtils;

public class Game
{	
	private ArrayList<Player> players = new ArrayList<Player>();
	
	private Timer gameTimer;
	private CallBackToEngine _callback;
	private Dictionary<Integer,Integer> _keyBuffer;
	
	public Game(CallBackToEngine callBack)
	{
		_callback = callBack;
	}
	
	public void start()
	{
		assignTimer();
		startTimer();
	}
	
	public int addClient()
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
}
