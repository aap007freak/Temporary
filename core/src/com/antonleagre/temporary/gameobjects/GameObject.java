package com.antonleagre.temporary.gameobjects;

import com.antonleagre.temporary.Util;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import javax.swing.plaf.TextUI;

public abstract class GameObject {

    protected TextureRegion tex;
    protected float x;
    protected float y;
    protected Body body;

    /**
     *
     * @param world
     * @param region
     * @param x bottom left most point x
     * @param y bottom left most point y
     * @param bodyType
     */
    public GameObject(World world, TextureRegion region, float x, float y, BodyDef.BodyType bodyType){
        this.x = x;
        this.y = y;
        this.tex = region;
        body = Util.B2DcreateBox(world, this.x, this.y, tex.getRegionWidth() , tex.getRegionHeight(), bodyType);
    }
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();



}
