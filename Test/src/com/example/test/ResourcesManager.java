package com.example.test;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.font.FontManager;
import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

import android.content.res.AssetManager;
import android.graphics.Color;

public class ResourcesManager {
	
	private static final ResourcesManager INSTANCE = new ResourcesManager();
	
	 public Engine engine;
	    public MainActivity activity;
	    public Camera camera;
	    public VertexBufferObjectManager vbom;
	    public ITextureRegion splash_region;
	    private BitmapTextureAtlas splashTextureAtlas;
	    private BuildableBitmapTextureAtlas gameOverTextureAtlas;
	    public ITextureRegion menu_background_region;
	    public ITextureRegion play_region;
	    public ITextureRegion replay_region;
	    public ITextureRegion options_region;
	    public ITextureRegion tank_region;
	    public ITextureRegion bullet_region;
	    public ITextureRegion enemy_region;
	    public ITextureRegion castle_region;
	    public ITextureRegion wall_region;
	    public ITextureRegion gameOver_region;
	    public ITextureRegion steel_region;
	    public ITextureRegion quit_region;
	    public ITextureRegion arrow_left_region;
	    public ITextureRegion arrow_right_region;
	    public ITextureRegion arrow_up_region;
	    public ITextureRegion arrow_down_region;
	    private BuildableBitmapTextureAtlas gameTextureAtlas;
	    
	    public TextureManager t;
	    public FontManager fontManager;
	    public Font f;
	    public AssetManager assetManager;
	        
	    private BuildableBitmapTextureAtlas menuTextureAtlas;
	    
	    public void loadMenuResources()
	    {
	        loadMenuGraphics();
	        loadMenuAudio();
	    }
	    
	    public void loadGameResources()
	    {
	        loadGameGraphics();
	        loadGameFonts();
	        loadGameAudio();
	    }
	   
	    
	    private void loadMenuGraphics()
	    {
	    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
	    	menuTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
	    	menu_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "menu_background.png");
	    	play_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "play.png");
	    	options_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "options.png");
	    	try 
	    	{
	    	    this.menuTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
	    	    this.menuTextureAtlas.load();
	    	} 
	    	catch (final TextureAtlasBuilderException e)
	    	{
	    	        Debug.e(e);
	    	}
	    }
	    
	    private void loadMenuAudio()
	    {
	        
	    }

	    private void loadGameGraphics()
	    {
	    	 gameTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
	        tank_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas,activity,"tank.png");
	        bullet_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas,activity,"bullet.png");
	        enemy_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas,activity,"enemy.png");
	        castle_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas,activity,"eagle.png");
	        wall_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas,activity,"duvar.png");
	        steel_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas,activity,"duvar2.png");
	        arrow_left_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas,activity,"arrow_left.png");
	        arrow_right_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas,activity,"arrow_right.png");
	        arrow_up_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas,activity,"arrow_up.png");
	        arrow_down_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas,activity,"arrow_down.png");
	        try 
	        {
	            this.gameTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
	            this.gameTextureAtlas.load();
	        } 
	        catch (final TextureAtlasBuilderException e)
	        {
	            Debug.e(e);
	        }
	        f = FontFactory.createStrokeFromAsset(this.fontManager, new BitmapTextureAtlas(this.t,256,256,TextureOptions.BILINEAR_PREMULTIPLYALPHA), assetManager, "showcase.ttf", 50, true, Color.WHITE, 2, Color.BLACK);
		    f.load();
	        
	    }
	    
	    private void loadGameFonts()
	    {
	        
	    }
	    
	    private void loadGameAudio()
	    {
	        
	    }
	    
	    public void loadSplashScreen()
	    {
	    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
	    	splashTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(),960,512, TextureOptions.BILINEAR);
	    	splash_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(splashTextureAtlas, activity, "splash.png", 0, 0);
	    	splashTextureAtlas.load();
	    	
	    }
	    
	    public void unloadSplashScreen()
	    {
	    	splashTextureAtlas.unload();
	    	splash_region = null;
	    }
	    public void unloadGameScreen()
	    {
	    	gameTextureAtlas.unload();
	    	tank_region = null;
	    	bullet_region = null;
	    	enemy_region = null;
	    	castle_region = null;
	    	wall_region = null;
	    }
	    
	    public static void prepareManager(Engine engine, MainActivity activity, Camera camera, VertexBufferObjectManager vbom,TextureManager textureManager,AssetManager assetManager,FontManager fm)
	    {
	        getInstance().engine = engine;
	        getInstance().activity = activity;
	        getInstance().camera = camera;
	        getInstance().vbom = vbom;
	        getInstance().t = textureManager;
	        getInstance().assetManager = assetManager;
	        getInstance().fontManager = fm;
	    }
	    public void loadGameOverScreen()
	    {
	    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
	    	gameOverTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(),1024,1024, TextureOptions.BILINEAR);
	    	gameOver_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOverTextureAtlas, activity, "gameover.png");
	    	replay_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOverTextureAtlas, activity, "replay.png");
	    	quit_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameOverTextureAtlas, activity, "quit.png");
	    	try 
	        {
	            this.gameOverTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
	            this.gameOverTextureAtlas.load();
	        } 
	        catch (final TextureAtlasBuilderException e)
	        {
	            Debug.e(e);
	        }
	    }
	    
	    //---------------------------------------------
	    // GETTERS AND SETTERS
	    //---------------------------------------------
	    
	    public static ResourcesManager getInstance()
	    {
	        return INSTANCE;
	    }

}
