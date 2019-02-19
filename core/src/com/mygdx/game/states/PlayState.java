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
    private Buildings gr;
    private Buildings grd;
    private Buildings tr;
    private Buildings trd;
    private Texture bg;
    private Texture bbe;
    private String va;
    private String mn;
    private String ti;
    private String ri;
    int num = 0;
    private boolean bgc = true;
    private  boolean posi;
    private Buildings bcl, lcl,scl, slcl, tcl;

    SpriteBatch batch;
    BitmapFont font;
    BitmapFont bfont;


    public PlayState(GameStateManager gsm, String text) {
        super(gsm);

        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 1);
        mn = new SimpleDateFormat("MMM dd, yyyy").format(c.getTime());
        va = "VALID UNTIL";
        ti = mn + " 2:59 AM";
        if(text.length() == 2){
            ri = text;
            posi = true;
        }
        else {
            if(text.substring(0, 1) == "-") posi = false;
            num = Integer.parseInt(text.substring(1, 2));
            ri = text.substring(2, 4);
        }

        bg = new Texture("OrbackgroundE5.png");
        mb1 = new Buildings(bg.getWidth() + 1200, 328, "tower.png", true);
        mb2 = new Buildings(bg.getWidth() / 2, 330, "redthing.png", true);
        mb3 = new Buildings(bg.getWidth() + 200, 330, "alamo.png", true);
        tr = new Buildings(bg.getWidth() / 2 - 299, 329, "jTree.png", true);
        trd = new Buildings(bg.getWidth() / 2 - 299, 329, "jTreeD.png", true);
        gr = new Buildings(0, 330, "grass.png", false);
        grd = new Buildings(0, 330, "grassD.png", false);
        sb1 = new Buildings(bg.getWidth() + 660, 329, "hotelbackbuilding.png", false);
        sb2 = new Buildings(bg.getWidth() / 2 - 150, 329, "twobackbuildings.png", false);

        bb = new Buildings(-790, 333, "blueb.png", false);
        bbe = new Texture("bluebe.png");
        bcl = new Buildings(50, 950, "bc.png", false);
        lcl = new Buildings(250, 696, "llc.png", false);
        scl = new Buildings(850, 811, "sc.png", false);
        slcl = new Buildings(425, 743, "slc.png", false);
        tcl = new Buildings(725, 555, "threelc.png", false);
        bird = new Bird(0, 324);
        //cam.setToOrtho(false, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        //zooms in to the bird
        //cam.setToOrtho(false, MyGdxGame.WIDTH / 2, MyGdxGame.HEIGHT / 2);
        //Orbackground
        //tworiders

        batch = new SpriteBatch();
        //for small LG
        font = new BitmapFont(Gdx.files.internal("smallfont.fnt"));
        bfont = new BitmapFont(Gdx.files.internal("smallboldfont.fnt"));
        //for med size lg
//        font = new BitmapFont(Gdx.files.internal("myfont.fnt"));
//        bfont = new BitmapFont(Gdx.files.internal("myBlodfont.fnt"));
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
        bcl.update(dt);
        lcl.update(dt);
        scl.update(dt);
        slcl.update(dt);
        tcl.update(dt);
        bird.update(dt);




