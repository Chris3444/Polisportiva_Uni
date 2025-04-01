package it.unife.ip;

import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import it.unife.ip.model.Atleta;
import it.unife.ip.model.Attivita_Sp;
import static it.unife.ip.util.JsonUtil.deleteFromJson;
import static it.unife.ip.util.JsonUtil.readFromJson;
import static it.unife.ip.util.JsonUtil.saveToJson;
import java.io.File;
import java.io.IOException;

public class AtletiController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private TableView<Atleta> atletiTable;

    @FXML
    private TableColumn<Atleta, String> nameColumn;

    @FXML
    private TableColumn<Atleta, String> lastNameColumn;

    @FXML
    private TableColumn<Atleta, String> dateColumn;

    @FXML
    private TableColumn<Atleta, String> phoneColumn;

    @FXML
    private TableColumn<Atleta, String> emailColumn;

    @FXML
    private TableColumn<Atleta, String> adressColumn;
    @FXML
    private TableColumn<Atleta, ObservableList<String>> activityColumn;

    @FXML
    private TableColumn<Atleta, Void> deleteColumn;

    @FXML
    private void initialize() {
        atletiTable.setEditable(true);
        ObservableList<Atleta> atleti;
        File file = new File("C:\\Users\\user\\Documents\\uni\\triennale\\2. anno\\Linguaggi di programmazione\\Polisportiva_Uni\\polisportiva\\polisportiva\\src\\main\\resources\\it\\unife\\ip\\json\\atleti.json");
        try {
            atleti = readFromJson(file, Atleta.class);
        } catch (IOException e) {
            atleti = FXCollections.observableArrayList();
            e.printStackTrace();
        }
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dataNascita"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("numeroTelefono"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        adressColumn.setCellValueFactory(new PropertyValueFactory<>("indirizzo"));
        activityColumn.setCellValueFactory(cellData -> {
            ObservableList<String> activities = FXCollections.observableArrayList();
            for (Attivita_Sp activity : cellData.getValue().getAttivita()) {
                activities.add(activity.getNome());
            }
            return new SimpleObjectProperty<>(activities);
        });
        atletiTable.setItems(atleti);

        Platform.runLater( () -> {
            double width = atletiTable.getWidth();
            double percent = 0.1225;
            double newWidth = width * percent;
            nameColumn.setPrefWidth(newWidth);
            lastNameColumn.setPrefWidth(newWidth);
            dateColumn.setPrefWidth(newWidth);
            phoneColumn.setPrefWidth(newWidth);
            emailColumn.setPrefWidth(newWidth);
            adressColumn.setPrefWidth(newWidth);
            activityColumn.setPrefWidth(newWidth);                
        });

        nameColumn.setOnEditCommit(event -> {
            Atleta atleta = event.getRowValue();
            atleta.setNome(event.getNewValue());
        });
        lastNameColumn.setOnEditCommit(event -> {
            Atleta atleta = event.getRowValue();
            atleta.setCognome(event.getNewValue());
        });
        dateColumn.setOnEditCommit(event -> {
            Atleta atleta = event.getRowValue();
            atleta.setDataNascita(event.getNewValue());
        });
        phoneColumn.setOnEditCommit(event -> {
            Atleta atleta = event.getRowValue();
            atleta.setNumeroTelefono(event.getNewValue());
        });
        emailColumn.setOnEditCommit(event -> {
            Atleta atleta = event.getRowValue();
            atleta.setEmail(event.getNewValue());
        });
        adressColumn.setOnEditCommit(event -> {
            Atleta atleta = event.getRowValue();
            atleta.setIndirizzo(event.getNewValue());
        });

        addButton(file);

    }    
    
    @FXML
    public void modify(){
        ObservableList<Atleta> atleta = atletiTable.getItems();
        try {
            File file = new File("C:\\Users\\user\\Documents\\uni\\triennale\\2. anno\\Linguaggi di programmazione\\Polisportiva_Uni\\polisportiva\\polisportiva\\src\\main\\resources\\it\\unife\\ip\\json\\atleti.json");
            saveToJson(atleta, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Data saved to JSON.");
    }
    
    @FXML
    public void add() throws IOException{
        App.setRoot("atletaForm");
    }

    private void addButton(File file){
        Callback<TableColumn<Atleta, Void>,TableCell<Atleta, Void>> cellFactory = new Callback<TableColumn<Atleta, Void>,TableCell<Atleta, Void>>() {
            @Override
            public TableCell<Atleta,Void> call(final TableColumn<Atleta,Void> param){
                final TableCell<Atleta,Void> cell = new TableCell<Atleta,Void>() {
                    private final Button btn = new Button("Delete");
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            
                            try {
                                Atleta attivitaSp = getTableView().getItems().get(getIndex());
                                deleteFromJson(file, attivitaSp, Atleta.class);
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