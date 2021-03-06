package game.enemy;

import game.*;
import game.physics.BoxCollider;
import game.physics.Physics;
import tklibs.Mathx;
import tklibs.SpriteUtils;
import game.renderer.Animation;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObjectPhysics {
    Background background;
    FrameCounter fireCounter;

    public Enemy() {
        super();
        this.position.set(0,0);
        this.velocity.set(3, -1);
        this.background = new Background();
        this.createRenderer();
        this.boxCollider = new BoxCollider(this.position, this.anchor, 20, 20);
        this.fireCounter = new FrameCounter(20);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/6.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/7.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/8.png"));
        this.renderer = new Animation(images);

    }

    public void run() {
        super.run();
        this.move();
        this.fire();

    }

    private void move() {
        if (this.position.x > this.background.image.getWidth() - 14
                && this.velocity.x >0) {
            this.velocity.set(-3, this.velocity.y);
        }

        if (this.position.x < 14 && this.velocity.x <0) {
            this.velocity.set(3, this.velocity.y);
        }

        if (this.position.y > Settings.SCREEN_HEIGHT - 14
                && this.velocity.x >0) {
            this.velocity.set(this.velocity.x, -1);
        }

        if (this.position.y < 14 && this.velocity.y <0) {
            this.velocity.set(this.velocity.x, 1);
        }
    }

    private void fire() {
        if (fireCounter.run()) {
            EnemyBullet bullet = GameObject.recycle(EnemyBullet.class);
            bullet.position.set(this.position.x, this.position.y );
            this.fireCounter.reset();
        }

    }

    @Override
    public void destroy() {
        super.destroy();
        EnemyExplosion explosion = GameObject.recycle(EnemyExplosion.class);
        explosion.position.set(this.position);
    }
}
