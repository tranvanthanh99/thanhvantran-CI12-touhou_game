package game.enemy;

import game.Background;
import game.GameObject;
import game.Settings;
import tklibs.Mathx;
import tklibs.SpriteUtils;
import game.renderer.Animation;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject {
    Background background;
    boolean checkX = false, checkY = false;

    public Enemy() {
        super();
        this.position.set(50, 50);
        this.background = new Background();
        this.createRenderer();
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

        if (this.position.x == 16) {
            checkX = true;
        }
        else if (this.position.x == 368) {
            checkX = false;
        }

        if (this.position.y == 570) {
            checkY = true;
        }
        else if (this.position.y == 25){
            checkY = false;
        }

        if (checkX) {
            this.position.addThis(3,0);
        }
        else {
            this.position.addThis(-3,0);
        }

        if (checkY) {
            this.position.addThis(0 , -0.5f);
        }
        else {
            this.position.addThis(0 , 0.5f);
        }

        this.limitEnemyPosition();
    }

    private void limitEnemyPosition() {
        BufferedImage image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        int halfWidth = (int) (Settings.ENEMY_WIDTH *  this.anchor.x);
        int halfHeight = (int) (Settings.ENEMY_HEIGHT *  this.anchor.y);

        float x = (float) Mathx.clamp(this.position.x, halfWidth, background.image.getWidth() - halfWidth);

        float y = (float) Mathx.clamp(this.position.y, halfHeight, Settings.SCREEN_HEIGHT - halfHeight);
        this.position.set(x, y);
    }
}
