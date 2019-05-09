package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
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

    private Bird bird, bird2;
    private Buildings ufo;
    private Buildings red;
    private Buildings ala;
    private Buildings wideB;
    private Buildings twoB;
    private Buildings bb;
    private Buildings bnb;
    private Buildings cl;
    //private Buildings gr;
    //private Buildings grd;
    private Buildings tr;
    //private Buildings trd;
    private Texture bg;
    //private Texture bbe;
    private String va;
    private String mn;
    private String ti;
    private String ri;
    int num = 0;
    int soa;
    private boolean bgc = true;
    private  boolean posi;
    private Texture playBtn, bcode;
    //private Buildings bcl, lcl,scl, slcl, tcl;
    public int ybcoce;

    SpriteBatch batch;
    BitmapFont font;
    BitmapFont bfont;

    public Boolean bccode = true;
    public PlayState(GameStateManager gsm, String text) {
        super(gsm);

        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 1);
        ti = new SimpleDateFormat("MM/dd/yy").format(c.getTime());
        va = "2:59:00 AM";
        //va = "VALID UNTIL";
        //ti = mn + " 2:59 AM";
        if(text.length() == 2){
            ri = text;
            posi = true;
            num = 0;
        }
        else {
            soa = Integer.parseInt(text.substring(0, 1));
            num = Integer.parseInt(text.substring(1, 2));
            ri = text.substring(2, 4);
            if(soa == 0){
                num = num - 10;
                posi = false;
            }
            else if (soa == 1){
                num = num + 10;
                posi = true;
            }
//            if(text.substring(0, 1) == "s") {
//                posi = false;
//                num = Integer.parseInt(text.substring(1, 2));
//                ri = text.substring(2, 4);
//            }
//            else if (text.substring(0, 1) == "a") {
//                posi = true;
//                num = Integer.parseInt(text.substring(1, 2));
//                ri = text.substring(2, 4);
//            }

        }

        bg = new Texture("ground.png");
        ufo = new Buildings(950, 0, "ufobuilding.png", -2);
        red = new Buildings(465, 0, "redthing.png", -2);
        ala = new Buildings(-15, 0, "alamo.png", -2);
        tr = new Buildings(430, 0, "trees.png", -3);
        //trd = new Buildings(bg.getWidth() / 2 - 299, 329, "jTreeD.png", true);
        //gr = new Buildings(0, 330, "grass.png", false);
        //grd = new Buildings(0, 330, "grassD.png", false);
        wideB = new Buildings(320, 0, "widebuilding.png", -2);
        twoB = new Buildings(705, 0, "twobuildings.png", -2);
        cl = new Buildings(0, 20, "clouds.png", -1);
        bb = new Buildings(-25, 0, "secondarybuildings.png", -1);
        bnb = new Buildings(1140, 0, "bluebuilding.png", -2);
        //bbe = new Texture("bluebe.png");
