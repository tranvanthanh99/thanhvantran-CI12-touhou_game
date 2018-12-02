import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Background {
    BufferedImage image;
    Vector2D position;


    public Background(){
        this.image = SpriteUtils.loadImage("assets/images/background/0 - Copy.png");
        this.position = new Vector2D(0, Settings.SCREEN_HEIGHT - this.image.getHeight());
    }

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
