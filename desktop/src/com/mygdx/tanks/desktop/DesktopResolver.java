package com.mygdx.tanks.desktop;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.tanks.PlatformInput;
import com.mygdx.tanks.PlatformRender;
import com.mygdx.tanks.PlatformResolver;

/**
 * Created by colin on 15-May-17.
 */
public class DesktopResolver implements PlatformResolver {
    PlatformInput desktopInput;
    PlatformRender desktopRenderer;

    public DesktopResolver(){
        desktopInput = new DesktopInput();
        desktopRenderer = new DesktopRender();
    }

    @Override
    public PlatformInput getPlatformInput() {
        return desktopInput;
    }

    @Override
    public PlatformRender getPlatformRenderer() {
        return desktopRenderer;
    }
}
