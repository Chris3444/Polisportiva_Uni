package it.unife.ip;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import it.unife.ip.model.Atleta;
import it.unife.ip.model.Attivita_Sp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.util.Callback;
import javafx.util.StringConverter;

import static it.unife.ip.util.JsonUtil.readFromJson;
import static it.unife.ip.util.JsonUtil.saveToJson;



public class IscrizioneController {
    
    @FXML
    private ComboBox<Atleta> atletiList;

    @FXML
    private ListView<Attivita_Sp> attivitaList;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

     @FXML
    private void initialize() {
        // Create a list of countries to populate the ComboBox
        ObservableList<Attivita_Sp> attivita;
        ObservableList<Atleta> atleti;

        try {
            File fileA = new File("C:\\Users\\user\\Documents\\uni\\triennale\\2. anno\\Linguaggi di programmazione\\Polisportiva_Uni\\polisportiva\\polisportiva\\src\\main\\resources\\it\\unife\\ip\\json\\attivita_sportive.json");
            File fileB = new File("C:\\Users\\user\\Documents\\uni\\triennale\\2. anno\\Linguaggi di programmazione\\Polisportiva_Uni\\polisportiva\\polisportiva\\src\\main\\resources\\it\\unife\\ip\\json\\atleti.json");

            attivita = readFromJson(fileA, Attivita_Sp.class);
            atleti = readFromJson(fileB, Atleta.class);
        } catch (Exception e) {
            attivita = FXCollections.observableArrayList();
            atleti = FXCollections.observableArrayList();
            e.printStackTrace();
        }
        atletiList.setItems(atleti);
        attivitaList.setItems(attivita);

        attivitaList.setCellFactory(CheckBoxListCell.forListView(
            Attivita_Sp::selectedProperty, // Bind to the selected property
            new StringConverter<Attivita_Sp>() {
                @Override
                public String toString(Attivita_Sp object) {
                    return object.getNome(); // Display only the nome field
                }
    
                @Override
                public Attivita_Sp fromString(String string) {
                    return null; // Not necessary to implement since we don't need this conversion
                }
            }          // Display only the name (nome) in the checkbox
        ));
         atletiList.setCellFactory(new Callback<>() {
            @Override
            public ListCell<Atleta> call(ListView<Atleta> param) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(Atleta person, boolean empty) {
                        super.updateItem(person, empty);
                        if (empty || person == null) {
                            setText(null);
                        } else {
                            setText(person.getNome());
                        }
                    }
                };
            }
        });

        // Set a custom converter to show the selected item's name in the ComboBox field
        (atletiList).setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Atleta atleta, boolean empty) {
                super.updateItem(atleta, empty);
                if (empty || atleta == null) {
                    setText(null);
                } else {
                    setText(atleta.getNome());
                }
            }
        });

    }

    @FXML
    private void iscrivi(){
        ArrayList<Attivita_Sp> attivita = new ArrayList<>();
         // Loop through the items and check if selected
         for (Attivita_Sp item : attivitaList.getItems()) {
            if (item.isSelected()) {
                attivita.add(item);
            }
        }
        Atleta a = new Atleta(atletiList.getValue(),attivita);
        ObservableList<Atleta> atleti;
        try {
            File file = new File("C:\\Users\\user\\Documents\\uni\\triennale\\2. anno\\Linguaggi di programmazione\\Polisportiva_Uni\\polisportiva\\polisportiva\\src\\main\\resources\\it\\unife\\ip\\json\\atleti.json");

            atleti = readFromJson(file, Atleta.class);
        } catch (Exception e) {
            atleti = FXCollections.observableArrayList();
        }
        for(@SuppressWarnings("unused") Atleta existingAtleta: atleti){
            atleti.replaceAll(currentAtleta -> 
                currentAtleta.getNumeroTelefono() == a.getNumeroTelefono() ? a : currentAtleta
            );
        }
        try {
            File file = new File("C:\\Users\\user\\Documents\\uni\\triennale\\2. anno\\Linguaggi di programmazione\\Polisportiva_Uni\\polisportiva\\polisportiva\\src\\main\\resources\\it\\unife\\ip\\json\\atleti.json");

            saveToJson(atleti, file);
            App.setRoot("primary");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    
    
}
