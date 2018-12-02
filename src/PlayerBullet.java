import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class PlayerBullet {
    BufferedImage image;
    Vector2D position;


    public PlayerBullet() {
        this.image = SpriteUtils.loadImage("assets/images/player-bullets/a/3.png");
        this.position = new Vector2D(0,0);
    }

    public void run() {
        this.position.y -= 10;
    }
}
