package it.unife.ip;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.*;
import it.unife.ip.model.Atleta;
import it.unife.ip.model.Attivita_Sp;
import it.unife.ip.view.AtletiView;

import java.io.IOException;
import java.util.*;

public class AtletiController {

        @FXML
        private void switchToPrimary() throws IOException {
            App.setRoot("primary");
        }
        @FXML
        private TableView<Atleta> atletiTable;
    
        @FXML
        public void initialize() {
            // Initialize the table with some data
            /*
             * ObservableList<Atleta> atleti = FXCollections.observableArrayList();
            atleti.add(new Atleta("Mario", "Rossi", "1990-01-01", 1234567890, "mario.rossi@example.com", 
                    new ArrayList<>(List.of(
                            new Attivita_Sp("Calcio", "Gioco di squadra", "18:00-20:00", "Lunedi, Mercoledi"),
                            new Attivita_Sp("Nuoto", "Allenamento in piscina", "10:00-11:00", "Martedi, Giovedi")
                    ))));
            atleti.add(new Atleta("Luigi", "Verdi", "1985-05-20", 987654321, "luigi.verdi@example.com", 
                    new ArrayList<>(List.of(
                            new Attivita_Sp("Ciclismo", "Gare e allenamenti", "08:00-10:00", "Sabato, Domenica"),
                            new Attivita_Sp("Atletica", "Corsa su pista", "17:00-19:00", "Mercoledi, Venerdi")
                    ))));
            atleti.add(new Atleta("Anna", "Bianchi", "1992-07-15", 564738291, "anna.bianchi@example.com", 
                    new ArrayList<>(List.of(
                            new Attivita_Sp("Tennis", "Partite e allenamenti", "16:00-18:00", "Martedi, Giovedi"),
                            new Attivita_Sp("Pallavolo", "Gioco di squadra", "19:00-21:00", "Lunedi, Venerdi")
                    ))));
            atletiTable.setItems(atleti);
             * 
             * 
             */
            
    
        }

  
}