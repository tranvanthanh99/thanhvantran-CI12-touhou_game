package game;

import game.renderer.Renderer;
import game.renderer.TextRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    // Static
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();

    public static void addGameObject(GameObject object) {
        gameObjects.add(object);
    }

    // class<E> clazz = Background.class
    // E ~ background

    public static <E extends GameObject> E createGameObject(Class<E> clazz) {
        try {
            E newInstance = clazz.newInstance();
            addGameObject(newInstance);
            return newInstance; // new E()
        } catch (Exception Ex) {
            return null;
        }
    }

    public static void runAll() {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            object.run();
        }
    }

    public static void renderAll(Graphics g) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            object.render(g);
        }
    }
    //


    public Renderer renderer;
    public Vector2D position;
    public Vector2D anchor;
    public Vector2D velocity;

    public GameObject() {
//        this.image
        this.position = new Vector2D(0, 0);
        this.anchor = new Vector2D(0.5f, 0.5f);
        this.velocity = new Vector2D();
    }



    public void run() {
        this.position.addThis(this.velocity);
    }

    public void render(Graphics g) {
        if (this.renderer != null){
            this.renderer.render(g, this);
        }

    }
}
