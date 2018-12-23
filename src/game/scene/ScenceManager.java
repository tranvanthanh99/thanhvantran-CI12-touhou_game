package game.scene;

public class ScenceManager {
    public static Scence currentScene;

    public static void signNewScene(Scence newScene) {
        if (currentScene != null) {
            currentScene.clear();
        }
        newScene.init();
        currentScene = newScene;
    }
}
