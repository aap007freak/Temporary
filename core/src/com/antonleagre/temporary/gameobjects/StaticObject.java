package com.antonleagre.temporary.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;


public class StaticObject extends GameObject {


    public StaticObject(World world, TextureRegion region, float x, float y, BodyDef.BodyType bodyType) {
        super(world, region, x, y, bodyType);
    }

    @Override
    public void update(float dt) {
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.draw(tex, x ,y);
    }

    @Override
    public void dispose() {
    }
}
