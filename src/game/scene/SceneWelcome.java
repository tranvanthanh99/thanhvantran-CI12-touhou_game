package game.scene;

import game.GameObject;

public class SceneWelcome extends Scence{

    @Override
    void init() {
        BackgroundWelcome background = GameObject.recycle(BackgroundWelcome.class);
    }

    @Override
    void clear() {
        GameObject.clearAll();
    }
}
