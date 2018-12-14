package game.player;

import game.GameObject;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.renderer.Animation;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class PlayerBullet extends GameObject implements Physics {
    BufferedImage image;
    BoxCollider boxCollider;

    public PlayerBullet() {
        super();
        this.image = SpriteUtils.loadImage("assets/images/player-bullets/a/3.png");
        this.createRenderer();
        this.velocity.set(0, -3);
        this.boxCollider = new BoxCollider();
    }

    public void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/3.png"));
        this.renderer = new Animation(images);

    }

    @Override
    public void run() {
        super.run();
        if (this.position.y < -30) this.destroy();
//        this.position.addThis(0, -5);
    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
