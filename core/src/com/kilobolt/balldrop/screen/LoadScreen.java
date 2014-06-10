package com.kilobolt.balldrop.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.kilobolt.balldrop.BallDropGame;
import com.kilobolt.balldrop.assets.Assets;
import com.kilobolt.balldrop.gameobjects.GameObject;
import com.kilobolt.balldrop.gameobjects.Jak;
import com.kilobolt.balldrop.gameobjects.Row;

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
		camera.setToOrtho(false, 12, 6.75f);
		Assets.load();
		gameObjects = new Array<GameObject>();
		for (int i = 0; i < 6; i++) {
			Row row = new Row(0, -1.8f * i, 12, .33f, 0, 3, GameObject.DRAW_ORDER_FOREGROUND);
			gameObjects.add(row);
		}
	}

	@Override
	protected void handleInput() {

	}

	@Override
	protected void update(float delta) {
		if (BallDropGame.DEBUG) {
			Gdx.app.log(TAG, "" + Assets.getLoadProgress());
		}

		if (Assets.isLoaded()) {
			Assets.onLoadComplete();
			gameObjects.sort(GameObject.GameObjectComperator);
			game.setScreen(new GameScreen(game, gameObjects, new Jak(6 - .375f, 6, .75f, .75f, 0, 0, GameObject.DRAW_ORDER_FOREGROUND)));
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

	}

}
