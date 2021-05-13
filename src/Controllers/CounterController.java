package Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CounterController implements Initializable {

    @FXML
    private Rectangle a,e,c,g,b,d,f;

    private List<Rectangle> rectangles = new ArrayList<>();

    private void setColor(Rectangle... rectangles) {
        reset();
        for (Rectangle rec : rectangles) {
            rec.setFill(Color.BLUE);
        }
    }

    private void reset() {
        for (Rectangle rec : rectangles) {
            rec.setFill(Color.LIGHTGRAY);
        }
    }

    public void displayNumber(int number) {
        switch (number) {
        case 0:
            setColor(a, e, c, g, b, f);
            break;
        case 1:
            setColor(c, g);
            break;
        case 2:
            setColor(e, c, d, b, f);
            break;
        case 3:
            setColor(c, g, b, d, f);
            break;
        case 4:
            setColor(a, c, g, d);
            break;
        case 5:
            setColor(a, g, b, d, f);
            break;
        case 6:
            setColor(a, e, g, b, d, f);
            break;
        case 7:
            setColor(c, g, b);
            break;
        case 8:
            setColor(a, e, c, g, b, d, f);
            break;
        case 9:
            setColor(a, c, g, b, d, f);
            break;
        default:
            reset();
        }
    }

    @Override
    public void initialize(URL loc, ResourceBundle resources) {
        rectangles.addAll(Arrays.asList(a, e, c, g, b, d, f));
    }

}