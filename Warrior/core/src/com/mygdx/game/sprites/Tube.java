package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g3d.particles.influencers.ParticleControllerInfluencer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;

public class Tube {
    public static final int Tube_Width = 52;
    private static final int FLUCTUATION =130;
    private static final int Tube_Gap= 100;
    private static final int lowest_Opening = 120;
    private Texture topTube;
    private Texture bottomTube;
    private Vector2 posTopTube, posBotTube;
    private Rectangle boundsTop,boundsBot;
    private Random rand;

    public Tube (float x){
        topTube = new Texture("pipe-red.png");
        bottomTube = new Texture("pipe-green.png");
        rand = new Random();

        posTopTube = new Vector2(x,rand.nextInt(FLUCTUATION)+Tube_Gap+lowest_Opening);
        posBotTube =new Vector2(x,posTopTube.y-Tube_Gap-bottomTube.getHeight());

        boundsTop = new Rectangle(posTopTube.x,posTopTube.y, topTube.getWidth(), topTube.getHeight());
        boundsBot = new Rectangle(posBotTube.x,posBotTube.y,bottomTube.getWidth(),bottomTube.getHeight());

    }

    public Texture getTopTube() {

        return topTube;
    }

    public Texture getBottomTube() {

        return bottomTube;
    }

    public Vector2 getPosTopTube() {

        return posTopTube;
    }

    public Vector2 getPosBotTube() {

        return posBotTube;
    }
    public void reposition( float x)
    {
        posTopTube.set(x,rand.nextInt(FLUCTUATION)+Tube_Gap+lowest_Opening);
        posBotTube.set(x,posTopTube.y-Tube_Gap-bottomTube.getHeight());
        boundsBot.setPosition(posBotTube.x,posBotTube.y);
        boundsTop.setPosition(posTopTube.x,posTopTube.y);
    }
    public boolean collides(Rectangle player){
        return player.overlaps(boundsTop) || player.overlaps(boundsBot);

    }
}
