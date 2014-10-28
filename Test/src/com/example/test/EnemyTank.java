package com.example.test;

import java.util.Random;

import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class EnemyTank extends Tank {

	private float moveTime;
	private float fireTime;
	private float totalMoveTime;
	private float totalFireTime;
	
	public EnemyTank(float x, float y, ITextureRegion tr,
			VertexBufferObjectManager o) {
		super(x, y, ResourcesManager.getInstance().enemy_region, o);
		moveTime = 1;
		totalMoveTime = 0;
		fireTime = 2;
		totalFireTime = 0;
		this.tankState = TankState.RUNNING; 
		// TODO Auto-generated constructor stub
	}
	@Override
	
	public void update(float elapsedTime)
	{
		Random rnd = new Random();
	   totalFireTime += elapsedTime;
		totalMoveTime += elapsedTime;
		fireTime -= elapsedTime;
		if(moveTime - totalMoveTime < 0.01)
		{
       
			moveTime = rnd.nextFloat() + 0.5f;
			int i = rnd.nextInt(5);
			totalMoveTime = 0;
			switch(i)
			{
			case 1: 
				this.setDirection("left");
				break;
			case 2:
				this.setDirection("right");
				break;
			case 3:
				this.setDirection("up");
				break;
			case 4:
				this.setDirection("down");
				break;
			default:
				break;
				
			}
		}
		this.move(this.getDirection());
		this.hit(currentObjects);
		if(fireTime < 0)
		{
		this.fire();
		this.fireTime = 2;
		}
	}  
	  
	
}
