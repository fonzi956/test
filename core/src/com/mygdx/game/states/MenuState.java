package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MyGdxGame;

public class MenuState extends State implements Input.TextInputListener {
    private Texture background;
    private Texture playBtn, bcode;
    public String text;
    public Boolean bccode = true;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        //MyTextInputListener listener = new MyTextInputListener();
        Gdx.input.getTextInput(this, "Title", "", "");
        //cam.setToOrtho(false, MyGdxGame.WIDTH / 2, MyGdxGame.HEIGHT / 2);
        background = new Texture("menu.png");
        cam.setToOrtho(false, background.getWidth(), background.getHeight());
        //bcode = new Texture("bus.png");
        playBtn = new Texture("code.png");
        bcode = new Texture("barcode.png");
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
        //This workd but it when touch or click it detects it 4 times
//        if(Gdx.input.justTouched())
//        {
//            Vector3 tmp=new Vector3(Gdx.input.getX(),Gdx.input.getY(), 0);
//            Vector3 tmp2=new Vector3(Gdx.input.getX(),Gdx.input.getY(), 0);
//            cam.unproject(tmp);
//            cam.unproject(tmp2);
//            Rectangle textureBounds = new Rectangle(cam.position.x - playBtn.getWidth() / 2, cam.position.y, playBtn.getWidth(), playBtn.getHeight());
//            //Rectangle textureBounds2 = new Rectangle(cam.position.x - bcode.getWidth() / 2, cam.position.y, bcode.getWidth(), bcode.getHeight());
//            //small bcode
//            Rectangle textureBounds2 = new Rectangle(350, 360, 75, 75);
//            //big bcode
//            Rectangle textureBounds3 = new Rectangle(88, 744-507, 392-88, 507-203);
//
//
//            //top
//            Rectangle textureBoundstop = new Rectangle(0, 644, background.getWidth(), 110);
//            Rectangle textureBoundsleft = new Rectangle(0, 744-470, 23, 470-105);
//            Rectangle textureBoundsright = new Rectangle(457, 744-470, 23, 470-105);
//            Rectangle textureBoundsbottom = new Rectangle(0, 0, background.getWidth(), 744-470);
//            // texture x is the x position of the texture
//            // texture y is the y position of the texture
//            // texturewidth is the width of the texture (you can get it with texture.getWidth() or textureRegion.getRegionWidth() if you have a texture region
//            // textureheight is the height of the texture (you can get it with texture.getHeight() or textureRegion.getRegionhHeight() if you have a texture region
//
////            if (textureBoundsbottom.contains(tmp2.x, tmp2.y))
////                System.out.println("It;s top");
////            else System.out.println("It;s not");
//
//            if(textureBounds2.contains(tmp2.x,tmp2.y) & bccode)
//            {
//                //System.out.println("It;s barcode");
//                bccode = false;
//                //background.dispose();
//            }
//            else if (textureBounds3.contains(tmp2.x,tmp2.y) & !bccode)
//            {
//                //System.out.println("It;s touch");
//                bccode = true;
//            }
//
//        }
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
//        if (bccode == true)
//            sb.draw(playBtn, 0, 0);
//        else
//            sb.draw(bcode, 0, 0);
        sb.end();
    }

    @Override
    public void dispose(){
        background.dispose();
        playBtn.dispose();
        bcode.dispose();
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
