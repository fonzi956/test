package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class BuildingsTwo {

    private static final int RIGHT = 1;
    private static final int SPEED = -2;
    private static final int left = -1;
    //private static final int SPEED = -2;
    private static final int MOVEMENT = 100;
    private static final int GRAVITY = -15;
    private Vector2 position;
    private Vector2 velocity;

    private Texture buildingtwo;

    public BuildingsTwo(float x, float y){
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        buildingtwo = new Texture("sbg.png");
    }

    public void update(float dt){

        //going right

//        velocity.add(RIGHT, 0, 0);
//        if (position.x > MyGdxGame.WIDTH)
//            position.x = -25;
//        velocity.scl(dt);
//        position.add(SPEED, 0, 0);

        velocity.add(left, 0);
        //here is when the building cross the x 0
//        if (position.x == 0)
//
//            position.x = MyGdxGame.WIDTH;
        velocity.scl(dt);
        position.add(SPEED, 0);


//        if (position.y > 0)
//            velocity.add(0, GRAVITY, 0);
//        velocity.scl(dt);
//        position.add(MOVEMENT * dt, velocity.y, 0);
//        if(position.y < 0)
//            position.y = 0;

        velocity.scl(1/dt);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return buildingtwo;
    }

    public void reposition(float x, float y){
        position.set(x, y);
    }

}
