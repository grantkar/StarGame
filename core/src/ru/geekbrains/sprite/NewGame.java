package ru.geekbrains.sprite;



import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.BaseButton;
import ru.geekbrains.math.Rect;


public class NewGame extends BaseButton {


    private static final float HEIGHT = 0.08f;
    private static final float PADDING = 0.2f;



   // private MainShip mainShip;
   // GameScreen gameScreen;


    public NewGame(TextureAtlas atlas) {
        super(atlas.findRegion("button_new_game"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
        setBottom(worldBounds.getBottom() + PADDING);
    }

    @Override
    public void action() {
        System.out.println("Тут должна начаться новая игра");
       //  gameScreen.newInitMyShip(flag);
    }

}
