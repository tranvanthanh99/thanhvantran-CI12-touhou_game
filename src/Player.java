import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Player {
    Background background;
    BufferedImage image;
    Vector2D position;
    PlayerBullet playerBullet;

    public Player(){
        this.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.position = new Vector2D(Settings.PLAYER_POSITION_X, Settings.PLAYER_POSITION_Y);
        this.background = new Background();


    }

    public void run() {

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
        if (GameWindow.isSpacePress) {
            this.playerBullet = new PlayerBullet();
            this.playerBullet.position = new Vector2D(this.position.x, this.position.y - playerBullet.image.getHeight());
            GameCanvas.playerBullets.add(this.playerBullet);

        }

        limitPlayerPosition();

    }
    private void limitPlayerPosition() {
        // limit x [0, background.image.getwidth()]
        float x = (float) Mathx.clamp(this.position.x, 0, background.image.getWidth() - this.image.getWidth());
        // limit y [0 , max y]
        float y = (float) Mathx.clamp(this.position.y, 0, Settings.SCREEN_HEIGHT - this.image.getHeight());
        this.position.set(x, y);
    }

}
