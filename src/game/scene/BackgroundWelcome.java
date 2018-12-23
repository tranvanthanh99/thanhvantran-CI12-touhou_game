package game.scene;

import game.GameObject;
import game.GameWindow;
import game.Settings;
import game.renderer.SingerImageRenderer;
import tklibs.SpriteUtils;

public class BackgroundWelcome extends GameObject {
    public BackgroundWelcome() {
        this.renderer = new SingerImageRenderer(SpriteUtils.loadImage("assets/images/background/background_welcome.jpg"));
        this.position.set(Settings.SCREEN_WIDTH / 2, Settings.SCREEN_HEIGHT / 2);
    }

    @Override
    public void run() {
        super.run();
        if (GameWindow.isAnyKeyPress) {
            ScenceManager.signNewScene(new SceneStage1());
        }
    }
}
