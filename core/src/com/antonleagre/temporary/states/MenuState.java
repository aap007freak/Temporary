package com.antonleagre.temporary.states;

import com.antonleagre.temporary.Main;
import com.antonleagre.temporary.Util;
import com.antonleagre.temporary.gameobjects.StaticObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import static com.antonleagre.temporary.Main.DEBUG;
import static com.antonleagre.temporary.Main.FPS;
import static com.antonleagre.temporary.Main.PPM;

public class MenuState extends State{
    //temp
    private Texture img;
    private float x = 20f;
    private float y = 20f;

    //box2d
    private World world;
    private Box2DDebugRenderer b2dr;
    private StaticObject badlogic;


    public MenuState(GSM gsm, AssetManager asm) {
        super(gsm, asm);
        img = asm.get("badlogic.jpg");
        b2dr = new Box2DDebugRenderer();
        world = new World(new Vector2(0f, 0f), true);
        badlogic = new StaticObject(world, TextureRegion.split(img, img.getWidth(), img.getHeight())[0][0], x, y, BodyDef.BodyType.StaticBody);

    }

    public void handleInput() {
        /*
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            x += 2;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            x -= 2;
        }
         */

    }

    @Override
    public void update(float dt) {
        handleInput();
        world.step(FPS, 6, 2);
       // Util.camLockTarget(cam, x + img.getWidth() / 2 , y + img.getHeight() / 2);
        cam.update();
        badlogic.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {

            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            sb.setProjectionMatrix(cam.combined);
            sb.begin();
            badlogic.render(sb);
            sb.end();


            cam.update();

            if(DEBUG == true){
                b2dr.render(world, cam.combined.scl(PPM));
            }

    }

    @Override
    public void dispose() {
            badlogic.dispose();
            img.dispose();
    }
}
