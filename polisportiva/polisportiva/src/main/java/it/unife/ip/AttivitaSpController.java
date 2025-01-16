package it.unife.ip;

import static it.unife.ip.util.JsonUtil.deleteFromJson;
import static it.unife.ip.util.JsonUtil.readFromJson;
import static it.unife.ip.util.JsonUtil.saveToJson;

import java.io.File;
import java.io.IOException;


import javafx.util.Callback;
import javafx.scene.control.*;
import it.unife.ip.model.Attivita_Sp;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AttivitaSpController {
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private TableView<Attivita_Sp> tableView;

    @FXML
    private TableColumn<Attivita_Sp, String> nameColumn;

    @FXML
    private TableColumn<Attivita_Sp, String> descriptionColumn;

    @FXML
    private TableColumn<Attivita_Sp, String> hoursColumn;

    @FXML
    private TableColumn<Attivita_Sp, String> daysColumn;

    @FXML
    private TableColumn<Attivita_Sp, Void> deleteColumn;


    @FXML
    private void initialize() {
        tableView.setEditable(true);
        ObservableList<Attivita_Sp> attivita;
        File file = new File("C:\\Users\\user\\Documents\\uni\\triennale\\2. anno\\Linguaggi di programmazione\\Polisportiva_Uni\\polisportiva\\polisportiva\\src\\main\\resources\\it\\unife\\ip\\json\\attivita_sportive.json");
        try {
            attivita = readFromJson(file, Attivita_Sp.class);
        } catch (IOException e) {
            attivita = FXCollections.observableArrayList();
            e.printStackTrace();
        }
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("descrizione"));
        hoursColumn.setCellValueFactory(new PropertyValueFactory<>("orari"));
        daysColumn.setCellValueFactory(new PropertyValueFactory<>("giorni"));
        
        tableView.setItems(attivita);
        Platform.runLater(() -> {
            double percentageWidth = 0.2;  // 20% width for the "Giorni" column
            double newWidth = tableView.getWidth() * percentageWidth;
            daysColumn.setPrefWidth(newWidth);
            nameColumn.setPrefWidth(newWidth);
            descriptionColumn.setPrefWidth(newWidth);
            hoursColumn.setPrefWidth(newWidth);
        });

        nameColumn.setOnEditCommit(event -> {
            Attivita_Sp attivitaSp = event.getRowValue();
            attivitaSp.setNome(event.getNewValue());
        });
        daysColumn.setOnEditCommit(event -> {
            Attivita_Sp attivitaSp = event.getRowValue();
            attivitaSp.setGiorni(event.getNewValue());
        });
        hoursColumn.setOnEditCommit(event -> {
            Attivita_Sp attivitaSp = event.getRowValue();
            attivitaSp.setOrari(event.getNewValue());
        });
        descriptionColumn.setOnEditCommit(event -> {
            Attivita_Sp attivitaSp = event.getRowValue();
            attivitaSp.setDescrizione(event.getNewValue());
        });
        addButton(file);

    }

    @FXML
    public void modify(){
        ObservableList<Attivita_Sp> attivita = tableView.getItems();
        attivita.forEach(at -> System.out.println("Saving Person: " + at));
        try {
            File file = new File("C:\\Users\\user\\Documents\\uni\\triennale\\2. anno\\Linguaggi di programmazione\\Polisportiva_Uni\\polisportiva\\polisportiva\\src\\main\\resources\\it\\unife\\ip\\json\\attivita_sportive.json");
            saveToJson(attivita, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Data saved to JSON.");
    }

    @FXML
    private void add() throws IOException{
        App.setRoot("attivitaSpForm");
    }

    private void addButton(File file){
        Callback<TableColumn<Attivita_Sp, Void>,TableCell<Attivita_Sp, Void>> cellFactory = new Callback<TableColumn<Attivita_Sp, Void>,TableCell<Attivita_Sp, Void>>() {
            @Override
            public TableCell<Attivita_Sp,Void> call(final TableColumn<Attivita_Sp,Void> param){
                final TableCell<Attivita_Sp,Void> cell = new TableCell<Attivita_Sp,Void>() {
                    private final Button btn = new Button("Delete");
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            
                            try {
                                Attivita_Sp attivitaSp = getTableView().getItems().get(getIndex());
                                deleteFromJson(file, attivitaSp, Attivita_Sp.class);
                                getTableView().getItems().remove(attivitaSp);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            
                        });
                    }
                    @Override
                    public void updateItem(Void item, boolean empty){
                        super.updateItem(item, empty);
                        if(empty){
                            setGraphic(null);
                        }else{
                            setGraphic(btn);
                        }
                    }
                
                };
                return cell;

            
            }
        };

        deleteColumn.setCellFactory(cellFactory);
        
    }

}