//        bcl = new Buildings(50, 950, "bc.png", false);
//        lcl = new Buildings(250, 696, "llc.png", false);
//        scl = new Buildings(850, 811, "sc.png", false);
//        slcl = new Buildings(425, 743, "slc.png", false);
//        tcl = new Buildings(725, 555, "threelc.png", false);
        bird = new Bird(-650, 8, 4);
        bird2 = new Bird(-210, -42, 5);
        playBtn = new Texture("code.png");
        bcode = new Texture("barcode.png");
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
        font.setColor(Color.BLACK);
        //font.getData().setScale(1.2f);

        //zoom in to background
        cam.setToOrtho(false, bg.getWidth(), bg.getHeight());
        //cam.setToOrtho(false, bg.getWidth() / 2, bg.getHeight() / 2);

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
        //handleInput();
        if(Gdx.input.justTouched())
        {
            Vector3 tmp=new Vector3(Gdx.input.getX(),Gdx.input.getY(), 0);
            Vector3 tmp2=new Vector3(Gdx.input.getX(),Gdx.input.getY(), 0);
            cam.unproject(tmp);
            cam.unproject(tmp2);
            Rectangle textureBounds = new Rectangle(cam.position.x - playBtn.getWidth() / 2, cam.position.y, playBtn.getWidth(), playBtn.getHeight());
            //Rectangle textureBounds2 = new Rectangle(cam.position.x - bcode.getWidth() / 2, cam.position.y, bcode.getWidth(), bcode.getHeight());
            //small bcode
            Rectangle textureBounds2 = new Rectangle(350, 360, 75, 75);
            //big bcode
            Rectangle textureBounds3 = new Rectangle(88, 744-507, 392-88, 507-203);


            //top
            Rectangle textureBoundstop = new Rectangle(0, 644, bg.getWidth(), 110);
            Rectangle textureBoundsleft = new Rectangle(0, 744-470, 23, 470-105);
            Rectangle textureBoundsright = new Rectangle(457, 744-470, 23, 470-105);
            Rectangle textureBoundsbottom = new Rectangle(0, 0, bg.getWidth(), 744-470);
            // texture x is the x position of the texture
            // texture y is the y position of the texture
            // texturewidth is the width of the texture (you can get it with texture.getWidth() or textureRegion.getRegionWidth() if you have a texture region
            // textureheight is the height of the texture (you can get it with texture.getHeight() or textureRegion.getRegionhHeight() if you have a texture region

            if ((textureBoundsbottom.contains(tmp2.x, tmp2.y) || textureBoundstop.contains(tmp2.x, tmp2.y) || textureBoundsleft.contains(tmp2.x, tmp2.y) || textureBoundsright.contains(tmp2.x, tmp2.y) )&& bgc == false){
                Gdx.gl.glClearColor(173/255f, 231/255f, 255/255f, 1);
                bgc = true;
            }

            else {
                Gdx.gl.glClearColor(33/255f, 61/255f, 90/255f, 1);
                bgc = false;
            }

            if(textureBounds2.contains(tmp2.x,tmp2.y) & bccode)
            {
                //System.out.println("It;s barcode");
                bccode = false;
                //background.dispose();
            }
            else if (textureBounds3.contains(tmp2.x,tmp2.y) & !bccode)
            {
                //System.out.println("It;s touch");
                bccode = true;
            }

        }
        ufo.update(dt);
        red.update(dt);
        ala.update(dt);
        tr.update(dt);
        //trd.update(dt);
        wideB.update(dt);
        twoB.update(dt);
        bb.update(dt);
        bnb.update(dt);
        cl.update(dt);
//        bcl.update(dt);
//        lcl.update(dt);
//        scl.update(dt);
//        slcl.update(dt);
//        tcl.update(dt);
        bird.update(dt);
        bird2.update(dt);




