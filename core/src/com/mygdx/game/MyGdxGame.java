package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.MenuState;
import com.mygdx.game.states.PlayState;

public class MyGdxGame extends ApplicationAdapter {

	public static final int WIDTH = 480;
	public static final int HEIGHT = 744;

	public static final String TITLE = "VIA";
	private GameStateManager gsm;
	private SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(173/255f, 231/255f, 255/255f, 1);
		//gsm.push(new StartState(gsm));
		gsm.push(new MenuState(gsm));
		//gsm.push(new PlayState(gsm, "Z5"));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	

}
