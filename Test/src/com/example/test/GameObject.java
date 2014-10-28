package com.example.test;

import org.andengine.entity.shape.IShape;
import org.andengine.entity.sprite.Sprite;

public interface GameObject extends IShape {
	public enum GameObjectType
	{
		WEAK,
		STRONG
	}
	
	public void setPosition(Vector2 pos);
	
	public Sprite getSprite();
	
	public Vector2 getPosition();
	
	public void update(float elapsedTime);
	
	public void die();
    
	public boolean getIsAlive();

}
