package game;

import game.renderer.TextRenderer;

import java.awt.*;

/**
 * Created by huynq on 7/4/17.
 */
// khai bao bien, ham, sd kieu du lieu, cau truc lenh if else switch/ case vong lap, class


public class Program {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        GameCanvas gameCanvas = new GameCanvas();
        gameCanvas.setPreferredSize(new Dimension(Settings.SCREEN_WIDTH , Settings.SCREEN_HEIGHT));
        gameWindow.add(gameCanvas);
        gameWindow.pack();
        gameCanvas.gameloop();

    }

}
