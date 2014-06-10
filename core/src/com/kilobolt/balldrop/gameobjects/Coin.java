package com.kilobolt.balldrop.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.kilobolt.balldrop.assets.Assets;

public class Coin {

	private Vector2 position;
	private float width, height;
	private Rectangle rect;
	private boolean visible = false;

	public Coin(float x, float y, float width, float height) {
		position = new Vector2(x, y);
		this.width = width;
		this.height = height;
		this.rect = new Rectangle(x, y, width, height);
	}

	public void draw(SpriteBatch batch) {
		if (visible) {
			batch.draw(Assets.coin, position.x, position.y, width, height);
		}
	}

	public void update(float parentY) {
		position.y = parentY + height;
		rect.y = position.y;
	}

	public void reset(boolean parentVisible) {
		if (parentVisible && MathUtils.random(5) == 0) {
			visible = true;
		} else {
			visible = false;
		}
	}

	public void onCollide() {
		visible = false;
		Row.gameScreen.addCoinCount(1);
	}
	
	public boolean isVisible() {
		return visible;
	}

}
