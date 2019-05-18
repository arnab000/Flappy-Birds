package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.sprites.Bird;
import com.mygdx.game.sprites.Tube;


import java.util.*;

public class PlayState extends State  {
    private static final int  Tube_Spacing =125;
    private static final int Tube_count =4;
    private Bird bird;
    private Texture bg;
    private Tube tube1,tube2,tube3,tube4;



   /* private Tube[] tubes;*/

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50,300);
        cam.setToOrtho(false, MyGdxGame.WIDTH/2,MyGdxGame.HEIGHT/2);
        bg =new Texture("background(day).png");
        tube1=new Tube(1*(Tube_Spacing+Tube.Tube_Width));
        tube2 = new Tube(2*(Tube_Spacing+Tube.Tube_Width));
        tube3 = new Tube(3*(Tube_Spacing+Tube.Tube_Width));
        tube4 = new Tube(4*(Tube_Spacing+Tube.Tube_Width));



      /*  tubes =new Tube[Tube_count];
        for(int i=1;i<Tube_count;i++)
        {
            tubes[i]=new Tube(i*(Tube_Spacing+Tube.Tube_Width));
        }
*/

    }

    @java.lang.Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            bird.jump();
        }

    }

    @java.lang.Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
        cam.position.x= bird.getPosition().x+80;

        if (cam.position.x - cam.viewportWidth / 2 > tube1.getPosTopTube().x + tube1.getTopTube().getWidth())
            tube1.reposition(tube1.getPosTopTube().x + ((Tube.Tube_Width + Tube_Spacing) * Tube_count));
        if (cam.position.x - cam.viewportWidth / 2 > tube2.getPosTopTube().x + tube2.getTopTube().getWidth())
            tube2.reposition(tube2.getPosTopTube().x + ((Tube.Tube_Width + Tube_Spacing) * Tube_count));
        if (cam.position.x - cam.viewportWidth / 2 > tube3.getPosTopTube().x + tube3.getTopTube().getWidth())
            tube3.reposition(tube3.getPosTopTube().x + ((Tube.Tube_Width + Tube_Spacing) * Tube_count));
        if (cam.position.x - cam.viewportWidth / 2 > tube4.getPosTopTube().x + tube4.getTopTube().getWidth())
            tube4.reposition(tube4.getPosTopTube().x + ((Tube.Tube_Width + Tube_Spacing) * Tube_count));
        if(tube1.collides(bird.getBounds())|| tube2.collides(bird.getBounds())|| tube3.collides(bird.getBounds()) || tube4.collides(bird.getBounds())){
          gsm.set(new PlayState(gsm));
        }
      cam.update();

    }

    @java.lang.Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg,cam.position.x-(cam.viewportWidth/2),0);
        sb.draw(bird.getTexture(),bird.getPosition().x,bird.getPosition().y);
        sb.draw(tube1.getTopTube(), tube1.getPosTopTube().x, tube1.getPosTopTube().y);sb.draw(tube1.getBottomTube(), tube1.getPosBotTube().x, tube1.getPosBotTube().y);
        sb.draw(tube2.getTopTube(), tube2.getPosTopTube().x, tube2.getPosTopTube().y);
        sb.draw(tube2.getBottomTube(), tube2.getPosBotTube().x, tube2.getPosBotTube().y);
        sb.draw(tube3.getTopTube(), tube3.getPosTopTube().x, tube3.getPosTopTube().y);
        sb.draw(tube3.getBottomTube(), tube3.getPosBotTube().x, tube3.getPosBotTube().y);
        sb.draw(tube4.getTopTube(), tube4.getPosTopTube().x, tube4.getPosTopTube().y);
        sb.draw(tube4.getBottomTube(), tube4.getPosBotTube().x, tube4.getPosBotTube().y);
        sb.end();

    }

    @java.lang.Override
    public void dispose() {

    }
}
