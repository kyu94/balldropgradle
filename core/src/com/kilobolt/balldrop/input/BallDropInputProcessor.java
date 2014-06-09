package com.kilobolt.balldrop.input;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

public class BallDropInputProcessor extends InputAdapter {

	@Override
	public boolean keyDown(int keycode) {

		if (keycode == Keys.RIGHT) {
			BallDropInput.setKey(BallDropInput.BUTTON_RIGHT, true);
		}

		if (keycode == Keys.LEFT) {
			BallDropInput.setKey(BallDropInput.BUTTON_LEFT, true);
		}

		if (keycode == Keys.ENTER) {
			BallDropInput.setKey(BallDropInput.BUTTON_ENTER, true);
		}

		if (keycode == Keys.ESCAPE) {
			BallDropInput.setKey(BallDropInput.BUTTON_ESC, true);
		}

		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.RIGHT) {
			BallDropInput.setKey(BallDropInput.BUTTON_RIGHT, false);
		}

		if (keycode == Keys.LEFT) {
			BallDropInput.setKey(BallDropInput.BUTTON_LEFT, false);
		}

		if (keycode == Keys.ENTER) {
			BallDropInput.setKey(BallDropInput.BUTTON_ENTER, false);
		}

		if (keycode == Keys.ESCAPE) {
			BallDropInput.setKey(BallDropInput.BUTTON_ESC, false);
		}

		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

}
