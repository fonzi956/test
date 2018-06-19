package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.sprites.Bird;
import com.mygdx.game.sprites.BuildingsOne;
import com.mygdx.game.sprites.Tube;

import static com.mygdx.game.sprites.Tube.TUBE_WIDTH;

public class PlayState extends State {
    private  static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;

    private Bird bird;
    private BuildingsOne mb1;
    private Texture bg;
    //private Tube tube;

    private Array<Tube> tubes;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        mb1 = new BuildingsOne(0, 0);
        bird = new Bird(0, 300);
        //zooms in to the bird
        cam.setToOrtho(false, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        //cam.setToOrtho(false, MyGdxGame.WIDTH / 2, MyGdxGame.HEIGHT / 2);
        bg = new Texture("bg.png");
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
            //bird.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        mb1.update(dt);
        bird.update(dt);
        //cam.position.x = bird.getPosition().x + 80;

//        for (Tube tube : tubes){
//            if(cam.position.x - (cam.viewportWidth / 2) > tube.getPosTopTube().x + tube.getTopTube().getWidth()){
//                tube.reposition(tube.getPosTopTube().x + ((Tube.TUBE_WIDTH + TUBE_SPACING * TUBE_COUNT)));
//            }
//        }

        cam.update();


    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
//        for (Tube tube : tubes) {
//            sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
//            sb.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
//        }
        sb.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        sb.draw(mb1.getTexture(), mb1.getPosition().x, mb1.getPosition().y);
        //sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
        //sb.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);

        sb.end();
    }

    @Override
    public void dispose() {

    }
}
