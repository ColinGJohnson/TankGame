package com.mygdx.tanks;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;

public class TankGame extends Game {

    // cross-platform
    public static PlatformResolver platformResolver = null;

    // logic
    private ScreenManager screenManager;

    @Override
    public void create () {

        // create a new screenManager to handle menu/game transitions
        screenManager = new ScreenManager(this);

        // start on menu screen
        setScreen(screenManager.getScreens().get(ScreenManager.GameState.Menu));
    } // create

    /**
     * Update all game logic. Always called at the start of the render method.
     */
    public void update(float deltaT){

    } // update

    /**
     * Render loop called 60 times per second by LibGDX. Calls update() then
     * renders all game grapics.
     */
    @Override
    public void render () {

        // render all screens
        super.render();
    } // render

    @Override
    public void dispose () {

    } // dispose

    @Override
    public void resize(int width, int height){

    } // resize

    public static PlatformResolver getPlatformResolver() {
        return platformResolver;
    } // getPlatformResolver

    public ScreenManager getScreenManager() {
        return screenManager;
    }
} // TankGame