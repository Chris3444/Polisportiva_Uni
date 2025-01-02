package it.unife.ip;

import java.io.IOException;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class PrimaryController {

    @FXML
    private Button atleti;   // Button at top-left
    @FXML
    private Button topRight; // Button at top-right
    @FXML
    private Button bottomLeft; // Button at bottom-left
    @FXML
    private Button bottomRight; // Button at bottom-right

    @FXML
    public void initialize() {
        // Apply random colors to all buttons
        atleti.setStyle(atleti.getStyle() + "-fx-background-color: " + getRandomColorHex() + ";");
        topRight.setStyle(topRight.getStyle() + "-fx-background-color: " + getRandomColorHex() + ";");
        bottomLeft.setStyle(bottomLeft.getStyle() + "-fx-background-color: " + getRandomColorHex() + ";");
    
        bottomRight.setStyle(bottomRight.getStyle() + "-fx-background-color: " + getRandomColorHex() + ";");
    }

    // Method to generate a random color in hex format
    private String getRandomColorHex() {
        Random random = new Random();
        double red = random.nextDouble();
        double green = random.nextDouble();
        double blue = random.nextDouble();
        Color randomColor = Color.color(red, green, blue);
        return String.format("#%02x%02x%02x", 
            (int)(randomColor.getRed() * 255), 
            (int)(randomColor.getGreen() * 255), 
            (int)(randomColor.getBlue() * 255));
    }
    @FXML
    private void switchToAtleti() throws IOException {
        App.setRoot("atleti");
    }
}
