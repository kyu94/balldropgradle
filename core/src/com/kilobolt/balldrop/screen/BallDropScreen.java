package com.kilobolt.balldrop.screen;

import com.badlogic.gdx.Screen;
import com.kilobolt.balldrop.BallDropGame;

public abstract class BallDropScreen implements Screen {

	protected BallDropGame game;
	
	public BallDropScreen(BallDropGame game) {
		this.game = game;
	}
	
	@Override
	public void render(float delta) {
		handleInput();
		update(delta);
		draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
	
	protected abstract void update(float delta);
	
	protected abstract void draw();
	
	protected abstract void handleInput();

}
