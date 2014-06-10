package com.kilobolt.balldrop.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.kilobolt.balldrop.assets.Assets;

public class Jak extends GameObject {

	private Circle circle;

	public Jak(float x, float y, float width, float height, float velX,
			float velY, int drawOrder) {
		
		super(x, y, width, height, velX, velY, drawOrder);
		circle = new Circle(velocity, width / 2);
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(Assets.jak, position.x, position.y, width, height);
	}

	@Override
	public void updateGameObject(float delta) {
		// TODO Auto-generated method stub
		
	}
	
	public void handleCollision(Row r) {
		r.handleCollision(circle, this);
	}
	
	public void setVelocity(float speed) {
		velocity.x = speed;
	}

}
