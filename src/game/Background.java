package game;

import game.renderer.SingerImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject{
    BufferedImage image;

    public Background(){
        super();
        this.image = SpriteUtils.loadImage("assets/images/background/0 - Copy.png");
        this.renderer = new SingerImageRenderer(image);
        this.position.set(0, Settings.SCREEN_HEIGHT - image.getHeight());

//        this.position = new game.Vector2D(0, game.Settings.SCREEN_HEIGHT - this.image.getHeight());
    }

    @Override
    public void run(){
        if (this.position.y < 0) {
            this.position.addThis(0, 10);
        }
        else {
//            this.y = 600 - this.image.getHeight();
            this.position.set(this.position.x , Settings.SCREEN_HEIGHT - this.image.getHeight());
        }

    }

}
