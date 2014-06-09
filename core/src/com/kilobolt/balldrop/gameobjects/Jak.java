package com.kilobolt.balldrop.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;

public class Jak extends GameObject {

	private Circle circle;

	public Jak(float x, float y, float width, float height, float velX,
			float velY, int drawOrder) {
		super(x, y, width, height, velX, velY, drawOrder);
		circle = new Circle(velocity, width / 2);
	}


	@Override
	public void draw(SpriteBatch batch) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateGameObject() {
		// TODO Auto-generated method stub
		
	}
	public boolean collides(GameObject other) {
		return Intersector.overlaps(circle, other.boundingBox);
	}

}
