package educational.controller;

import educational.model.FileUtils;
import educational.record.HowManyRecord;
import educational.record.Record;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import static educational.controller.MainMenuController.player;
/**
 * Class for controller howManyAreThereScene
 * Inheritance GeneralController
 * @see GeneralController
 */
public class HowManyAreThereController extends GeneralController{
    @FXML
    private Label lbPlayer;
    @FXML
    private Label lbText;
    @FXML
    private Button btnAnswer;
    @FXML
    private TextField tbResult;
    @FXML
    private Circle circle1, circle2, circle3, circle4, circle5,
        circle6, circle7, circle8, circle9, circle10;
    private ArrayList<Circle> circles = new ArrayList<Circle>();
    private Random random = new Random();
    private int howMany, result;
    private byte count;
    Stage stage;
    private ArrayList<Record> records = new ArrayList<>(FileUtils.loadRecords());
    /**
     * Initialize the scene
     * @param url scene's path
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        circles.add(circle1);
        circles.add(circle2);
        circles.add(circle3);
        circles.add(circle4);
        circles.add(circle5);
        circles.add(circle6);
        circles.add(circle7);
        circles.add(circle8);
        circles.add(circle9);
        circles.add(circle10);

        lbPlayer.setText("Go " + player.getName() + "!");
        howMany = (int)(Math.floor(Math.random()*(0-10+1)+10));
        count = 0;

        hideCircles(circles);

        btnAnswer.setOnAction(actionEvent->{
            try{
                result = Integer.parseInt(tbResult.getText());
                if(result == howMany){
                    count++;
                    dialog.setHeaderText("Information");
                    dialog.setContentText("Correct");
                    dialog.showAndWait();

                    howMany = (int)(Math.floor(Math.random()*(0-10+1)+10));
                    hideCircles(circles);

                    tbResult.setText("");
                } else{
                    if(HowManyRecord.checkHowManyRecord(player.getName(), count, records)){
                        dialog.setHeaderText("Information");
                        dialog.setContentText("You fail!\nRight result: " + howMany +
                                "\n You won a new Record!! " + count);
                        dialog.showAndWait();
                        stage = (Stage) this.lbText.getScene().getWindow();
                        stage.close();
                    }else{
                        dialog.setHeaderText("Information");
                        dialog.setContentText("You fail!\nRight result: " + howMany +
                                "\n Your score is: " + count);
                        dialog.showAndWait();
                        stage = (Stage) this.lbText.getScene().getWindow();
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
     * Method for hide the circles
     * @param circles A ArrayList with the circles
     */
    private void hideCircles(ArrayList<Circle> circles){
        for (int i = 0; i < circles.size(); i++) {
            circles.get(i).setVisible(false);
        }
        for (int i = 0; i < howMany; i++) {
            circles.get(i).setVisible(true);
        }
    }

}
