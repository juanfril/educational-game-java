package educational.controller;

import educational.model.FileUtils;
import educational.record.Record;
import educational.record.SubtractRecord;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import static educational.controller.MainMenuController.player;

/**
 * Class for controller subtractScene
 * Inheritance GeneralController
 * @see GeneralController
 */
public class SubtractsController extends GeneralController {
    @FXML
    protected Label lbPlayer;
    @FXML
    protected Label lbNumber1;
    @FXML
    protected Label lbNumber2;
    @FXML
    protected TextField txtResult;
    @FXML
    protected Button btnResult;
    protected Random random = new Random();
    protected int number1, number2, result;
    protected byte count = 0;
    protected Stage stage;
    protected ArrayList<Record> records = new ArrayList<>();
    /**
     * Establishes number1
     * @param number1 A int for subtract
     */
    public void setNumber1(int number1) {
        this.number1 = number1;
    }
    /**
     * Establishes number2
     * @param number2 A int for subtract
     */
    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        records = FileUtils.loadRecords();
        lbPlayer.setText("Go " + player.getName() + "!");
        setNumbers();

        lbNumber1.setText(String.valueOf(number1));
        lbNumber2.setText(String.valueOf(number2));

        btnResult.setOnAction(actionEvent -> {
            try {
                result = Integer.parseInt(txtResult.getText());
                if (result == number1 - number2) {
                    count++;
                    dialog.setHeaderText("Information");
                    dialog.setContentText("Correct");
                    dialog.showAndWait();

                    setNumbers();

                    lbNumber1.setText(String.valueOf(number1));
                    lbNumber2.setText(String.valueOf(number2));

                    txtResult.setText("");
                } else {
                    if(SubtractRecord.checkSubtractRecord(player.getName(), count, records)){
                        dialog.setHeaderText("Information");
                        dialog.setContentText("You fail!\nRight result: " + (number1 - number2) +
                                "\nYou won a new Record!! " + count);
                        dialog.showAndWait();
                        stage = (Stage) this.lbNumber1.getScene().getWindow();
                        stage.close();
                    }else{
                        dialog.setHeaderText("Information");
                        dialog.setContentText("You fail!\nRight result: " + (number1 - number2) +
                                "\nYour score is: " + count);
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
    /**
     * Method for set random numbers for Subtract
     */
    @Override
    public void setNumbers(){
        do{
            number1 = (int) (Math.floor(Math.random() * (0 - 1000 + 1) + 1000));
            number2 = (int) (Math.floor(Math.random() * (0 - 1000 + 1) + 1000));

        }while((number1 < number2) || (number1 % 100 < number2 % 100)
                                   || (number1 % 10 < number2 % 10));
        setNumber1(number1);
        setNumber2(number2);
    }
}
