package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;
import ru.geekbrains.sprite.Star;

public class GameScreen extends BaseScreen {

    private static final int STAR_COUNT = 64;

    private Texture bg;
    private TextureAtlas atlas;

    private Background background;
    private Star [] stars;

    @Override
    public void show() {
        super.show();
        bg = new Texture("texture/bg.png");
        atlas = new TextureAtlas(Gdx.files.internal("texture/mainAtlas.tpack"));
        background = new Background(bg);

        stars = new Star[STAR_COUNT];
        for (int i = 0; i < STAR_COUNT; i++) {
            stars[i] = new Star(atlas);
        }
    }

    @Override
    public void render(float delta) {
        update(delta);
        drow();
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);

        for (Star star: stars) {
            star.resize(worldBounds);
        }
    }

    @Override
    public void dispose() {
        bg.dispose();
        atlas.dispose();
        super.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        return false;
    }

    private void update(float delta){

        for (Star star: stars) {
            star.update(delta);
        }

    }

    private void drow(){
        Gdx.gl.glClearColor(0.3f,0.6f,0.4f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);

        for (Star star:stars) {
            star.draw(batch);
        }
        batch.end();


    }
}
