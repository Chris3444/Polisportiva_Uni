package it.unife.ip;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static it.unife.ip.util.JsonUtil.appendToJson;
import static it.unife.ip.util.JsonUtil.saveToJson;

import it.unife.ip.model.Atleta;
import it.unife.ip.model.Attivita_Sp;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class IscrizioneController {
    
    @FXML
    private TextField nameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField adressField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField emailField;

    @FXML 
    private ComboBox<Attivita_Sp> activityField;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
  

    @FXML
    private void initialize() {
        // Create a list of countries to populate the ComboBox
        List<Attivita_Sp> attivita = Arrays.asList(
                new Attivita_Sp("Calcio", "Descrizione Calcio", "Orari Calcio", "Giorni Calcio")
        );

        // Set the items in the ComboBox
        activityField.getItems().addAll(attivita);
    }

    @FXML
    private void iscrivi() {
        String name = nameField.getText();
        String lastName = lastNameField.getText();
        String date = datePicker.getValue().toString();
        int phone = Integer.parseInt(phoneField.getText());
        String adress = adressField.getText();
        String email = emailField.getText();
        Attivita_Sp attivita_Sp = activityField.getValue();  // Retrieve the selected Country 
        ArrayList<Attivita_Sp> attivita = new ArrayList<>();
        attivita.add(attivita_Sp);
        
        //(String nome, String cognome, String dataNascita, String indirizzo, int numeroTelefono, String email, ArrayList<Attivita_Sp> attivita)
        Atleta atleta = new Atleta(name, lastName, date, adress, phone, email, attivita);
        File file = new File("C:\\Users\\user\\Documents\\uni\\triennale\\2. anno\\Linguaggi di programmazione\\Polisportiva_Uni\\polisportiva\\polisportiva\\src\\main\\resources\\it\\unife\\ip\\json\\atleti.json");
        try {
            appendToJson(file, atleta , Atleta.class);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(atleta);
    }
}
