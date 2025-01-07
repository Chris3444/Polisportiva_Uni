package it.unife.ip;

import java.io.IOException;

import javafx.fxml.FXML;

public class IscrizioneController {
    
    @FXML
        private void switchToPrimary() throws IOException {
            App.setRoot("primary");
        }
}
