package com.kilobolt.balldrop.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kilobolt.balldrop.assets.Assets;

public class Coin extends GameObject implements Collidable {

	public Coin(float x, float y, float width, float height, float velX,
			float velY, int drawOrder) {
		super(x, y, width, height, velX, velY, drawOrder);
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(Assets.coin, position.x, position.y, width, height);
	}

	@Override
	public void updateGameObject(float delta) {
		
	}

	@Override
	public void onCollide(Jak jak) {
		// TODO Auto-generated method stub
		
	}

}
