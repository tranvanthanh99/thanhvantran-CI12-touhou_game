import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    // thuoc tinh
    Background background;
    Player player;
    PlayerBullet playerBullet;
    public static ArrayList<PlayerBullet> playerBullets =new ArrayList<>() ;


    public GameCanvas(){
        this.setBackground(Color.BLACK);
        this.background = new Background();
        this.player = new Player();

    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(0, 0 ,600, 600);
        g.drawImage(background.image, (int) background.position.x,(int) background.position.y,null);
        g.drawImage(player.image,(int) player.position.x,(int) player.position.y, null);

        for ( int i = 0; i < playerBullets.size(); i++){
            g.drawImage(playerBullets.get(i).image, (int) playerBullets.get(i).position.x, (int) playerBullets.get(i).position.y, null);

        }

    }

    public  void runALL() {

        this.player.run();
        this.background.run();
        for ( int i = 0; i < playerBullets.size(); i++){
            this.playerBullets.get(i).run();

        }
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
