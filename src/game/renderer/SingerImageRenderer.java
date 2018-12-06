package game.renderer;

import game.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SingerImageRenderer extends Renderer{
    BufferedImage image;
    public SingerImageRenderer(BufferedImage image) {
        this.image = image;
    }
    @Override
    public void render(Graphics g, GameObject master) {
        g.drawImage(this.image, (int)master.position.x, (int)master.position.y, null);
    }
}
