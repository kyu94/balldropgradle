package com.kilobolt.balldrop.screen;

import com.badlogic.gdx.Gdx;
import com.kilobolt.balldrop.BallDropGame;
import com.kilobolt.balldrop.assets.Assets;

public class LoadScreen extends BallDropScreen {

	public static final String TAG = "LoadScreen";

	public LoadScreen(BallDropGame game) {
		super(game);
	}

	@Override
	public void show() {
		Assets.load();
	}

	@Override
	protected void handleInput() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void update(float delta) {
		if (BallDropGame.DEBUG) {
			Gdx.app.log(TAG, "" + Assets.getLoadProgress());
		}

		if (Assets.isLoaded()) {
			Assets.onLoadComplete();
			game.setScreen(new GameScreen(game));
		}
	}

	@Override
	protected void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

}