//        if(cam.position.x - (cam.viewportWidth / 2) < bird.getPosition().x + bird.getTexture().getWidth()){
//            bird.reposition(-450, bird.getPosition().y);
//        }
        if(cam.position.x - (cam.viewportWidth / 2) > bnb.getPosition().x + bnb.getTexture().getWidth()){
            bnb.reposition(ufo.getPosition().x + 170, 0);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > ufo.getPosition().x + ufo.getTexture().getWidth()){
            ufo.reposition(twoB.getPosition().x + 270, ufo.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > red.getPosition().x + red.getTexture().getWidth()){
            red.reposition(wideB.getPosition().x + 150, red.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > ala.getPosition().x + ala.getTexture().getWidth()){
            ala.reposition(bnb.getPosition().x + 250, ala.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > tr.getPosition().x + tr.getTexture().getWidth()){
            tr.reposition(1150, tr.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > cl.getPosition().x + cl.getTexture().getWidth()){
            cl.reposition(750, 0);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > wideB.getPosition().x + wideB.getTexture().getWidth()){
            wideB.reposition(ala.getPosition().x + 350, wideB.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2) > twoB.getPosition().x + twoB.getTexture().getWidth()){
            twoB.reposition(red.getPosition().x + 200, twoB.getPosition().y);
        }

        if(cam.position.x - (cam.viewportWidth / 2)>= bb.getPosition().x + bb.getTexture().getWidth()){
            bb.reposition(bb.getPosition().x + 2000, bb.getPosition().y);
        }

        //bcl, lcl, scl, slcl,tcl
//        if(cam.position.x - (cam.viewportWidth / 2) > bcl.getPosition().x + bcl.getTexture().getWidth()){
//            bcl.reposition(bcl.getPosition().x + 1500, bcl.getPosition().y);
//        }
//
//        if(cam.position.x - (cam.viewportWidth / 2) > lcl.getPosition().x + lcl.getTexture().getWidth()){
//            lcl.reposition(lcl.getPosition().x + 1500, lcl.getPosition().y);
//        }
//
//        if(cam.position.x - (cam.viewportWidth / 2) > scl.getPosition().x + scl.getTexture().getWidth()){
//            scl.reposition(scl.getPosition().x + 1500, scl.getPosition().y);
//        }
//
//        if(cam.position.x - (cam.viewportWidth / 2) > slcl.getPosition().x + slcl.getTexture().getWidth()){
//            slcl.reposition(slcl.getPosition().x + 1500, slcl.getPosition().y);
//        }
//
//        if(cam.position.x - (cam.viewportWidth / 2) > tcl.getPosition().x + tcl.getTexture().getWidth()){
//            tcl.reposition(tcl.getPosition().x + 1500, tcl.getPosition().y);
//        }


        cam.update();


    }




    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(cam.combined);
        sb.begin();

        //bcl, lcl, scl, slcl,tcl
//        sb.draw(bcl.getTexture(), bcl.getPosition().x, bcl.getPosition().y);
//        sb.draw(lcl.getTexture(), lcl.getPosition().x, lcl.getPosition().y);
//        sb.draw(scl.getTexture(), scl.getPosition().x, scl.getPosition().y);
//        sb.draw(slcl.getTexture(), slcl.getPosition().x, slcl.getPosition().y);
//        sb.draw(tcl.getTexture(), tcl.getPosition().x, tcl.getPosition().y);
        //sb.draw(bbe, 0, 333);
        sb.draw(bg, 0, 0);
        sb.draw(cl.getTexture(), cl.getPosition().x, cl.getPosition().y);
        sb.draw(bb.getTexture(), bb.getPosition().x, bb.getPosition().y);
        sb.draw(bnb.getTexture(), bnb.getPosition().x, bnb.getPosition().y);
        sb.draw(wideB.getTexture(), wideB.getPosition().x, wideB.getPosition().y);
        sb.draw(twoB.getTexture(), twoB.getPosition().x, twoB.getPosition().y);
        sb.draw(ufo.getTexture(), ufo.getPosition().x, ufo.getPosition().y);
        sb.draw(red.getTexture(), red.getPosition().x, red.getPosition().y);
        sb.draw(ala.getTexture(), ala.getPosition().x, ala.getPosition().y);
//        if(bgc == false){
//            sb.draw(trd.getTexture(), trd.getPosition().x, trd.getPosition().y);
//            sb.draw(grd.getTexture(), grd.getPosition().x, grd.getPosition().y);
//        }
//        if(bgc == true){
//            sb.draw(tr.getTexture(), tr.getPosition().x, tr.getPosition().y);
//            sb.draw(gr.getTexture(), gr.getPosition().x, gr.getPosition().y);
//        }

        sb.draw(tr.getTexture(), tr.getPosition().x, tr.getPosition().y);
        //sb.draw(gr.getTexture(), gr.getPosition().x, gr.getPosition().y);

        sb.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y -200);
        sb.draw(bird2.getTexture(), bird2.getPosition().x, bird2.getPosition().y -200);
        if (bccode == true){
            sb.draw(playBtn, 0, 0);
            ybcoce = 640;
        }

        else{
            ybcoce = 665;
            sb.draw(bcode, 0, 0);
        }

        //sb.draw(playBtn, cam.position.x - playBtn.getWidth() / 2, cam.position.y -200, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //sb.draw(playBtn, cam.position.x - playBtn.getWidth() / 2, cam.position.y -200, cam.viewportWidth / 2, cam.viewportHeight/ 2);


        //sb.draw(bg, 0,0);
        sb.end();
        batch.begin();
        //desktop
//        font.draw(batch, va, 100, 700);
//        font.draw(batch, ti, 100, 670);
        //phone small LG
        font.draw(batch, va, 50, ybcoce);
        font.draw(batch, ti, 310, ybcoce);
        //the ri code x = 393 ,x = 385
        //if(posi) bfont.draw(batch, "85", 362+num, 512);
        if(posi && bccode) bfont.draw(batch, ri, 362+num, 538);
        if(!posi && bccode) bfont.draw(batch, ri, 362-num, 538);
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
        ufo.dispose();
        red.dispose();
        ala.dispose();
        //gr.dispose();
        //grd.dispose();
        tr.dispose();
        //trd.dispose();
        wideB.dispose();
        twoB.dispose();
        bb.dispose();
        bnb.dispose();
        bird.dispose();
        bird2.dispose();
        cl.dispose();
        //bbe.dispose();
//        bcl.dispose();
//        lcl.dispose();
//        scl.dispose();
//        slcl.dispose();
//        tcl.dispose();
        playBtn.dispose();


    }
}
