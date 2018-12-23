package game.scene;

import game.GameObject;

public class ScenceGameOver extends Scence{

    @Override
    void init() {
        BackgroundGameOver background = GameObject.recycle(BackgroundGameOver.class);
    }

    @Override
    void clear() {
        GameObject.clearAll();
    }
}
