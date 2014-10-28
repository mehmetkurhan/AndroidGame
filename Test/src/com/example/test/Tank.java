package com.example.test;

import java.util.ArrayList;
import java.util.List;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.shape.IShape;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import android.graphics.Point;
import android.graphics.PointF;

public class Tank extends Sprite implements GameObject{
	public enum TankState
	{
		RESPAWN,
		RUNNING,
		DIED
	}
	
    protected Rectangle boundary;
    protected int speed = 1;
    protected Bullet bullet;
    protected String direction;
    protected PointF center;
    protected boolean isAlive;
    protected GameObjectType type;
    protected List<GameObject> currentObjects;
	protected boolean isFired;
	private int currentLife;
	private Game game;
	public float respawnTime;
	public float blinkTime;
	public float totalBlinkTime;
	protected TankState tankState;
	private boolean blinkState;
	private boolean gameOver;
	private ArrayList<Class> killableObjects;
	private String previousDirection;
	
   
	
    
	public Tank(float x,float y,ITextureRegion tr,VertexBufferObjectManager o)
	{
		
	    super(x,y,tr,o);
	    killableObjects = new ArrayList<Class>();
	    killableObjects.add(EnemyTank.class);
	    killableObjects.add(Wall.class);
	    game = new Game();
	    this.setRotation(-90);
	    boundary = new Rectangle(0,0,760,440,o);
	    this.speed = 5;
	    this.bullet = new Bullet(x + this.getWidth() / 2,y + this.getHeight() / 2,ResourcesManager.getInstance().bullet_region,o,boundary);
	    center = new PointF(x + this.getWidth() / 2,y + this.getHeight() / 2);
	    isAlive = true;
	    type = GameObjectType.WEAK;
	    currentLife = 10;
	    respawnTime = 2;
	    blinkTime = 0.25f;
	    totalBlinkTime = 5;
	    tankState = TankState.RESPAWN;
	    blinkState = true;
	    gameOver = false;
	    direction = "up";

	}
	public void setCurrentObjects(List<GameObject> l)
	{
			this.currentObjects = l;
	}
	public PointF getCenter()
	{
		return center;
		
	}
	public void setCenter(float x,float y)
	{
		this.center.x = x + this.getWidth() / 2;
		this.center.y = y + this.getHeight() / 2;
	}
	public void move(String direction)
	{
		if(this.isAlive)
		{
	    for(int i = 0; i < currentObjects.size();i++)
	    {
	    	if(currentObjects.get(i).getIsAlive())
	    	{
	    	if(currentObjects.get(i) != this && this.collidesWith(currentObjects.get(i)) && collisionTest(this, currentObjects.get(i)))
	    	{
	    		
	    		this.stop();
	    		previousDirection = this.getDirection();
	    	}  
	    	else
	    	{
	    		if(previousDirection != this.getDirection())
	    		{
	    	    this.start();
	    	    previousDirection = this.getDirection();
	    		}
	    	}
	    	}
	    	
	    }
		this.direction = direction;
		if(direction == "left")
		{
			
			this.setRotation(-90);
			this.setPosition(this.getX() - speed,this.getY());
			if(this.getX() < boundary.getX())
			{
				this.stop();
			}
			else
			{
				this.start();
			}
			
			
		}
		else if(direction == "right")
		{
			
			this.setRotation(90);
	        this.setPosition(this.getX() +speed,this.getY());
	        if(this.getX() > boundary.getWidth())
	        {
	        	this.stop();
	        }
	        else
	        {
	        	this.start();
	        }
	        
	        
	        
		}
		else if(direction == "up")
		{
			this.setRotation(0);
			this.setPosition(this.getX(), this.getY() - speed);
			if(this.getY() < boundary.getY())
			{
				this.stop();
			}
			else
			{
				this.start();
			}
			
		}
		else
		{
			this.setRotation(180);
			this.setPosition(this.getX(),this.getY() + speed);
			if(this.getY() > boundary.getHeight())
			{
				this.stop();
			}
			else
			{
				this.start();
			}
		}
		
		if(this.bullet.getFired() == false)
		{
			this.bullet.setPosition(this.getX() + this.getWidth() / 2, this.getY() + this.getHeight() / 2);
		}
		else 
		{
			if(this.bullet.isAlive())
			{
			this.bullet.move();
			}
			else
			{
				this.bullet.respawn(this.getX() + this.getWidth() / 2, this.getY() + this.getHeight() / 2);
				
			}
		}
		
		}
		
	}
	public void stop()
	{
		this.speed = 0;
	}
	public void start()
	{
		this.speed = 1;
	}
	public void doubleSpeed()
	{
		this.speed*=2;
	}
	public void fire()
	{
		if(this.isAlive)
		{
		this.bullet.setDirection(this.direction);
		this.bullet.setRotation(this.getRotation());
		this.bullet.fire(direction);
		}
	}
	public void setDirection(String direction)
	{
		this.direction = direction;
	}
	public Bullet getBullet()
	{
		return this.bullet;
	}
	public void hit(List<GameObject> currentObjects)
	{
		// TO-DO
		if(this.isAlive)
		{
		if(currentObjects != null)
		{
		for(int i = 0; i< currentObjects.size();i++)
		{
			GameObject s = currentObjects.get(i);
			if(this.bullet.collidesWith(s) && s.getIsAlive() && s != this)
			{
				
				
				if(s instanceof SteelWall)
				{
					this.getBullet().die();
				}
				if(s instanceof Tank)
				{
					s.die();
					this.getBullet().die();
					continue;
				}
				if(s instanceof Wall)
				{
					s.die();
					this.getBullet().die();
					continue;
				}
				if(s instanceof EnemyTank)
				{
					s.die();
					this.getBullet().die();
				//	SceneManager.getInstance().createGameOverScene();
					continue;
				} 
				if(s instanceof Castle)
				{
					s.die();
					this.getBullet().die();
					SceneManager.getInstance().createGameOverScene();
					continue;
				}
				
				/*
				if(((Tank)s).tankState == TankState.RUNNING)
				{
				s.die();
				continue;
				}
				*/
				
				
				
				
			   // s.detachSelf();
			 //   currentObjects.remove(s);
			   // s = null;
				//this.bullet.die();
			//	this.bullet.detachSelf();
			//	this.bullet = null;
			
				
				
			}
		}
		}
		}
	}
	public void die()
	{
		
		this.setVisible(false);
		this.isAlive = false;
		this.bullet.die();
		currentLife--;
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
	public String getDirection()
	{
		return this.direction;
	}
	@Override
	public Vector2 getPosition() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void update(float elapsedTime) {
		// TODO Auto-generated method stub
		if(gameOver)
		{
			this.currentLife++;
			game.gameOver();
		}
		if(this.isAlive)
		{
		this.move(direction);
		this.hit(currentObjects);
		}
		else 
		{
			if(currentLife > 0)
			{
				respawn(elapsedTime);
			}
			else
			{
				//game.gameOver();
			}
		}
		if(tankState == TankState.RESPAWN)
		{
			blinkTime -= elapsedTime;
			totalBlinkTime -= elapsedTime;
			if(totalBlinkTime < 0)
			{
				tankState = TankState.RUNNING;
				totalBlinkTime = 5;
				this.setAlpha(1);
			}
			else
			{
				if(blinkTime < 0)
				{
					blink(blinkState);
		            blinkState = !blinkState;
		            blinkTime = 0.25f;
				}
			}
		}
	}
	public boolean getIsAlive()
	{
		return isAlive;
	}
	public int getLifes()
	{
		return currentLife;
	}
	public void respawn(float elapsedTime)
	{
		tankState = TankState.RESPAWN;
		respawnTime -= elapsedTime;
		if(respawnTime < 0)
		{
		this.isAlive = true;
		this.setVisible(true);
		this.setPosition(400,300);
		this.setRotation(-90);
		
		respawnTime = 2;
		}
		
	}
	public void blink(boolean state)
	{
		if(state)
		{
			this.setAlpha(0.25f);
		}
		else
		{
			this.setAlpha(1);
		}
	}
	public boolean collisionTest(Tank o1,GameObject o2)
	{
		
		String dir = o1.getDirection();
		char first = dir.charAt(0);
		switch(first)
		{
		case 'l':
			if(o1.getX() >= o2.getX())
			{
				return true;
			}
			break;
		case 'r':
			if(o1.getX() <= o2.getX())
			{
				return true;
			}
			break;
		case 'u':
			if(o1.getY() >= o2.getY())
			{
				return true;
			}
			break;
		case 'd':
			if(o1.getY() <= o2.getY())
			{
				return true;
			}
		
			
			
		}
		return false;
		
	}
	public void setNumberOfLifes(int lifes)
	{
		this.currentLife = lifes;
	}
	

}
