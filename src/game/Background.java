package game;

import game.renderer.SingerImageRenderer;
import game.renderer.TextRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject{
     public BufferedImage image;

    public Background(){
        super();
        this.image = SpriteUtils.loadImage("assets/images/background/0 - Copy.png");
        this.renderer = new SingerImageRenderer(image);
        this.position.set(0, Settings.SCREEN_HEIGHT - image.getHeight());
        this.anchor.set(0,0);
        this.velocity.set(0, 10);
//        this.position = new game.Vector2D(0, game.Settings.SCREEN_HEIGHT - this.image.getHeight());
    }

    @Override
    public void run(){
        super.run();
        if (this.position.y > 0) {
            this.position.set(0,  Settings.SCREEN_HEIGHT - image.getHeight());
//            this.velocity.set(0, 0);
        }

    }

}
