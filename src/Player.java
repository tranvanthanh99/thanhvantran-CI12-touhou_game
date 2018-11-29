import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Player {
    Background background;
    BufferedImage image;
    int x, y;
    public Player(){
        this.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.x = 200;
        this.y = 300;
        this.background = new Background();
    }

    public void run() {
        if (GameWindow.isUpPress && this.y >= 0) {
            this.y -= 5;
        }
        if (GameWindow.isDownPress && this.y <= 600 - this.image.getHeight()*2) {
            this.y += 5;
        }
        if (GameWindow.isRightPress && this.x <= background.image.getWidth() - this.image.getWidth()) {
            this.x += 5;
        }
        if (GameWindow.isLeftPress && this.x >= 0) {
            this.x -= 5;
        }


    }

}
