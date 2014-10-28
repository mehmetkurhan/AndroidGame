package com.example.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;

import android.graphics.Point;
import android.graphics.PointF;
import android.util.Log;

public class Game {
	public enum GameState
	{
		RUNNING,
		PAUSED,
		ENDED,
		GAMEOVER
	}
	private LinkedList<Level> levels;
	private Level currentLevel;
	private int numberOfTanks;
	private static List<Tank> allTanks;
	private List<Tank> currentTanks;
	private List<PointF> enemyRespawnPoints;
	private PointF respawnPoint;
	private static Tank tank;
	private EnemyTank etank;
	private ArrayList<GameObject> allGameObjects;
	private List<GameObject> aliveObjects;
	private GameState gameState;
	private int numberOfLifes;
	private GameScene scene;
	private Text t;
	private Text lifeText;
	private Text pauseText;
	private static final Game Instance = new Game();
	private float totalTime;
	private Castle castle;
	private Sprite arrow_up;
	private Sprite arrow_down;
	private Sprite arrow_left;
	private Sprite arrow_right;

  
	public void startGame()
	{
		this.gameState = GameState.RUNNING;
		totalTime = 0;
		initialize();
	
		
	}
	public void gameOver()
	{
		 
		SceneManager.getInstance().createGameOverScene();
	}
	public static Game getInstance()
	{
		return Instance;
	}
	public void gameEnded()
	{
		if(!levels.iterator().hasNext() && currentLevel.isCompleted())
		{
			this.gameState = GameState.ENDED;
		}
		
	}
	
	public void update(float elapsedTime)
	{
		totalTime+= elapsedTime;
		lifeText.setText("Life:"+tank.getLifes());
		if(currentLevel.isCompleted())
		{
			this.gameState = GameState.PAUSED;
		}
	
		if(this.gameState == GameState.RUNNING)
		{
	    for(GameObject o : allGameObjects)
	        {
	    		o.update(elapsedTime);
	    	

	        }
		}
		else if(this.gameState == GameState.PAUSED)
		{
			
		}
		else
		{
			
		}
		
	}
	
	private void initialize()
	{
		numberOfLifes = 3;
		scene = new GameScene();
	 	ResourcesManager.getInstance().loadGameResources();
		enemyRespawnPoints = new ArrayList<PointF>();
		allGameObjects = new ArrayList<GameObject>();
		allTanks = new ArrayList<Tank>();
		currentLevel = new Level(1);
		respawnPoint = new PointF(400,300);
		PointF enemyRespawnPoint1 = new PointF(50,200);
		PointF enemyRespawnPoint2 = new PointF(400,50);
		PointF enemyRespawnPoint3 = new PointF(700,200);
		PointF enemyRespawnPoint4 = new PointF(90,200);
		PointF enemyRespawnPoint5 = new PointF(400,90);
		PointF enemyRespawnPoint6 = new PointF(700,260);
		enemyRespawnPoints.add(enemyRespawnPoint1);
		enemyRespawnPoints.add(enemyRespawnPoint2);
		enemyRespawnPoints.add(enemyRespawnPoint3);
		enemyRespawnPoints.add(enemyRespawnPoint4);
		enemyRespawnPoints.add(enemyRespawnPoint5);
		enemyRespawnPoints.add(enemyRespawnPoint6);
		castle = new Castle(370,410,ResourcesManager.getInstance().castle_region,scene.vbom);
		t = new Text(10,30,ResourcesManager.getInstance().f ,"Time:",100,scene.vbom);
		lifeText = new Text(600,30,ResourcesManager.getInstance().f,"Life:",100,scene.vbom);
		/*
		arrow_left = new Sprite(5,375,ResourcesManager.getInstance().arrow_left_region,scene.vbom);
		arrow_right = new Sprite(75,375,ResourcesManager.getInstance().arrow_right_region,scene.vbom);
		arrow_up = new Sprite(40,345,ResourcesManager.getInstance().arrow_up_region,scene.vbom);
		arrow_down = new Sprite(40,405,ResourcesManager.getInstance().arrow_down_region,scene.vbom);
		arrow_left.setScale(0.5f);
		arrow_right.setScale(0.5f);
		arrow_up.setScale(0.5f);
		arrow_down.setScale(0.5f);
		arrow_left.setAlpha(0.5f);
		arrow_right.setAlpha(0.5f);
		arrow_up.setAlpha(0.5f);
		arrow_down.setAlpha(0.5f);
		*/
		tank = new Tank(respawnPoint.x,respawnPoint.y,ResourcesManager.getInstance().tank_region,scene.vbom);
		tank.setNumberOfLifes(numberOfLifes);
		allGameObjects.add(tank);
		allTanks.add(tank);
	  
		for(int i = 0; i < enemyRespawnPoints.size();i++)
		{
			etank = new EnemyTank(enemyRespawnPoints.get(i).x,enemyRespawnPoints.get(i).y,ResourcesManager.getInstance().tank_region,scene.vbom);
			allGameObjects.add(etank);
			allTanks.add(etank);
		}
		ArrayList<Tile> tileList = currentLevel.tile(scene.vbom);
		
		for(int i=0; i < tileList.size();i++)
		{
			if(tileList.get(i) != null)
			{
			allGameObjects.add(tileList.get(i));
			}
		}
		
		Log.i("-------------------------------------------", Integer.toString(allTanks.size()) );
		
		for(int i = 0; i < allGameObjects.size();i++)
		{
			if(allGameObjects.get(i) instanceof Tank)
			{
				scene.attachChild(((Tank)allGameObjects.get(i)).getBullet());
				
			}   
			scene.attachChild(allGameObjects.get(i));
			
		}      
	   for(int i = 0; i < allTanks.size();i++)
	   {
		   allTanks.get(i).setCurrentObjects(allGameObjects);
	   }
	   allGameObjects.add(castle);
	   scene.attachChild(castle);
	   scene.attachChild(t);
	   scene.attachChild(lifeText);
	   scene.createScene();
	   SceneManager.getInstance().setScene(scene);
		
	
	}
	public static Tank getTank()
	{
		return tank;
	}
	public static List<Tank> getAllTanks()
	{
		return allTanks;
	}
	public void onBeginning()
	{
		this.gameState = GameState.PAUSED;
		
		
	}
	public void started()
	{

	}
	public void onPaused()
	{
		
	}
	public void onResumed()
	{
		
	}
	public void onExit()
	{
		
	}
	public void makeSmall(float scaleFactor)
	{
		for(int i = 0; i < this.allGameObjects.size();i++)
		{
			allGameObjects.get(i).setScale(scaleFactor);
		}
	}
	
	
	

}

