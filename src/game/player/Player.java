package game.player;

import game.*;
import game.renderer.Animation;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
    Background background;


    public Player(){
        super();
//        this.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.position.set(Settings.PLAYER_POSITION_X, Settings.PLAYER_POSITION_Y);
        this.createRenderer();
        this.background = new Background();
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


    int count = 0; // TODO: se fix
    @Override
    public void run() {

        this.move();
        count++;
        if (count > 20) {
            this.fire();

        }
        this.limitPlayerPosition();
    }

    private void fire() {

        if (GameWindow.isSpacePress) {
            PlayerBullet bullet = new PlayerBullet();
            bullet.position = new Vector2D(this.position.x, this.position.y - bullet.image.getHeight());
            GameObject.addGameObject(bullet);
            count = 0;

        }
    }

    public void move() {
        if (GameWindow.isUpPress ) {

            this.position.addThis(0 , -5);
        }
        if (GameWindow.isDownPress ) {

            this.position.addThis(0 , 5);
        }
        if (GameWindow.isRightPress ) {

            this.position.addThis(5 , 0);
        }
        if (GameWindow.isLeftPress ) {

            this.position.addThis(-5 , 0);
        }
    }

    private void limitPlayerPosition() {
        BufferedImage image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        int halfWidth = (int) (Settings.PLAYER_WIDTH *  this.anchor.x);
        int halfHeight = (int) (Settings.PLAYER_HEIGHT *  this.anchor.y);

        // limit x [0, background.image.getwidth()]
        float x = (float) Mathx.clamp(this.position.x, halfWidth, background.image.getWidth() - halfWidth);
        // limit y [0 , max y]
        float y = (float) Mathx.clamp(this.position.y, halfHeight, Settings.SCREEN_HEIGHT - halfHeight);
        this.position.set(x, y);
    }


}
