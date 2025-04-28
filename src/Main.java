import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.PainelBemVindo;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        PainelBemVindo painelBemVindo = new PainelBemVindo(stage);
        Scene scene = new Scene(painelBemVindo, 950, 650);
        stage.setScene(scene);
        stage.setTitle("App Câmara Fria");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}