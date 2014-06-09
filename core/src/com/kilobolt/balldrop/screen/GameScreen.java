package com.kilobolt.balldrop.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.kilobolt.balldrop.BallDropGame;
import com.kilobolt.balldrop.gameobjects.GameObject;


public class GameScreen extends BallDropScreen {
	
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Array<GameObject> gameObjects;
	
	public GameScreen(BallDropGame game, Array<GameObject> gameObjects) {
		super(game);
		this.gameObjects = gameObjects;
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 450);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void update(float delta) {
		for (GameObject gameObject : gameObjects) {
			gameObject.update(delta);
		}
	}

	@Override
	protected void draw() {
		Gdx.gl20.glClearColor(0, 0, 0, 1);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		
		for (GameObject gameObject: gameObjects) {
			gameObject.draw(batch);
		}
	}

	@Override
	protected void handleInput() {
		// TODO Auto-generated method stub
		
	}

}
