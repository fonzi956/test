package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.sprites.Bird;
import com.mygdx.game.sprites.Buildings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PlayState extends State {

    private Bird bird;
    private Buildings mb1;
    private Buildings mb2;
    private Buildings mb3;
    private Buildings mb4;
    private Texture bg;
    private boolean bgc = false;

    SpriteBatch batch;
    BitmapFont font;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        mb1 = new Buildings(0, 330, "bmb.png");
        mb2 = new Buildings(0, 329, "sbg.png");
        mb3 = new Buildings(0, 333, "blueb.png");
        mb4 = new Buildings(0, 411, "clouds.png");
        bird = new Bird(0, 324);
        //cam.setToOrtho(false, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        //zooms in to the bird
        //cam.setToOrtho(false, MyGdxGame.WIDTH / 2, MyGdxGame.HEIGHT / 2);
        bg = new Texture("Orbackground.png");
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(1.2f);

        //zoom in to background
        cam.setToOrtho(false, bg.getWidth(), bg.getHeight());

        //tube = new Tube(100);
//        tubes = new Array<Tube>();
//
//        for (int i = 1; i <= TUBE_COUNT; i++){
//            tubes.add(new Tube(i * (TUBE_SPACING + TUBE_WIDTH)));
//        }
    }



    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            //changes the background color
            if(bgc == false){
                Gdx.gl.glClearColor(173/255f, 231/255f, 255/255f, 1);
                bgc = true;
            }
             else{
                Gdx.gl.glClearColor(33/255f, 61/255f, 90/255f, 1);
                bgc = false;
            }
            //bird.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        mb1.update(dt);
        mb2.update(dt);
        mb3.update(dt);
        mb4.update(dt);
        bird.update(dt);
        //cam.position.x = bird.getPosition().x + 80;

        //when the tubes are off the screen this will happen
        //this is in part 9 time 4:04
//        for (Tube tube : tubes){
//            if(cam.position.x - (cam.viewportWidth / 2) > tube.getPosTopTube().x + tube.getTopTube().getWidth()){
//                tube.reposition(tube.getPosTopTube().x + ((Tube.TUBE_WIDTH + TUBE_SPACING * TUBE_COUNT)));
//            }
//        }

        if(cam.position.x - (cam.viewportWidth / 2) > mb1.getPosition().x + mb1.getTexture().getWidth()){
            mb1.reposition(mb1.getPosition().x + 1500, mb1.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > mb2.getPosition().x + mb2.getTexture().getWidth()){
            mb2.reposition(mb2.getPosition().x + 1500, mb2.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > mb3.getPosition().x + mb3.getTexture().getWidth()){
            mb3.reposition(mb3.getPosition().x + 1500, mb3.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > mb4.getPosition().x + mb4.getTexture().getWidth()){
            mb4.reposition(mb4.getPosition().x + 1500, mb4.getPosition().y);
        }

//        if(cam.position.x - (cam.viewportWidth / 2) > bird.getPosition().x + bird.getTexture().getWidth()){
//            bird.reposition(mb2.getPosition().x + 1500, bird.getPosition().y);
//        }

        cam.update();


    }

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM d, y");
    LocalDateTime now = LocalDateTime.now();
    //need to add a date so like tomorrow
    String va = "VALID UNTIL";
    String ti = "" + dtf.format(now) +" 2:59 AM";
    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
//        for (Tube tube : tubes) {
//            sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
//            sb.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
//        }

        sb.draw(mb4.getTexture(), mb4.getPosition().x, mb4.getPosition().y);
        sb.draw(mb3.getTexture(), mb3.getPosition().x, mb3.getPosition().y);
        sb.draw(mb2.getTexture(), mb2.getPosition().x, mb2.getPosition().y);
        if(bgc == false){
            sb.draw(mb1.getTexture(), mb1.getPosition().x, mb1.getPosition().y);
        }
        sb.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        //sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
        //sb.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);

        sb.end();
        batch.begin();
        font.draw(batch, va, 100, 700);
        font.draw(batch, ti, 100, 670);
        batch.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        mb1.dispose();
        mb2.dispose();
        mb3.dispose();
        mb4.dispose();

    }
}
