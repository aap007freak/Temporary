package com.antonleagre.temporary.states;

import com.antonleagre.temporary.Main;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import static com.antonleagre.temporary.Main.V_HEIGHT;
import static com.antonleagre.temporary.Main.V_WIDTH;

public abstract class State {

    protected GSM gsm;
    protected Main game;
    protected OrthographicCamera cam;
    protected AssetManager asm;

    protected State(GSM gsm, AssetManager asm){
        this.gsm = gsm;
        this.game = gsm.getGame();
        this.asm = asm;
        cam = new OrthographicCamera();
        cam.setToOrtho(false, V_WIDTH, V_HEIGHT);
        cam.update();

    }


    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();


}
