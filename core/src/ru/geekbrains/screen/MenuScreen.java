package ru.geekbrains.screen;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;


import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;
import ru.geekbrains.sprite.Logo;

public class MenuScreen extends BaseScreen {
   private Texture bg;
   private Background background;
   private Texture superCat;
   private Logo logo;

    private Vector2 buff;
    private Vector2 v;
    private Vector2 touch;
    private final float V_LEN = 0.01f;







    @Override
    public void show() {
        super.show();
       bg = new Texture("texture/bg.png");
       background = new Background(bg);
       superCat = new Texture("SuperCat.jpg");
       logo = new Logo(superCat);
       buff = new Vector2();
       v = new Vector2();
       touch = new Vector2();


    }

    @Override
    public void render(float delta) {
        super.render(delta);

        batch.begin();
        background.draw(batch);
        logo.draw(batch);
        batch.end();
        //stopImg();
        logo.pos.add(v);


    }

    @Override
    public void dispose() {
        bg.dispose();
        superCat.dispose();
        super.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {

        background.resize(worldBounds);
        logo.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {

        v.set(touch.cpy().sub(logo.pos)).setLength(V_LEN);
        System.out.println(v.x + "  " + v.y);
        return false;
    }


    public void stopImg (){

          buff.set(touch);
          if (buff.sub(logo.pos).len() > v.len()) {
              logo.pos.add(v);
          } else {
              logo.pos.set(touch);
           }
    }

}
