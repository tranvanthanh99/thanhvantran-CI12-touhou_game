import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    // thuoc tinh
    Background background;
    Player player;

    public GameCanvas(){
        this.setBackground(Color.BLACK);
        this.background = new Background();
        this.player = new Player();

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(background.image, background.x,background.y,null);
        g.drawImage(player.image, player.x, player.y, null);
    }
}
