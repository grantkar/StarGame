package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class MenuMainShip extends Sprite {

    private static final float HEIGHT = 0.3f;
    private static final float PADDING = -0.02f;


    public MenuMainShip(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship"), 1,2,2);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
        setBottom(PADDING);

    }
}
