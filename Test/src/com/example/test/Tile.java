package com.example.test;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class Tile extends Sprite implements GameObject {
 
	private GameObjectType type;
	private boolean isAlive;
	public Tile(float pX, float pY,
			ITextureRegion pTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pX, pY,  pTextureRegion, pVertexBufferObjectManager);
		isAlive = true;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setPosition(Vector2 pos) {
		// TODO Auto-generated method stub
		
	}

	protected void setType(GameObjectType type)
	{
		this.type = type;
	}
	public GameObjectType getType()
	{
		return this.type;
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
		this.isAlive = false;
	}

	@Override
	public boolean getIsAlive() {
		// TODO Auto-generated method stub
		return isAlive;
	}
	

}
