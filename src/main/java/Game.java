import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.input.KeyCode;


public class Game extends GameApplication {

    private Entity player;

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(1920);
        settings.setHeight(1080);
        settings.setMainMenuEnabled(false);
        settings.setTitle("Prince of Jank");
        settings.setVersion("0.1.2");
        settings.setTicksPerSecond(60);
    }

    @Override
    protected void initGame(){

        player = FXGL.entityBuilder()
                .at(800, 540)
                .view("player.png")
                .buildAndAttach();

        FXGL.getGameWorld().addEntityFactory(new factory());
        FXGL.setLevelFromMap("Level1.tmx");
    }

    @Override
    protected void initInput() {
        FXGL.onKey(KeyCode.SPACE, () -> {
            player.translateY(-5);
        });

        FXGL.onKey(KeyCode.A, () -> {
            player.translateX(-5);
        });

        FXGL.onKey(KeyCode.D, () -> {
            player.translateX(5);
        });

        FXGL.onKey(KeyCode.S, () -> {
            player.translateY(5);
        });


    }

    public static void main(String [] args) {
        launch(args);
    }
}
