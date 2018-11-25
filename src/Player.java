import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Player {
    BufferedImage image;
    int x, y;
    public Player(){
        this.image = SpriteUtils.loadImage("C:\\Users\\TranVanThanh\\IdeaProjects\\ci-begin-master\\assets\\images\\players\\straight\\0.png");
        this.x = 300;
        this.y = 400;
    }

}
