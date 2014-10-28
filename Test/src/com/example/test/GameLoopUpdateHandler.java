package com.example.test;

import org.andengine.engine.handler.IUpdateHandler;

public class GameLoopUpdateHandler implements IUpdateHandler {
	
	
  
	@Override
	public void onUpdate(float pSecondsElapsed) {
		
		
           
           Game.getInstance().update(pSecondsElapsed);
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

}
