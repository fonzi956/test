package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class MenuState extends State implements Input.TextInputListener {
    private Texture background;
    //private Texture playBtn;
    public String text;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        //MyTextInputListener listener = new MyTextInputListener();
        Gdx.input.getTextInput(this, "Title", "", "");
        //cam.setToOrtho(false, MyGdxGame.WIDTH / 2, MyGdxGame.HEIGHT / 2);
        background = new Texture("inUse.png");
        cam.setToOrtho(false, background.getWidth(), background.getHeight());
        //playBtn = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm, text));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        //how it is draw in the screen
        //sb.draw(background, 0,175, MyGdxGame.WIDTH, MyGdxGame.HEIGHT-250);
        //sb.draw(background, 0,0, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        sb.draw(background, 0, 0);
        //sb.draw(playBtn, (MyGdxGame.WIDTH / 2) - (playBtn.getWidth() / 2), MyGdxGame.HEIGHT / 2);
        //draws the button
        //sb.draw(playBtn, cam.position.x - playBtn.getWidth() / 2, cam.position.y);
        sb.end();
    }

    @Override
    public void dispose(){
        background.dispose();
        //playBtn.dispose();
    }

    @Override
    public void input (String text) {
        this.text = text;
    }

    @Override
    public void canceled () {
        text = "E5";
    }
}
