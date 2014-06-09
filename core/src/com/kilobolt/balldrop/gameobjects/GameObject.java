package com.kilobolt.balldrop.gameobjects;

import java.util.Comparator;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject implements Comparable<GameObject> {

	protected Vector2 position;
	protected float width, height;
	protected Vector2 velocity;
	protected int drawOrder;

	public GameObject(float x, float y, float width, float height, float velX,
			float velY, int drawOrder) {
		position = new Vector2(x, y);
		velocity = new Vector2(velX, velY);
		this.width = width;
		this.height = height;
		this.drawOrder = drawOrder;
	}

	public abstract void update(float delta);

	public abstract void draw(SpriteBatch batch);

	@Override
	public int compareTo(GameObject other) {
		return this.drawOrder - other.drawOrder;
	}

	public static Comparator<GameObject> GameObjectComperator = new Comparator<GameObject>() {

		@Override
		public int compare(GameObject gameObject1, GameObject gameObject2) {
			return gameObject1.compareTo(gameObject2);
		}

	};

}