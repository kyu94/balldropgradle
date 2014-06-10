package com.kilobolt.balldrop.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class Rows extends GameObject{
	
	private Array<Brick> bricks;

	public Rows(float x, float y, float width, float height, float velX,
			float velY, int drawOrder) {
		super(x, y, width, height, velX, velY, drawOrder);
		// Must Create Bricks Here
		bricks = new Array<Brick>();
	}

	@Override
	public void draw(SpriteBatch batch) {
		return;
	}

	@Override
	public void updateGameObject(float delta) {
		for (Brick b : bricks) {
			b.updateGameObject(delta);
		}
	}

}