//        if(cam.position.x - (cam.viewportWidth / 2) < bird.getPosition().x + bird.getTexture().getWidth()){
//            bird.reposition(-450, bird.getPosition().y);
//        }

        if(cam.position.x - (cam.viewportWidth / 2) > mb1.getPosition().x + mb1.getTexture().getWidth()){
            mb1.reposition(mb3.getPosition().x + 625, mb1.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > mb2.getPosition().x + mb2.getTexture().getWidth()){
            mb2.reposition(mb1.getPosition().x + 625, mb2.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > mb3.getPosition().x + mb3.getTexture().getWidth()){
            mb3.reposition(mb2.getPosition().x + 625, mb3.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > tr.getPosition().x + tr.getTexture().getWidth()){
            tr.reposition(mb2.getPosition().x  - 250, tr.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > trd.getPosition().x + trd.getTexture().getWidth()){
            trd.reposition(mb2.getPosition().x  - 250, trd.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > sb1.getPosition().x + sb1.getTexture().getWidth()){
            sb1.reposition(mb1.getPosition().x - 420, sb1.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > sb2.getPosition().x + sb2.getTexture().getWidth()){
            sb2.reposition(mb2.getPosition().x - 200, sb2.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2)>= bb.getPosition().x + bb.getTexture().getWidth()){
            bb.reposition(bb.getPosition().x + 2000, bb.getPosition().y);
        }

        //bcl, lcl, scl, slcl,tcl
        if(cam.position.x - (cam.viewportWidth / 2) > bcl.getPosition().x + bcl.getTexture().getWidth()){
            bcl.reposition(bcl.getPosition().x + 1500, bcl.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > lcl.getPosition().x + lcl.getTexture().getWidth()){
            lcl.reposition(lcl.getPosition().x + 1500, lcl.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > scl.getPosition().x + scl.getTexture().getWidth()){
            scl.reposition(scl.getPosition().x + 1500, scl.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > slcl.getPosition().x + slcl.getTexture().getWidth()){
            slcl.reposition(slcl.getPosition().x + 1500, slcl.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > tcl.getPosition().x + tcl.getTexture().getWidth()){
            tcl.reposition(tcl.getPosition().x + 1500, tcl.getPosition().y);
        }


        cam.update();


    }




    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(cam.combined);
        sb.begin();

        //bcl, lcl, scl, slcl,tcl
        sb.draw(bcl.getTexture(), bcl.getPosition().x, bcl.getPosition().y);
        sb.draw(lcl.getTexture(), lcl.getPosition().x, lcl.getPosition().y);
        sb.draw(scl.getTexture(), scl.getPosition().x, scl.getPosition().y);
        sb.draw(slcl.getTexture(), slcl.getPosition().x, slcl.getPosition().y);
        sb.draw(tcl.getTexture(), tcl.getPosition().x, tcl.getPosition().y);
        sb.draw(bbe, 0, 333);
        sb.draw(bb.getTexture(), bb.getPosition().x, bb.getPosition().y);
        sb.draw(sb1.getTexture(), sb1.getPosition().x, sb1.getPosition().y);
        sb.draw(sb2.getTexture(), sb2.getPosition().x, sb2.getPosition().y);
        sb.draw(mb1.getTexture(), mb1.getPosition().x, mb1.getPosition().y);
        sb.draw(mb2.getTexture(), mb2.getPosition().x, mb2.getPosition().y);
        sb.draw(mb3.getTexture(), mb3.getPosition().x, mb3.getPosition().y);
        if(bgc == false){
            sb.draw(trd.getTexture(), trd.getPosition().x, trd.getPosition().y);
            sb.draw(grd.getTexture(), grd.getPosition().x, grd.getPosition().y);
        }
        if(bgc == true){
            sb.draw(tr.getTexture(), tr.getPosition().x, tr.getPosition().y);
            sb.draw(gr.getTexture(), gr.getPosition().x, gr.getPosition().y);
        }

        sb.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);

        sb.draw(bg, 0,0);
        sb.end();
        batch.begin();
        //desktop
//        font.draw(batch, va, 100, 700);
//        font.draw(batch, ti, 100, 670);
        //phone small LG
        font.draw(batch, va, 150, 700);
        bfont.draw(batch, ti, 32, 670);
        //the ri code x = 393 ,x = 385
        if(posi) bfont.draw(batch, ri, 392, 162);
        if(!posi) bfont.draw(batch, ri, 392-num, 162);
        //phone alex SAM
//        font.draw(batch, va, 235, 1145);
//        bfont.draw(batch, ti, 85, 1100);

        //phone with two riders
//        font.draw(batch, va, 235, 1058);
//        bfont.draw(batch, ti, 85, 1018);
        batch.end();
    }

    @Override
    public void dispose() {
        //bcl, lcl, scl, slcl,tcl
        bg.dispose();
        mb1.dispose();
        mb2.dispose();
        mb3.dispose();
        gr.dispose();
        grd.dispose();
        tr.dispose();
        trd.dispose();
        sb1.dispose();
        sb2.dispose();
        bb.dispose();
        bbe.dispose();
        bcl.dispose();
        lcl.dispose();
        scl.dispose();
        slcl.dispose();
        tcl.dispose();


    }
}
