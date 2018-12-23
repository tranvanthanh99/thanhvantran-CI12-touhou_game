package game.scene;

import game.FrameCounter;
import game.GameObject;
import game.GameWindow;
import game.Settings;
import game.renderer.SingerImageRenderer;
import tklibs.SpriteUtils;

public class BackgroundGameOver extends GameObject {
    FrameCounter counter;


    public BackgroundGameOver() {
        this.renderer = new SingerImageRenderer(SpriteUtils.loadImage("assets/images/background/game-over-background.jpg"));
        this.position.set(Settings.SCREEN_WIDTH / 2, Settings.SCREEN_HEIGHT / 2);
        this.counter = new FrameCounter(60);

    }

    @Override
    public void run() {
        super.run();
        if (GameWindow.isAnyKeyPress && this.counter.run()) {
            ScenceManager.signNewScene(new SceneStage1());
            this.counter.reset();
        }
    }
}
