package com.kilobolt.balldrop.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.kilobolt.balldrop.assets.Assets;

public class Brick implements Collidable {

	private float x, y, width, height;
	private Rectangle rect;
	private Row row;
	private boolean visible = false;
	private Coin myCoin;

	public Brick(float x, float y, float width, float height, Row row) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		rect = new Rectangle(x, y, width, height);
		this.row = row;
		myCoin = new Coin(x + width / 2 - .3f / 2, y + .3f, .3f, .3f);
	}

	public void draw(SpriteBatch batch) {
		if (visible) {
			batch.draw(Assets.brick, x, y, width, height);
			myCoin.draw(batch);
		}
	}

	public void update(float delta) {
		y = row.getY();
		rect.y = y;
		myCoin.update(y);
	}

	public void reset() {
		int randNum = MathUtils.random(10);

		if (randNum < 3) {
			visible = true;
		} else {
			visible = false;
		}

		myCoin.reset(visible);
	}

	@Override
	public void onCollide(Jak jak) {
		if (myCoin.isVisible()) {			
			myCoin.onCollide();
		}
		
		jak.onCollide(rect);

	}

	public Rectangle getRect() {
		return rect;
	}

	public boolean isVisible() {
		return visible;
	}

}
