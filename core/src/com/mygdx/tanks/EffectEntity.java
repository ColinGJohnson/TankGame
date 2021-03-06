package com.mygdx.tanks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by colin on 11-Jun-17.
 */

public class EffectEntity extends Entity{
    private long timeCreated;
    private int duration;
    private boolean used = false;
    EffectType effectType;

    enum EffectType {
        smoke,
        treadMark
    }

    public EffectEntity(float x, float y, float rotation, GameMap gameMap, EffectType effectType, int duration) {

        // call Entity constructor
        super(x, y, 0, gameMap);

        // init instance variables
        this.duration = duration;
        this.effectType = effectType;

        // record time created
        timeCreated = System.currentTimeMillis();

        // select correct sprite
        switch (effectType) {
            case smoke:
                setSprite(new Sprite(new Texture("smokeGrey0.png")));

                // set sprite position
                getSprite().setPosition(getX(), getY());
                break;
            case treadMark:
                setSprite(new Sprite(new Texture("tracksSmallSingle.png")));

                // set rotation origin to the center of the sprite image
                getSprite().setOriginCenter();

                // set sprite position (tank tread sprite is shorter than tank sprite so Y is increased)
                getSprite().setPosition(getX(), getY() + 30);
                break;
        }

        // apply source rotation
        setRotation(rotation);
    } // EffectEntity constructor

    public void update (){

        // mark used if effect has lived for its entire duration
        if (timeCreated + duration < System.currentTimeMillis()){
            used = true;
            getSprite().getTexture().dispose();

        // otherwise lower opacity as effect ages
        } else {
            float age = System.currentTimeMillis() - timeCreated;
            getSprite().setAlpha(1 - age / duration);
        }
    }

    @Override
    public void defineBody() {
        /* NO PHYSICS NEEDED */
    }

    public EffectType getEffectType() {
        return effectType;
    }

    public void setEffectType(EffectType effectType) {
        this.effectType = effectType;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
} // EffectEntity
