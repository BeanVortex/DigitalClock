package Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class ClockController implements Initializable {

    @FXML
    private HBox root;

    List<CounterController> cControllers = new ArrayList<>();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        for (int i = 0; i < 6; i++) {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Views/counter.fxml"));

            try {
                loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }

            root.getChildren().add(loader.getRoot());
            cControllers.add(loader.getController());
        }
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);

        Thread t = new Thread(() -> {

            while (true) {
                Calendar calendar = Calendar.getInstance();
                cControllers.get(0).displayNumber(calendar.get(Calendar.HOUR_OF_DAY) / 10);
                cControllers.get(1).displayNumber(calendar.get(Calendar.HOUR_OF_DAY) % 10);
                cControllers.get(2).displayNumber(calendar.get(Calendar.MINUTE) / 10);
                cControllers.get(3).displayNumber(calendar.get(Calendar.MINUTE) % 10);
                cControllers.get(4).displayNumber(calendar.get(Calendar.SECOND) / 10);
                cControllers.get(5).displayNumber(calendar.get(Calendar.SECOND) % 10);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        t.start();
    }

}
