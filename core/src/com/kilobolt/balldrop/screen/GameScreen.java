package com.kilobolt.balldrop.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.kilobolt.balldrop.BallDropGame;
import com.kilobolt.balldrop.gameobjects.GameObject;
import com.kilobolt.balldrop.gameobjects.Jak;
import com.kilobolt.balldrop.gameobjects.Row;
import com.kilobolt.balldrop.input.BallDropInput;

public class GameScreen extends BallDropScreen {

	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Array<GameObject> gameObjects;
	private Jak jak;

	public GameScreen(BallDropGame game, Array<GameObject> gameObjects, Jak jak) {
		super(game);
		this.gameObjects = gameObjects;
		this.jak = jak;
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 12, 6.75f);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void update(float delta) {
		jak.update(delta);
		for (GameObject gameObject : gameObjects) {
			gameObject.update(delta);
			jak.handleCollision((Row) gameObject);
		}
	}

	@Override
	protected void draw() {
		Gdx.gl20.glClearColor(0, 0, 0, 1);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();

		jak.draw(batch);
		for (GameObject gameObject : gameObjects) {
			gameObject.draw(batch);
		}

		batch.end();
	}

	@Override
	protected void handleInput() {
		// TODO Auto-generated method stub
		if (BallDropInput.isPressed(BallDropInput.BUTTON_RIGHT)) {
			jak.setVelocity(2);
		}

		if (BallDropInput.isPressed(BallDropInput.BUTTON_LEFT)) {
			jak.setVelocity(-2);
		}

		if (BallDropInput.isPressed(BallDropInput.BUTTON_ENTER)) {

		}

		if (BallDropInput.isPressed(BallDropInput.BUTTON_ESC)) {

		}
	}

}
