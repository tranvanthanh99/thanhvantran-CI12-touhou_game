package game.renderer;

import game.GameObject;

import java.awt.*;

public class TextRenderer {
    String text;

    public TextRenderer(String text) {
        this.text = text;
    }

    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawString(this.text, 100, 100);

    }
}
