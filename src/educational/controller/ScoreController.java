package educational.controller;

import educational.model.FileUtils;
import educational.record.Record;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Class for controller scoreScene
 * Inheritance GeneralController
 * @see GeneralController
 */
public class ScoreController extends GeneralController{

    @FXML
    private ListView lvRanking = new ListView();
    @FXML
    private Button btnBack;
    Stage stage;
    private ArrayList<Record> records;
    ObservableList<Record> observableList;

    /**
     * Initialize the scene
     * @param url scene's path
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        records = new ArrayList<Record>(FileUtils.loadRecords());
        observableList = FXCollections.observableArrayList(records);
        lvRanking.setItems(observableList);
        btnBack.setOnAction(actionEvent -> {
            stage = (Stage) this.btnBack.getScene().getWindow();
            stage.close();
        });
    }


}
