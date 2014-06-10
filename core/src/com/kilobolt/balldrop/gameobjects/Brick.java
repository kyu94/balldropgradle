package com.kilobolt.balldrop.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kilobolt.balldrop.assets.Assets;

public class Brick extends GameObject{

	public Brick(float x, float y, float width, float height, float velX,
			float velY, int drawOrder) {
		super(x, y, width, height, velX, velY, drawOrder);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(Assets.brick, position.x, position.y, width, height);
	}

	@Override
	public void updateGameObject() {
		// TODO Auto-generated method stub
		
	}

}