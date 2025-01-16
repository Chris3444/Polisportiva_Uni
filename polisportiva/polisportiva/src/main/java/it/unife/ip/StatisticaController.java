package it.unife.ip;

import static it.unife.ip.util.JsonUtil.readFromJson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import it.unife.ip.model.Atleta;
import it.unife.ip.model.Attivita_Sp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

public class StatisticaController {
    
    @FXML
    private PieChart pieChart;

    private ObservableList<PieChart.Data> pieChartData;
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void initialize(){
        ObservableList<Atleta> atleta;
        try {
            File file = new File("C:\\Users\\user\\Documents\\uni\\triennale\\2. anno\\Linguaggi di programmazione\\Polisportiva_Uni\\polisportiva\\polisportiva\\src\\main\\resources\\it\\unife\\ip\\json\\atleti.json");
            atleta = readFromJson(file, Atleta.class);
        } catch (Exception e) {
            atleta = FXCollections.observableArrayList();
            e.printStackTrace();
        }
        ArrayList<String> attivita = new ArrayList<>();
        for(Atleta a : atleta){
            for( Attivita_Sp at : a.getAttivita()){
                attivita.add(at.getNome());
            }
        }
        Map<String,Integer> countActivity = new HashMap<>();
        for (String value : attivita) {
            countActivity.put(value, countActivity.getOrDefault(value, 0) + 1);
        }
        System.out.println(countActivity);
        pieChartData = FXCollections.observableArrayList();
        for(Map.Entry<String, Integer> entry : countActivity.entrySet()){
            String name = entry.getKey() +": " +entry.getValue();
            int value = entry.getValue();

            pieChartData.add(new PieChart.Data(name,value));    
            
        }
        pieChart.setData(pieChartData);
        


    }

    
    
}
