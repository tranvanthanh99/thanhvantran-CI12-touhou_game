package game;

import game.renderer.TextRenderer;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GameCanvas extends JPanel {
    // thuoc tinh
    Background background;
    Player player;
    public static ArrayList<PlayerBullet> playerBullets ;
    TextRenderer text = new TextRenderer("ABCDEFGH");

    public GameCanvas(){
        this.setBackground(Color.white);
        this.background = new Background();
        this.player = new Player();
        this.playerBullets = new ArrayList<>();

    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(0, 0 ,600, 600);
        this.background.render(g);
        this.player.render(g);
        this.text.render(g);
        for ( int i = 0; i < playerBullets.size(); i++){
            PlayerBullet bullet = this.playerBullets.get(i);
//            g.drawImage(bullet.image, (int) bullet.position.x, (int) bullet.position.y, null);
            bullet.render(g);
        }

    }

    public  void runALL() {

        this.player.run();
        this.background.run();
        for ( int i = 0; i < playerBullets.size(); i++){
            PlayerBullet bullet = this.playerBullets.get(i);
            bullet.run();

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
