package com.kilobolt.balldrop.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	public static AssetManager manager;

	public static TextureRegion jak;
	public static TextureRegion coin;
	public static TextureRegion brick;

	public static void load() {
		manager = new AssetManager();
		manager.load("data/texture.png", Texture.class);
	}

	public static void onLoadComplete() {
		Texture texture = (Texture) manager.get("data/texture.png");
		jak = new TextureRegion(texture, 0, 0, 256, 256);
		coin = new TextureRegion(texture, 256, 0, 256, 256);
		brick = new TextureRegion(texture, 0, 256, 64, 64);
	}

	public static boolean isLoaded() {
		return manager.update();
	}

	public static float getLoadProgress() {
		return manager.getProgress();
	}
}
