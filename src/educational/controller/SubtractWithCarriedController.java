package educational.controller;

import educational.model.FileUtils;
import educational.record.Record;
import educational.record.SubtractWithCarriedRecord;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

import static educational.controller.MainMenuController.player;
/**
 * Class for controller subtractWithCarriedScene
 * Inheritance SubtractsController
 * @see SubtractsController
 */
public class SubtractWithCarriedController extends SubtractsController {
    /**
     * Initialize the scene
     * @param url scene's path
     * @param resourceBundle
     */
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
                    if(SubtractWithCarriedRecord.checkSubtractWithCarriedRecord(
                            player.getName(), count, records)){
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
     * Method for set random numbers for SubtractWithCarried
     */
    @Override
    public void setNumbers(){
        do{
            number1 = (int) (Math.floor(Math.random() * (0 - 1000 + 1) + 1000));
            number2 = (int) (Math.floor(Math.random() * (0 - 1000 + 1) + 1000));

        }while((number1 < number2) || (number1 % 100 > number2 % 100)
                                   || (number1 % 10 > number2 % 10));
        setNumber1(number1);
        setNumber2(number2);
    }
}
