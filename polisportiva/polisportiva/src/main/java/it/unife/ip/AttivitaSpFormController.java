package it.unife.ip;

import static it.unife.ip.util.JsonUtil.appendToJson;

import java.io.File;
import java.io.IOException;

import it.unife.ip.model.Attivita_Sp;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AttivitaSpFormController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField descriptionField;

    
    @FXML
    private TextField hoursField;

    @FXML
    private TextField daysField;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private void iscrivi(){
        String name = nameField.getText();
        String description = descriptionField.getText();
        String hours = hoursField.getText();
        String days = daysField.getText();
        
        Attivita_Sp attivita = new Attivita_Sp(name, description, hours, days);
        File file = new File("C:\\Users\\user\\Documents\\uni\\triennale\\2. anno\\Linguaggi di programmazione\\Polisportiva_Uni\\polisportiva\\polisportiva\\src\\main\\resources\\it\\unife\\ip\\json\\attivita_sportive.json");
        try {
            appendToJson(file, attivita, Attivita_Sp.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            App.setRoot("attivita_sp");
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
