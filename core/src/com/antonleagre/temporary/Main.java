package com.antonleagre.temporary;

import com.antonleagre.temporary.states.GSM;
import com.antonleagre.temporary.states.MenuState;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.logging.Logger;

public class Main extends Game {

	//application vars
	public static final boolean DEBUG = true;
	public static final int V_WIDTH = 640;
	public static final int V_HEIGHT = 480;
	public static final String TITLE = "Temporary";

	public static final float FPS =  1f / 60f;
	public static final int PPM = 50;

	private SpriteBatch sb;
	private GSM gsm;
	private AssetManager asm;

	//used for fixed step gameloop
	private double accumulator = 0;


	public void loadTextures(){
		asm.load("badlogic.jpg", Texture.class);
		asm.finishLoading();
	}
	@Override
	public void create () {
		sb = new SpriteBatch();
		gsm = new GSM(this);
		asm = new AssetManager();
		loadTextures();
		gsm.pushState(new MenuState(gsm, asm));

	}


	@Override
	public void render () {
		//rendering using fixed timesteps (for box2d),
		//actual rendering happens by the gsm
		accumulator += Gdx.graphics.getDeltaTime();
		while(accumulator >= FPS){
			accumulator -= FPS;
			gsm.update(Gdx.graphics.getDeltaTime());
			gsm.render(sb);
		}



	}

	@Override
	public void dispose() {
		gsm.dispose();
	}

	public SpriteBatch getSpriteBatch() {
		return sb;
	}
}
