package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MyGdxGame;

public class Bird {
    private static final int RIGHT = 1;
    private static final int SPEED = 3;
    private static final int MOVEMENT = 100;
    private static final int GRAVITY = -15;
    private Vector3 position;
    private Vector3 velocity;

    private Texture bird;

    public Bird(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        bird = new Texture("bus.png");
    }

    public void update(float dt){

        //going right
        velocity.add(RIGHT, 0, 0);
        //if the bus goes pass the screen
        if (position.x - bird.getWidth() > MyGdxGame.WIDTH)
            position.x = -425;
        velocity.scl(dt);
        position.add(SPEED, 0, 0);


//        if (position.y > 0)
//            velocity.add(0, GRAVITY, 0);
//        velocity.scl(dt);
//        position.add(MOVEMENT * dt, velocity.y, 0);
//        if(position.y < 0)
//            position.y = 0;

        velocity.scl(1/dt);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return bird;
    }


    public void dispose(){ bird.dispose(); }

}
