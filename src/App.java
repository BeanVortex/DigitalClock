
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage pStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/clock.fxml"));
        loader.load();

        pStage.setTitle("Digital Clock");
        pStage.setScene(new Scene(loader.getRoot()));
        pStage.setMinWidth(930);
        pStage.setMinHeight(400);
        pStage.show();

    }
}
