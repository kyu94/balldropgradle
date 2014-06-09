package com.kilobolt.balldrop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.kilobolt.balldrop.input.BallDropInput;
import com.kilobolt.balldrop.screen.LoadScreen;

public class BallDropGame extends Game {

	public static final boolean DEBUG = true;
	
	@Override
	public void create() {
		Gdx.input.setInputProcessor(new BallDropInput());
		setScreen(new LoadScreen(this));
	}

}
