package com.example.test;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import com.example.test.SceneManager.SceneType;

public class GameOverScene extends BaseScene implements IOnMenuItemClickListener {
	
	private Sprite gameOver;
	@Override
	public void createScene() {
		// TODO Auto-generated method stub
		
		gameOver = new Sprite(0, 0, resourcesManager.gameOver_region, vbom)
		{
		    @Override
		    protected void preDraw(GLState pGLState, Camera pCamera) 
		    {
		       super.preDraw(pGLState, pCamera);
		       pGLState.enableDither();
		    }
		};
		attachChild(gameOver);
		createChildSene();
		
		
	}

	@Override
	public void onBackKeyPressed() {
		System.exit(0);
		// TODO Auto-generated method stub
		
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return SceneType.SCENE_GAMEOVER;
	}

	@Override
	public void disposeScene() {
		gameOver.detachSelf();
		gameOver.dispose();
		// TODO Auto-generated method stub
		
	}
	private MenuScene menuChildScene;
	private final int MENU_PLAY = 0;
	private final int MENU_QUIT = 1;
	private void createChildSene()
	{
	menuChildScene = new MenuScene(camera);
    menuChildScene.setPosition(200, 240);
    
    final IMenuItem playMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_PLAY, resourcesManager.replay_region, vbom), 1.2f, 1);
    final IMenuItem optionsMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_QUIT, resourcesManager.quit_region, vbom), 1.2f, 1);
    
    menuChildScene.addMenuItem(playMenuItem);
    menuChildScene.addMenuItem(optionsMenuItem);
    
    menuChildScene.buildAnimations();
    menuChildScene.setBackgroundEnabled(false);
    
    playMenuItem.setPosition(0,50);
    optionsMenuItem.setPosition(250,50);
    
    menuChildScene.setOnMenuItemClickListener(this);
    
    setChildScene(menuChildScene);
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) {
		// TODO Auto-generated method stub
		switch(pMenuItem.getID())
		{
		case MENU_PLAY:
			  Game.getInstance().startGame(); 
		case MENU_QUIT:
			System.exit(0);
		default:
			return false;
		}
		
	}

}
