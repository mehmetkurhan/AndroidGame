package com.example.test;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class Wall extends Tile{

	private GameObjectType type;
	private boolean isAlive;
	public Wall(float pX, float pY,
			ITextureRegion pTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pX, pY, pTextureRegion, pVertexBufferObjectManager);
		// TODO Auto-generated constructor stub
		isAlive = true;
		//this.setScale(0.5f);
		this.setWidth(32);
		this.setHeight(32);
		this.type = GameObjectType.WEAK;
	
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

	@Override
	public void die() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		this.isAlive =false;
	
		
	}

	@Override
	public boolean getIsAlive() {
		// TODO Auto-generated method stub
		return isAlive;
	}

}
