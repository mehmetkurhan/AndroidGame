package com.example.test;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.example.test.GameObject.GameObjectType;

public class Bullet extends Sprite implements GameObject {
	
	
	private int speed;
	private boolean isFired;
	private boolean isAlive;
	private String direction;
	private Rectangle bounds;
	private GameObjectType objectType;
	
	public Bullet(float x,float y,ITextureRegion tr,VertexBufferObjectManager o,Rectangle bounds)
	{
		
	super(x,y,ResourcesManager.getInstance().bullet_region,o);
	this.objectType = GameObjectType.WEAK;
	this.speed = 7;
	isFired = false;
	isAlive = true;
	this.setVisible(false);
	this.bounds = bounds;
	this.setScale(0.5f);
	
	}
	public boolean isAlive()
	{
		return this.isAlive;
	}
	public void setStrength(GameObjectType type)
	{
		this.objectType = type;
	}
	public GameObjectType getStrength()
	{
		return this.objectType;
	}
	public void fire(String direction)
	{
		this.isFired = true;
		this.setVisible(true);
		this.speed = 7;
		this.move();
	}
	public boolean getFired()
	{
		return isFired;
	}
	public void die()
	{
		this.isAlive = false;
		this.setVisible(false);

	}
	public void setDirection(String direction)
	{
		if(!isFired)
		{
		this.direction = direction;
		}
	}
	public void move()
	{
		
		if(!isStopped())
		{
		if(direction == "left")
		{
			this.setPosition(this.getX() - speed,this.getY());
		}
		else if(direction == "right")
		{
			this.setPosition(this.getX() + speed,this.getY());
		}
		else if(direction == "up")
		{
			this.setPosition(this.getX(),this.getY() - speed);
		}
		else
		{
			this.setPosition(this.getX(),this.getY() + speed);
		}
		if(!bounds.contains(this.getX(),this.getY()))
				{
					this.die();
				}
		}
	}
	public void respawn(float x,float y)
	{
	
		this.setVisible(false);
		this.setPosition(x,y);
		this.isAlive = true;
		this.stop();
		this.isFired = false;
	}
	public void stop()
	{
		this.speed = 0;
	}
	public boolean isStopped()
	{
		return this.speed == 0;
	}
	@Override
	public void setPosition(Vector2 pos) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Sprite getSprite() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Vector2 getPosition() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void update(float elapsedTime) {
		// TODO Auto-generated method stub
		
	}
	public boolean getIsAlive()
	{
		return isAlive;
	}
	

}
