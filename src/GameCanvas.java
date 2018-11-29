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
        g.fillRect(0, 0 ,600, 600);
        g.drawImage(background.image, background.x,background.y,null);
        g.drawImage(player.image, player.x, player.y, null);
    }

    public  void runALL() {

        this.player.run();
        this.background.run();
    }

    public  void renderALL() {
        this.repaint(); // ~ paint()
    }

    public void gameloop() {

        long lastTimeRun = 0;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTimeRun > 1000 / 60) {
                runALL(); // logic game
                renderALL(); // hien thi game
                lastTimeRun = currentTime;
            }
        }
    }
}
