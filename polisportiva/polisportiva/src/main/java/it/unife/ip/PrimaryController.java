package it.unife.ip;

import java.io.IOException;
import javafx.util.*;
import java.util.Random;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.paint.Color;


public class PrimaryController {

    @FXML
    private Button atleti;   // Button at top-left
    @FXML
    private Button attivitaSp; // Button at top-right
    @FXML
    private Button iscrizione; // Button at bottom-left
    @FXML
    private Button bottomRight; // Button at bottom-right

    @FXML
    public void initialize() {
        // Apply random colors to all buttons
        atleti.setStyle(atleti.getStyle() + "-fx-background-color: " + getRandomColorHex() + ";");
        attivitaSp.setStyle(attivitaSp.getStyle() + "-fx-background-color: " + getRandomColorHex() + ";");
        iscrizione.setStyle(iscrizione.getStyle() + "-fx-background-color: " + getRandomColorHex() + ";");
    
        bottomRight.setStyle(bottomRight.getStyle() + "-fx-background-color: " + getRandomColorHex() + ";");
        addRotateOnHover(atleti);
        addRotateOnHover(attivitaSp);
        addRotateOnHover(iscrizione);
        addRotateOnHover(bottomRight);

    }

    private void addRotateOnHover(Button button) {
        RotateTransition spin = new RotateTransition(Duration.millis(100), button); // 100ms for fast rotation
        spin.setByAngle(360); // Full spin (360 degrees)
        spin.setCycleCount(RotateTransition.INDEFINITE); // Infinite spinning

        // Start spinning on mouse hover
        button.setOnMouseEntered(event -> spin.play());
        // Stop spinning when the mouse exits
        button.setOnMouseExited(event -> spin.stop());
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
    @FXML
    private void switchToIscrizione() throws IOException {
        App.setRoot("iscrizione");
    }

    @FXML
    private void switchToAttivitaSp() throws IOException {
        App.setRoot("attivita_Sp");
    }
    
}
