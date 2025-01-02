package it.unife.ip.view;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import it.unife.ip.model.Atleta;
import it.unife.ip.model.Attivita_Sp;

import java.util.ArrayList;
import java.util.List;

public class AtletiView extends StackPane {

    // TableView and its columns
    private TableView<Atleta> atletiTable;
    private TableColumn<Atleta, String> nome;
    private TableColumn<Atleta, String> cognome;
    private TableColumn<Atleta, String> dataNascita;
    private TableColumn<Atleta, Long> numeroTelefono;
    private TableColumn<Atleta, String> email;
    private TableColumn<Atleta, List<Attivita_Sp>> sportColumn;

    public AtletiView() {
        // Initialize the UI components
        atletiTable = new TableView<>();
        nome = new TableColumn<>("Nome");
        cognome = new TableColumn<>("Cognome");
        dataNascita = new TableColumn<>("Data Nascita");
        numeroTelefono = new TableColumn<>("Numero Telefono");
        email = new TableColumn<>("Email");
        sportColumn = new TableColumn<>("Attività Sportiva");

        // Set up the columns' cell value factories
        nome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
        cognome.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCognome()));
        dataNascita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDataNascita()));
        numeroTelefono.setCellValueFactory(cellData -> new SimpleLongProperty(cellData.getValue().getNumeroTelefono()).asObject());
        email.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));

        // Custom cell factory for the sport column
        sportColumn.setCellFactory(column -> new TableCell<Atleta, List<Attivita_Sp>>() {
            @Override
            protected void updateItem(List<Attivita_Sp> attivita, boolean empty) {
                super.updateItem(attivita, empty);
                if (empty || attivita == null) {
                    setText(null);
                } else {
                    setText(attivita.stream()
                            .map(Attivita_Sp::getNome)  // Assuming Attivita_Sp has a getName() method
                            .reduce((a, b) -> a + ", " + b)
                            .orElse(""));
                }
            }
        });

        // Add columns to TableView
        atletiTable.getColumns().addAll(nome, cognome, dataNascita, numeroTelefono, email, sportColumn);
    }

    public Scene createScene() {
        // Create the root layout
        BorderPane root = new BorderPane();
        root.setCenter(atletiTable);

        // Create a scene
        return new Scene(root, 800, 600);
    }

    public TableView<Atleta> getAtletiTable() {
        return atletiTable;
    }
    public StackPane getRoot() {
        return this;  // This returns the current instance of AtletiView, which is a StackPane
    }
}