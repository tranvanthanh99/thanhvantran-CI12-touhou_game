package game;

import game.enemy.Enemy;
import game.enemy.EnemySummoner;
import game.player.Player;
import game.scene.Scence;
import game.scene.ScenceGameOver;
import game.scene.ScenceManager;
import game.scene.SceneWelcome;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {


    public GameCanvas(){
        this.setBackground(Color.white);
////        GameObject.addGameObject(new Background());
//        GameObject.recycle(Background.class);
////        GameObject.addGameObject(new Player());
//        GameObject.recycle(Player.class);
////        GameObject.addGameObject(new Enemy());
//        GameObject.recycle(EnemySummoner.class);
        ScenceManager.signNewScene(new SceneWelcome());

    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(0, 0 ,600, 600);
        GameObject.renderAll(g);

    }

    public  void runALL() {

        GameObject.runAll();

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
