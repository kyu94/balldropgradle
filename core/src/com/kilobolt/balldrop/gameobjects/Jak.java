package com.kilobolt.balldrop.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.kilobolt.balldrop.assets.Assets;

public class Jak extends GameObject {

	private Circle circle;
	private static final float VEL_Y = -2;

	public Jak(float x, float y, float width, float height, float velX,
			int drawOrder) {
		super(x, y, width, height, velX, VEL_Y, drawOrder);
		circle = new Circle(velocity, width / 2);
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(Assets.jak, position.x, position.y, width, height);
	}

	@Override
	public void updateGameObject(float delta) {
		position.x += velocity.x * delta;
		position.y += velocity.y * delta;
		if (position.x < 0) {
			position.x = 0;
			velocity.x = 0;
		}

		if (position.x + width > 12) {
			position.x = 12 - width;
			velocity.x = 0;
		}

		if (position.y < 0) {
			position.y = 0;
			velocity.y = 0;
		} else {
			velocity.y = VEL_Y;
		}
		
		if (position.y > 6.75) {
			// death
		}
	}

	public void handleCollision(Row r) {
		r.handleCollision(circle, this);
	}

	public void setVelocity(float speed) {
		velocity.x = speed;
	}

	public void onCollide(Rectangle rect) {
		position.y = rect.y + rect.getHeight();

	}

}
