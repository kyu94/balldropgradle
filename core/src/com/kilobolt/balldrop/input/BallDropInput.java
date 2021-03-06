package com.kilobolt.balldrop.input;

import java.util.Arrays;

public class BallDropInput {
	public static boolean[] keys;
	public static boolean[] pkeys;

	public static final int NUM_KEYS = 4;
	public static final int BUTTON_RIGHT = 0;
	public static final int BUTTON_LEFT = 1;
	public static final int BUTTON_ENTER = 2;
	public static final int BUTTON_ESC = 3;

	static {
		keys = new boolean[NUM_KEYS];
		pkeys = new boolean[NUM_KEYS];
	}

	public static void update() {
		for (int i = 0; i < NUM_KEYS; i++) {
			pkeys[i] = keys[i];
		}
	}

	public static void setKey(int i, boolean b) {
		keys[i] = b;
	}

	public static boolean isDown(int i) {
		return keys[i];
	}

	public static boolean isPressed(int i) {
		return keys[i] && !pkeys[i];
	}

}
