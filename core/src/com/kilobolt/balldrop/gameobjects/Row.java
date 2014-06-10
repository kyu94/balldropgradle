package com.kilobolt.balldrop.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.utils.Array;
import com.kilobolt.balldrop.screen.GameScreen;

public class Row extends GameObject {
	
	private Array<Brick> bricks;
	private Row reference;
	private float gapDistance = 1.8f;
	public static GameScreen gameScreen;

	public Row(float x, float y, float width, float height, float velX,
			float velY, int drawOrder) {
		super(x, y, width, height, velX, velY, drawOrder);
		// Must Create Bricks Here
		bricks = new Array<Brick>();
		for (int i = 0; i < 12; i++) {
			Brick brick = new Brick(i, y, 1, height, this);
			bricks.add(brick);
		}
	}

	@Override
	public void draw(SpriteBatch batch) {
		for (Brick b : bricks) {
			b.draw(batch);
		}
	}

	@Override
	public void updateGameObject(float delta) {
		position.y += velocity.y * delta;
		if (position.y >= 7.75) {
			reset();
		}
		for (Brick b : bricks) {
			b.update(delta);
		}
	}
	
	public boolean handleCollision(Circle circ, Jak jak) {
		for (Brick b : bricks) {
			if (b.isVisible() && Intersector.overlaps(circ, b.getRect())) {
				b.onCollide(jak);
				return true;
			}
		}
		
		return false;
	}

	public float getY() {
		return position.y;
	}

	public void setReference(Row ref) {
		this.reference = ref;
	}

	public void reset() {
		gameScreen.addScore(1);
		position.y = reference.position.y - gapDistance;
		for (Brick b : bricks) {
			b.reset();
		}
	}

}
