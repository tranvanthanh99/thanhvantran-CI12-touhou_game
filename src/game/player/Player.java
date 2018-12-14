package game.player;

import game.*;
import game.renderer.Animation;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
    Background background;
    FrameCounter fireCounter;


    public Player(){
        super();
//        this.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.position.set(Settings.PLAYER_POSITION_X, Settings.PLAYER_POSITION_Y);
        this.createRenderer();
        this.background = new Background();
        this.fireCounter = new FrameCounter(20);
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));
//        this.renderer = new Animation(images);
        this.renderer = new PlayerRenderer("player", images);
    }


    @Override
    public void run() {
        super.run();
        this.move();

        if (this.fireCounter.run()) {
            this.fire();

        }
        this.limitPlayerPosition();
    }

    private void fire() {

        if (GameWindow.isSpacePress) {
            PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
            bullet.position = new Vector2D(this.position.x, this.position.y - bullet.image.getHeight());
//            GameObject.addGameObject(bullet);
            this.fireCounter.reset();

        }
    }

    public void move() {
        int vx = 0;
        int vy = 0;
        int speed = 5;
        if (GameWindow.isUpPress ) {
            vy --;
        }
        if (GameWindow.isDownPress ) {
            vy ++;
        }
        if (GameWindow.isRightPress ) {
            vx ++;
        }
        if (GameWindow.isLeftPress ) {
            vx --;
        }
        this.velocity.set(vx, vy);
        this.velocity.setLength(speed);
    }

    private void limitPlayerPosition() {
//        BufferedImage image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        int halfWidth = (int) (Settings.PLAYER_WIDTH *  this.anchor.x);
        int halfHeight = (int) (Settings.PLAYER_HEIGHT *  this.anchor.y);

        // limit x [0, background.image.getwidth()]
        float x = (float) Mathx.clamp(this.position.x, halfWidth, background.image.getWidth() - halfWidth);
        // limit y [0 , max y]
        float y = (float) Mathx.clamp(this.position.y, halfHeight, Settings.SCREEN_HEIGHT - halfHeight);
        this.position.set(x, y);
    }


}
