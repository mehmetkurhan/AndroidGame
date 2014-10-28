package com.example.test;

import org.andengine.engine.Engine;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.IGameInterface.OnCreateSceneCallback;

public class SceneManager {
	
	 private BaseScene splashScene;
	 private BaseScene menuScene;
	 private BaseScene gameScene;
	 private BaseScene loadingScene;
	 private BaseScene gameOverScene;
	 
	 private static final SceneManager INSTANCE = new SceneManager();
	    
	    private SceneType currentSceneType = SceneType.SCENE_SPLASH;
	    
	    private BaseScene currentScene;
	    
	    private Engine engine = ResourcesManager.getInstance().engine;
	    
	    public enum SceneType
	    {
	        SCENE_SPLASH,
	        SCENE_MENU,
	        SCENE_GAME,
	        SCENE_LOADING,
	        SCENE_GAMEOVER 
	    }
	    public void loadGameScene(final Engine mEngine)
	    {
	    	
	    	 mEngine.registerUpdateHandler(new TimerHandler(0.1f, new ITimerCallback() 
	    	    {
	    	        public void onTimePassed(final TimerHandler pTimerHandler) 
	    	        {
	    	            mEngine.unregisterUpdateHandler(pTimerHandler);
	    	            ResourcesManager.getInstance().loadGameResources();
	    	            gameScene = new GameScene();
	    	            setScene(gameScene);
	    	        }
	    	    }));
	    	
	    }
	    public void setScene(BaseScene scene)
	    {
	        engine.setScene(scene);
	        currentScene = scene;
	        currentSceneType = scene.getSceneType();
	    }
	    
	    public void setScene(SceneType sceneType)
	    {
	        switch (sceneType)
	        {
	            case SCENE_MENU:
	                setScene(menuScene);
	                break;
	            case SCENE_GAME:
	                setScene(gameScene);
	                break;
	            case SCENE_SPLASH:
	                setScene(splashScene);
	                break;
	            case SCENE_LOADING:
	                setScene(loadingScene);
	                break;
	            default:
	                break;
	        }
	    }
	    
	    public static SceneManager getInstance()
	    {
	        return INSTANCE;
	    }
	    
	    public SceneType getCurrentSceneType()
	    {
	        return currentSceneType;
	    }
	    
	    public BaseScene getCurrentScene()
	    {
	        return currentScene;
	    }
	    public void createSplashScene(OnCreateSceneCallback pOnCreateSceneCallback)
	    { 
	        ResourcesManager.getInstance().loadSplashScreen();
	        splashScene = new SplashScene(); 
	        currentScene = splashScene;
	        pOnCreateSceneCallback.onCreateSceneFinished(splashScene);
	    }
	    private void disposeSplashScene()
	    {
	        ResourcesManager.getInstance().unloadSplashScreen();
	        splashScene.disposeScene();
	        splashScene = null;
	    }
	    public void createMenuScene()
	    {
	    	disposeSplashScene();
	        ResourcesManager.getInstance().loadMenuResources();
	        menuScene = new MainMenuScene();
	        setScene(menuScene);
	     //  currentScene = menuScene;
	        
	    }
	    public void createGameOverScene()
	    {
	    	//disposeGameScene();
	    	ResourcesManager.getInstance().loadGameOverScreen();
	    	gameOverScene = new GameOverScene();
	    	setScene(gameOverScene);
	    }
	    public void disposeGameScene()
	    {
	    	ResourcesManager.getInstance().unloadGameScreen();
	    	gameScene.disposeScene();
	    	gameScene = null;
	    	
	    }

}
