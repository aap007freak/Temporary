package com.antonleagre.temporary.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuState extends State{

    private Texture img;
    private float x = 0f;
    private float y = 0f;

    public MenuState(GSM gsm) {
        super(gsm);
        img = new Texture("badlogic.jpg");
    }

    public void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            x += 2;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            x -= 2;
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            sb.setProjectionMatrix(cam.combined);
            sb.begin();
            sb.draw(img, x, y);
            sb.end();
    }

    @Override
    public void dispose() {
            img.dispose();
    }
}
