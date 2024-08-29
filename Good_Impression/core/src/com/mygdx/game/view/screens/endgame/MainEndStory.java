package com.mygdx.game.view.screens.endgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.SpaceGame;
import com.mygdx.game.common.constant.GameConstant;
import com.mygdx.game.model.item.DynamicItem;
import com.mygdx.game.model.item.StaticItem;
import com.mygdx.game.view.screens.maingame.MainGameScreen;
import com.mygdx.game.view.screens.mainmenu.Leaderboard;
import com.mygdx.game.view.screens.mainmenu.MainMenuScreen;
import com.mygdx.game.view.screens.mainstory.MainStory;

import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;

public class MainEndStory implements Screen {
    SpaceGame game;
    SpriteBatch batch;
    Knock knock;
    Texture texture;
    ArrayList<DynamicItem> dynamicItems;
    ArrayList<StaticItem> staticItems;
    MapEndGame mapEndGame;
    Leaderboard leaderboard;

    public MainEndStory(SpaceGame game, ArrayList<DynamicItem> dynamicItems,
                        ArrayList<StaticItem> staticItems, MainMenuScreen mainMenuScreen){
        this.game = game;
        batch = game.getBatch();
        this.dynamicItems = dynamicItems;
        texture = new Texture("otherImage/knock.png");
        knock = new Knock(texture);
        this.staticItems = staticItems;
        mapEndGame = new MapEndGame(game, dynamicItems, staticItems, this, mainMenuScreen);
        leaderboard = new Leaderboard();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.113f, 0.102f, 0.16f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        knock.draw(batch, delta);
        batch.end();
        if(knock.isNextMapEndGame){
            game.setScreen(mapEndGame);
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
