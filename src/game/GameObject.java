package game;

import game.renderer.Renderer;
import game.renderer.TextRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    public Renderer renderer;
    public Vector2D position;

    public GameObject() {
//        this.image
        this.position = new Vector2D(0, 0);
    }

    public void run() {

    }

    public void render(Graphics g) {
        if (this.renderer != null){
            this.renderer.render(g, this);
        }

    }
}
