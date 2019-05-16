package com.mygdx.game.States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.sprites.Bird;

public class PlayState extends State  {
    private Bird bird;
    protected PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50,300);
        cam.setToOrtho(false, MyGdxGame.WIDTH/2,MyGdxGame.HEIGHT/2);
    }

    @java.lang.Override
    protected void handleInput() {

    }

    @java.lang.Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);

    }

    @java.lang.Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bird.getTexture(),bird.getPosition().x,bird.getPosition().y);
        sb.end();

    }

    @java.lang.Override
    public void dispose() {

    }
}
