package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;
import ru.geekbrains.sprite.Star;
import ru.geekbrains.sprite.StarShip;

public class GameScreen extends BaseScreen {

    private static final int STAR_COUNT = 64;

    private Texture bg;
    private TextureAtlas atlas;
    private Texture ship;


    private Background background;
    private Star [] stars;
    private StarShip starShip;




    @Override
    public void show() {
        super.show();
        bg = new Texture("texture/bg.png");
        ship = new Texture("ship.png");

        atlas = new TextureAtlas(Gdx.files.internal("texture/mainAtlas.tpack"));
        background = new Background(bg);
        starShip = new StarShip(ship, atlas);


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

        starShip.resize(worldBounds);
    }

    @Override
    public void dispose() {
        bg.dispose();
        atlas.dispose();
        super.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == 21){ // код стрелки "влево"
           starShip.pos.x -= 0.05f;
        }
        if (keycode == 22){    // код стрелки "вправо"
            starShip.pos.x += 0.05f;
        }
        if (keycode == 19){   //код стрелки "вверх"
            starShip.pos.y += 0.05f;
        }
        if (keycode == 20){  // код стрелки "вниз"
            starShip.pos.y -= 0.05f;
        }
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
        starShip.draw(batch);

        batch.end();
    }
}
