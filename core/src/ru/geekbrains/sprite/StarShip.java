package ru.geekbrains.sprite;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class StarShip extends Sprite {




    private static final float HEIGHT = 0.15f;

    TextureAtlas atlas;
    TextureRegion region;

    public StarShip(Texture region, TextureAtlas atlas) {
        super(new TextureRegion(atlas.findRegion("main_ship"), 0,0,region.getWidth()/2,region.getHeight()));
        this.atlas = atlas;

    }



    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
    }



}
