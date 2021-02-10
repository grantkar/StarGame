package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class Logo extends Sprite {
    private Vector2 touch = new Vector2();




    public Logo(Texture texture) {
        super(new TextureRegion(texture));
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }



    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.2f);

    }


    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
        return false;
    }

}
