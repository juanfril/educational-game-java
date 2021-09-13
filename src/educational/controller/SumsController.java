package educational.controller;

import educational.model.FileUtils;
import educational.record.Record;
import educational.record.SumsRecord;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static educational.controller.MainMenuController.player;

/**
 * Class for controller sumsScene
 * Inheritance GeneralController
 * @see GeneralController
 */
public class SumsController extends GeneralController {

    @FXML
    private Label lbPlayer;
    @FXML
    private Label lbNumber1;
    @FXML
    private Label lbNumber2;
    @FXML
    private TextField txtResult;
    @FXML
    private Button btnResult;
    private Random random = new Random();
    private int number1, number2, result;
    private byte count = 0;
    Stage stage;
    private ArrayList<Record> records = new ArrayList<>(FileUtils.loadRecords());

    /**
     * Initialize the scene
     * @param url scene's path
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lbPlayer.setText("Go " + player.getName() + "!");
        number1 = (int)(Math.floor(Math.random()*(0-1000+1)+1000));
        number2 = (int)(Math.floor(Math.random()*(0-1000+1)+1000));

        lbNumber1.setText(String.valueOf(number1));
        lbNumber2.setText(String.valueOf(number2));

        btnResult.setOnAction(actionEvent -> {
            try{
                result = Integer.parseInt(txtResult.getText());
                if(result == number1 + number2){
                    count++;
                    dialog.setHeaderText("Information");
                    dialog.setContentText("Correct");
                    dialog.showAndWait();

                    number1 = (int)(Math.floor(Math.random()*(0-1000+1)+1000));
                    number2 = (int)(Math.floor(Math.random()*(0-1000+1)+1000));

                    lbNumber1.setText(String.valueOf(number1));
                    lbNumber2.setText(String.valueOf(number2));

                    txtResult.setText("");
                } else{
                    if(SumsRecord.checkSumsRecord(player.getName(), count, records)){
                        dialog.setHeaderText("Information");
                        dialog.setContentText("You fail!\nRight result: " + (number1 + number2) +
                                "\n You won a new Record!! " + count);
                        dialog.showAndWait();
                        stage = (Stage) this.lbNumber1.getScene().getWindow();
                        stage.close();
                    }else{
                        dialog.setHeaderText("Information");
                        dialog.setContentText("You fail!\nRight result: " + (number1 + number2) +
                                "\n Your score is: " + count);
                        dialog.showAndWait();
                        stage = (Stage) this.lbNumber1.getScene().getWindow();
                        stage.close();
                    }
                }
            } catch (Exception e) {
                dialog.setHeaderText("Information");
                dialog.setContentText(String.valueOf(e));
                dialog.showAndWait();
            }
        });
    }
}
