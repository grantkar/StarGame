package ru.geekbrains.screen;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

import ru.geekbrains.base.BaseScreen;

public class MenuScreen extends BaseScreen {
   private Texture img;
   private Vector2 touch;
   private Vector2 v;
   private Vector2 pos;
   private Vector2 buff;



    @Override
    public void show() {
        super.show();
        img = new Texture("SuperCat.jpg");
        touch = new Vector2();
        v = new Vector2(1,1);
        pos = new Vector2(0,0);
        buff = new Vector2();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.7f, 0.1f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, pos.x , pos.y);
        batch.end();

        buff = touch.sub(pos); // высчитываем вектор направление до точки нажатия мыши и сохраняем в буферный вектор
        if (pos.x!=buff.x){   // теперь картинка двигается только после нашего нажатия
            pos.add(v);
        }


    }

    @Override
    public void dispose() {
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX,Gdx.graphics.getHeight() - screenY);
        pos.x = touch.x;
        pos.y = touch.y;
        return super.touchDown(screenX, screenY, pointer, button);

    }

}
