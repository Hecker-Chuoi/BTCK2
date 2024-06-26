package com.mygdx.game.view.screens.mainstory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.SpaceGame;
import com.mygdx.game.view.screens.Impression;
import com.mygdx.game.view.screens.maingame.MainGameScreen;
import com.mygdx.game.view.screens.maingame.multiplayer.MultiPlayer;
import com.mygdx.game.view.screens.maingame.singleplayer.SinglePlayer;
import com.mygdx.game.view.screens.mainmenu.MainMenuScreen;

public class MainStory implements Screen {
    private final SpaceGame game;
    private final SpriteBatch batch;
    Impression impression;
    private float stateTime = 0;
    Message message;

    MainGameScreen mainGameScreen;

    MainMenuScreen mainMenuScreen;

    SinglePlayer singlePlayer;

    MultiPlayer multiPlayer;

    public MainStory(SpaceGame game, MainMenuScreen mainMenuScreen, SinglePlayer singlePlayer,
                     MultiPlayer multiPlayer) {
        this.mainMenuScreen = mainMenuScreen;
        this.game = game;
        batch = game.getBatch();
        this.singlePlayer = singlePlayer;
        this.multiPlayer = multiPlayer;
        mainGameScreen = new MainGameScreen(game, mainMenuScreen, 180);
        impression = new Impression("story/impression1.png");
    }
    @Override
    public void show() {
        message = new Message("story/press.png", singlePlayer, multiPlayer);
        stateTime = 0;
//        impression.setCountImpress(0);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.113f, 0.102f, 0.16f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stateTime += Gdx.graphics.getDeltaTime();
        message.update(stateTime);
        impression.drawStory(batch, stateTime);
        message.draw(delta, game, batch, stateTime);
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
