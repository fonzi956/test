package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.sprites.Bird;
import com.mygdx.game.sprites.Buildings;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.*;

public class PlayState extends State {

    private Bird bird;
    private Buildings mb1;
    private Buildings mb2;
    private Buildings mb3;
    private Buildings sb1;
    private Buildings sb2;
    private Buildings bb;
    private Buildings cl;
    private Buildings tr;
    private Buildings trd;
    private Texture bg;
    private String va;
    private String mn;
    private String ti;
    private boolean bgc = false;

    SpriteBatch batch;
    BitmapFont font;
    BitmapFont bfont;


    public PlayState(GameStateManager gsm) {
        super(gsm);

        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 1);
        mn = new SimpleDateFormat("MMM dd, yyyy").format(c.getTime());

        va = "VALID UNTIL";
        ti = mn + " 2:59 AM";
        mb1 = new Buildings(0, 330, "tower.png");
        mb2 = new Buildings(400, 330, "redthing.png");
        mb3 = new Buildings(750, 330, "alamo.png");
        tr = new Buildings(0, 329, "trees.png");
        trd = new Buildings(0, 329, "treesD.png");
        sb1 = new Buildings(-100, 329, "hotelbackbuilding.png");
        sb2 = new Buildings(500, 329, "twobackbuildings.png");
        bb = new Buildings(0, 333, "blueb.png");
        cl = new Buildings(0, 411, "clouds.png");
        bird = new Bird(0, 324);
        //cam.setToOrtho(false, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        //zooms in to the bird
        //cam.setToOrtho(false, MyGdxGame.WIDTH / 2, MyGdxGame.HEIGHT / 2);
        bg = new Texture("tworiders.png");//Orbackground
        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("myfont.fnt"));
        bfont = new BitmapFont(Gdx.files.internal("myBlodfont.fnt"));
        bfont.setColor(Color.WHITE);
        font.setColor(Color.WHITE);
        //font.getData().setScale(1.2f);

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
        tr.update(dt);
        trd.update(dt);
        sb1.update(dt);
        sb2.update(dt);
        bb.update(dt);
        cl.update(dt);
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

        if(cam.position.x - (cam.viewportWidth / 2) > tr.getPosition().x + tr.getTexture().getWidth()){
            tr.reposition(tr.getPosition().x + 1500, tr.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > tr.getPosition().x + trd.getTexture().getWidth()){
            trd.reposition(trd.getPosition().x + 1500, trd.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > sb1.getPosition().x + sb1.getTexture().getWidth()){
            sb1.reposition(sb1.getPosition().x + 1600, sb1.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > sb2.getPosition().x + sb2.getTexture().getWidth()){
            sb2.reposition(sb2.getPosition().x + 1600, sb2.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > bb.getPosition().x + bb.getTexture().getWidth()){
            bb.reposition(bb.getPosition().x + 1500, bb.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > cl.getPosition().x + cl.getTexture().getWidth()){
            cl.reposition(cl.getPosition().x + 1500, cl.getPosition().y);
        }

//        if(cam.position.x - (cam.viewportWidth / 2) > bird.getPosition().x + bird.getTexture().getWidth()){
//            bird.reposition(mb2.getPosition().x + 1500, bird.getPosition().y);
//        }

        cam.update();


    }




    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(cam.combined);
        sb.begin();

//        for (Tube tube : tubes) {
//            sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
//            sb.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
//        }

        sb.draw(cl.getTexture(), cl.getPosition().x, cl.getPosition().y);
        sb.draw(bb.getTexture(), bb.getPosition().x, bb.getPosition().y);
        sb.draw(sb1.getTexture(), sb1.getPosition().x, sb1.getPosition().y);
        sb.draw(sb2.getTexture(), sb2.getPosition().x, sb2.getPosition().y);
        sb.draw(mb1.getTexture(), mb1.getPosition().x, mb1.getPosition().y);
        sb.draw(mb2.getTexture(), mb2.getPosition().x, mb2.getPosition().y);
        sb.draw(mb3.getTexture(), mb3.getPosition().x, mb3.getPosition().y);
        if(bgc == false){
            sb.draw(tr.getTexture(), tr.getPosition().x, tr.getPosition().y);
        }
        if(bgc == true){
            sb.draw(trd.getTexture(), trd.getPosition().x, trd.getPosition().y);
        }
        sb.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        //sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
        //sb.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
        sb.draw(bg, 0,0);
        sb.end();
        batch.begin();
        //desktop
//        font.draw(batch, va, 100, 700);
//        font.draw(batch, ti, 100, 670);
        //phone
//        font.draw(batch, va, 235, 1063);
//        bfont.draw(batch, ti, 85, 1024);

        //phone with two riders
        font.draw(batch, va, 235, 1058);
        bfont.draw(batch, ti, 85, 1018);
        batch.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        mb1.dispose();
        mb2.dispose();
        mb3.dispose();
        tr.dispose();
        trd.dispose();
        sb1.dispose();
        sb2.dispose();
        bb.dispose();
        cl.dispose();

    }
}
