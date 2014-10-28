package com.example.test;

import java.util.ArrayList;
import java.util.List;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.util.color.Color;

import com.example.test.SceneManager.SceneType;

public class GameScene extends BaseScene implements IOnSceneTouchListener {
	
	
	public Castle castle;
	public Bullet bullet;
	private boolean touched = false;
	public String direction ="left";
	private Rectangle boundaryPoints;
	private Font font;
	private Wall wall;
	private float totalTime;
	private Tank tank;
	private MenuScene controls;
	@Override
	
	public void createScene() {
		// TODO Auto-generated method stub
		totalTime = 0;
		createBackground();
		//bullet = new Bullet(600,400,ResourcesManager.getInstance().bullet_region,vbom);
		registerUpdateHandler(new GameLoopUpdateHandler());
		this.setOnSceneTouchListener(this);
		boundaryPoints = new Rectangle(0,0,760,440,vbom);
	    tank = Game.getInstance().getTank();
	   // createControls();
	 
	
//	    etank.setCurrentObjects(list);
	//    etank2.setCurrentObjects(list);

	}

	@Override
	public void onBackKeyPressed() {
		// TODO Auto-generated method stub
		System.exit(0);
	
		
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return SceneType.SCENE_GAME;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		
	}
	private void createBackground()
	{
		setBackground(new Background(Color.BLACK));
	}

	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
		
		
	    
		if(pSceneTouchEvent.isActionDown())
		{
			float touchX = pSceneTouchEvent.getX();
			float touchY = pSceneTouchEvent.getY();
			if(touchX > 600 && touchY > 400)
			{
				tank.fire();
			}
			else
			{
			if(touchX - tank.getX() > 0)
			{
				if(touchX - tank.getX() > Math.abs(touchY - tank.getY()))
				{
					tank.setDirection("right");
				}
				else
				{
					if(touchY - tank.getY() > 0)
					{
						tank.setDirection("down");
					}
					else
					{
						tank.setDirection("up");
					}
				}
			}
			else
			{
				if(Math.abs(touchX - tank.getX()) > Math.abs(touchY - tank.getY()))
				{
					tank.setDirection("left");
				}
				else
				{
					if(touchY - tank.getY() > 0)
					{
						tank.setDirection("down");
					}
					else
					{
						tank.setDirection("up");
					}
				}
			}
		}
		}
	
		return false;
	}
	
	public String getTouchDirection()
	{
		return direction;
	}
	
	
	



}
