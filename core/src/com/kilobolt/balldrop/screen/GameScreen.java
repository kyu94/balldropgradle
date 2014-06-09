package com.kilobolt.balldrop.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kilobolt.balldrop.BallDropGame;


public class GameScreen extends BallDropScreen {
	
	SpriteBatch batch;
	OrthographicCamera camera;
	
	public GameScreen(BallDropGame game) {
		super(game);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void draw() {
		Gdx.gl20.glClearColor(0, 0, 0, 1);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
	}

	@Override
	protected void handleInput() {
		// TODO Auto-generated method stub
		
	}

}
