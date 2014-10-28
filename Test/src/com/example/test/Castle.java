package com.example.test;

import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.sprite.vbo.ISpriteVertexBufferObject;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class Castle extends Sprite implements GameObject {
	
	private boolean isAlive;

	public Castle(float pX, float pY,
			ITextureRegion pTextureRegion,
			VertexBufferObjectManager pSpriteVertexBufferObject) {
		super(pX, pY, pTextureRegion, pSpriteVertexBufferObject);
		isAlive = true;
		// TODO Auto-generated constructor stub
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
		this.isAlive = false;
		
		//game.gameOver();
	}

	@Override
	public boolean getIsAlive() {
		// TODO Auto-generated method stub
		return isAlive;
	}
	
}
