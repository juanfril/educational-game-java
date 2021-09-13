package educational.controller;

import educational.model.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

//import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Class for controller mainMenuScene
 */
public class MainMenuController extends GeneralController {

    @FXML
    private Button btnRanking;
    @FXML
    private TextField txtAge;
    @FXML
    private TextField txtName;
    @FXML
    private Button btnGo;
    /**
     * Static player to be able to check score into others classes
     */
    public static Player player;
    private byte age;
    /**
     * Initialize the scene
     * @param url scene's path
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnGo.setOnAction(actionEvent -> {
            try{
                age = Byte.parseByte(txtAge.getText());
                player = new Player(txtName.getText(), age);
                Parent root;
                Stage stage = new Stage();

                if(age > 3){
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                            "/educational/scene/olderScene.fxml")));
                    stage.setTitle("Older than 3 menu");
                } else {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                            "/educational/scene/underScene.fxml")));
                    stage.setTitle("Under than 3 menu");
                }
                stage.setScene(new Scene(root, 600, 400));
                stage.show();
            }catch (Exception exception){
                dialog.setHeaderText("Information");
                dialog.setContentText("Age must be a number (0-10)");
                dialog.showAndWait();
            }
        });
        btnRanking.setOnAction(actionEvent ->{
            Parent root;
            Stage stage = new Stage();
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                        "/educational/scene/scoreScene.fxml")));
                stage.setTitle("Score");
                stage.setScene(new Scene(root, 600, 400));
                stage.show();
            } catch (IOException e) {
                dialog.setHeaderText("ERROR");
                dialog.setContentText(String.valueOf(e));
                dialog.showAndWait();
            }
        });
    }
}
