package gameengine;

import messages.EngineMessage;

public interface CallBackToEngine 
{
	abstract void sendCallBack(EngineMessage m);
}
