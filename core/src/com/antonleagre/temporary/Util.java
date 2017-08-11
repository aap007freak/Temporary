package com.antonleagre.temporary;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import static com.antonleagre.temporary.Main.PPM;

public class Util {

    //camera utils
    /**
     * Method to be called in update loop to center camera round a target position
     * @param camera  camera to be manipulated
     * @param target target to center around (so give the middle of the desired object if the target is an object)
     */
    public static void camLockTarget(Camera camera, Vector2 target){
        Vector3 position = camera.position;
        position. x = target.x;
        position.y = target.y;
        camera.position.set(position);
    }

    /**
     * Method to be called in update loop to center camera round a target position
     * @param camera camera to be manipulated
     * @param x x position that the camera will be centered at (middle of screen)
     * @param y y position that the camera will be centered at (middle of screen)
     */
    public static void camLockTarget(Camera camera, float x, float y){
        Vector3 position = camera.position;
        position. x = x;
        position.y = y;
        camera.position.set(position);
    }
    //box2d utils

    /**
     * Create a box2d body based on params
     * @param world world the body needs to be created in
     * @param x pos x in pixel coordinates
     * @param y pos y in pixel coordinates
     * @param height height in pixel coordinates
     * @param width width in pixel coordinates
     * @param type bodytype
     * @return
     */
    public static Body B2DcreateBox(World world, float x, float y, float height, float width, BodyDef.BodyType type){
        BodyDef bidoof = new BodyDef();
        bidoof.position.x = (x + width / 2) / PPM;
        bidoof.position.y = (y + height / 2) / PPM;
        bidoof.type = type;

        PolygonShape boxShape = new PolygonShape();
        boxShape.setAsBox((width /2) / PPM, (height /2) / PPM);
        Body box = world.createBody(bidoof);
        box.createFixture(boxShape, 1.0f);
        boxShape.dispose();
        return box;

    }

}
