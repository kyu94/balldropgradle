package com.kilobolt.balldrop.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.kilobolt.balldrop.BallDropGame;
import com.kilobolt.balldrop.assets.Assets;
import com.kilobolt.balldrop.gameobjects.GameObject;

public class LoadScreen extends BallDropScreen {

	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Array<GameObject> gameObjects;
	
	public static final String TAG = "LoadScreen";


	public LoadScreen(BallDropGame game) {
		super(game);
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 450);
		Assets.load();
		gameObjects = new Array<GameObject>();
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
			gameObjects.sort(GameObject.GameObjectComperator);
			game.setScreen(new GameScreen(game, gameObjects));
		}
	}

	@Override
	protected void draw() {
		Gdx.gl20.glClearColor(0, 0, 0, 1);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

}
