package com.kilobolt.balldrop.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.kilobolt.balldrop.assets.Assets;

public class Brick implements Collidable {
	
	private float x, y, width, height;
	private Rectangle rect;
	private Row row;

	public Brick(float x, float y, float width, float height, Row row) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		rect = new Rectangle(x, y, width, height);
		this.row = row;
	}

	public void draw(SpriteBatch batch) {
		batch.draw(Assets.brick, x, y, width, height);
	}

	public void update(float delta) {
		y = row.getY();
	}

	@Override
	public void onCollide(Jak jak) {
		// TODO Auto-generated method stub
		
	}

	public Rectangle getRect() {
		return rect;
	}

}
